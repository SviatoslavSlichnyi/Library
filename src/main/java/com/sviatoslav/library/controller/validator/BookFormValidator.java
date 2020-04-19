package com.sviatoslav.library.controller.validator;

import com.sviatoslav.library.entity.BookForm;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class BookFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BookForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        BookForm bookForm = (BookForm) target;

        String hardcoverContentType = bookForm.getHardcoverFile().getContentType();
        Optional<String> hardcoverFileTypeOpt = Optional.ofNullable(hardcoverContentType);
        if (!hardcoverFileTypeOpt.isPresent()) {
            errors.rejectValue("hardcoverFile",
                    "book-form.upload-file.empty",
                    "must not be empty");
        } else {
            MediaType hardcoverFileMediaType = MediaType.valueOf(hardcoverContentType);

            if (!checkUploadedHardcoverFileType(hardcoverFileMediaType)) {
                errors.rejectValue("hardcoverFile",
                        "book-form.upload-file.empty",
                        "This type of file is not supported.");
            }
        }

        String bookContentType = bookForm.getBookFile().getContentType();
        Optional<String> bookType = Optional.ofNullable(bookContentType);
        if (!bookType.isPresent()) {
            errors.rejectValue("bookFile",
                    "book-form.upload-file.empty",
                    "must not be empty");
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
