package com.sviatoslav.library.controller.validator;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.Media;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;

@Component
public class BookValidator implements Validator {

    private static final MediaType[] HARDCOVER_TYPES = {
            MediaType.IMAGE_JPEG,
            MediaType.IMAGE_PNG
    };
    private static final MediaType[] BOOK_TYPES = {
            MediaType.TEXT_PLAIN,
            MediaType.APPLICATION_PDF
    };

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "validator.book-form.name.not.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "authorFirstName",
                "validator.book-form.author-first-name.not.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "authorLastName",
                "validator.book-form.author-last-name.not.empty");


        Book book = (Book) target;

        Media hardcoverFile = book.getHardcoverFile();
        Media bookFile = book.getBookFile();

        String hardcoverRejectValue = "hardcoverFile";
        String bookFileRejectValue = "bookFile";

        if (hardcoverFile.isEmpty()) {
            errors.rejectValue(hardcoverRejectValue, "validator.file.not.empty");
        } else {
            validateMediaType(errors, hardcoverRejectValue, hardcoverFile, HARDCOVER_TYPES);
        }

        if (bookFile.isEmpty()) {
            errors.rejectValue(bookFileRejectValue, "validator.file.not.empty");
        } else {
            validateMediaType(errors, bookFileRejectValue, bookFile, BOOK_TYPES);
        }

    }

    private void validateMediaType(Errors errors, String rejectValue, Media file, MediaType[] mediaTypes) {
        String fileContentType = file.getContentType();
         if (fileContentType == null) {
            throw new NullPointerException(String.format("MultipartFile %s has null contentType",
                    file.getOriginalFilename()));
        }

        List<MediaType> allowedTypes = Arrays.asList(mediaTypes);
        MediaType hardcoverFileMediaType = MediaType.valueOf(fileContentType);
        if (!allowedTypes.contains(hardcoverFileMediaType)) {
            errors.rejectValue(rejectValue, "validator.file-type.not.supported");
        }
    }
}
