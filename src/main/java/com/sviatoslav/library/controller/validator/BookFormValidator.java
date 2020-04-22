package com.sviatoslav.library.controller.validator;

import com.sviatoslav.library.entity.form.BookForm;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Component
public class BookFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BookForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "book.name.not.empty",
                "field has to be filled");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "authorFirstName",
                "book-form.author-first-name.not.empty",
                "field has to be filled");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "authorLastName",
                "book-form.author-last-name.not.empty",
                "field has to be filled");


        BookForm bookForm = (BookForm) target;

        MultipartFile hardcoverFile = bookForm.getHardcoverFile();
        MultipartFile bookFile = bookForm.getBookFile();

        String hardcoverContentType = hardcoverFile.getContentType();
        Optional<String> hardcoverFileTypeOpt = Optional.ofNullable(hardcoverContentType);
        if (hardcoverFile.isEmpty() || !hardcoverFileTypeOpt.isPresent()) {
            errors.rejectValue("hardcoverFile",
                    "book-form.upload-file.empty",
                    "can't be empty");
        } else {
            MediaType hardcoverFileMediaType = MediaType.valueOf(hardcoverContentType);

            if (!checkUploadedHardcoverFileType(hardcoverFileMediaType)) {
                errors.rejectValue("hardcoverFile",
                        "book-form.upload-file.empty",
                        "This type of file is not supported.");
            }
        }

        String bookContentType = bookFile.getContentType();
        Optional<String> bookType = Optional.ofNullable(bookContentType);
        if (bookFile.isEmpty() || !bookType.isPresent()) {
            errors.rejectValue("bookFile",
                    "book-form.upload-file.empty",
                    "can't be empty");
        } else {
            MediaType bookFileMediaType = MediaType.valueOf(bookContentType);

            if (!checkUploadedBookFileType(bookFileMediaType)) {
                errors.rejectValue("bookFile",
                        "book-form.upload-file.another-type",
                        "This type of file is not supported.");
            }
        }

    }

    private boolean checkUploadedHardcoverFileType(MediaType hardcoverType) {
        return hardcoverType.equals(MediaType.IMAGE_JPEG)
                || hardcoverType.equals(MediaType.IMAGE_PNG);
    }

    private boolean checkUploadedBookFileType(MediaType bookFileType) {
        return bookFileType.equals(MediaType.TEXT_PLAIN)
                || bookFileType.equals(MediaType.APPLICATION_PDF)
                || bookFileType.toString().equals(com.google.common.net.MediaType.EPUB.toString());
    }

}
