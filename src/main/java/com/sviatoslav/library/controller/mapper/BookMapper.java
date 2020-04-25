package com.sviatoslav.library.controller.mapper;

import com.sviatoslav.library.entity.Author;
import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.Media;
import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.form.BookForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor

@Component
@Slf4j
public class BookMapper {

    private final MediaMapper mediaMapper;

    public Book map(Book book, BookForm bookForm) {
        book.setName(bookForm.getName());
        book.setPublisher(bookForm.getPublisher());
        book.setPublicationYear(bookForm.getPublicationYear());
        book.setNumberOfPages(bookForm.getNumberOfPages());
        book.setLanguage(bookForm.getLanguage());
        book.setDescription(bookForm.getDescription());

        book.getAuthor().setFirstName(bookForm.getAuthorFirstName());
        book.getAuthor().setLastName(bookForm.getAuthorLastName());

        MultipartFile hardcoverFile = bookForm.getHardcoverFile();
        if (!hardcoverFile.isEmpty()) {
            log.debug("book.hardcover is empty");
            book.setHardcoverFile(mediaMapper.map(hardcoverFile));
        }

        MultipartFile bookFile = bookForm.getBookFile();
        if (!bookFile.isEmpty()) {
            log.debug("book.bookFile is empty");
            book.setBookFile(mediaMapper.map(bookFile));
        }

        return book;
    }

    public Book map(BookForm bookForm, User user) {
        Book book = Book.builder()
                .user(user)
                .author(new Author())
                .bookFile(new Media())
                .hardcoverFile(new Media())
                .build();

        return map(book, bookForm);
    }

    public BookForm map(Book book) {
        return BookForm.builder()
                .id(book.getId())
                .name(book.getName())
                .authorFirstName(book.getAuthor().getFirstName())
                .authorLastName(book.getAuthor().getLastName())
                .publisher(book.getPublisher())
                .publicationYear(book.getPublicationYear())
                .numberOfPages(book.getNumberOfPages())
                .language(book.getLanguage())
                .description(book.getDescription())
                .hardcoverFile(mediaMapper.map(book.getHardcoverFile()))
                .bookFile(mediaMapper.map(book.getBookFile()))
                .build();
    }
}
