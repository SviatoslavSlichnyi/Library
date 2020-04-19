package com.sviatoslav.library.controller.mapper;

import com.sviatoslav.library.entity.Author;
import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.BookForm;
import com.sviatoslav.library.entity.Media;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book map(BookForm bookForm) {
        Author author = Author.builder()
                .firstName(bookForm.getAuthorFirstName())
                .lastName(bookForm.getAuthorLastName())
                .build();
        author.generateAndSetId();

        Media hardcoverFile = new MediaMapper().map(bookForm.getHardcoverFile());
        Media bookFile = new MediaMapper().map(bookForm.getBookFile());

        return Book.builder()
                .id(bookForm.getId())
                .name(bookForm.getName())
                .author(author)
                .publisher(bookForm.getPublisher())
                .publicationYear(bookForm.getPublicationYear())
                .numberOfPages(bookForm.getNumberOfPages())
                .language(bookForm.getLanguage())
                .description(bookForm.getDescription())
                .hardcoverFile(hardcoverFile)
                .bookFile(bookFile)
                .build();
    }

    public BookForm map(Book book) {
        BookForm bookForm = new BookForm();
        bookForm.setId(book.getId());
        bookForm.setName(book.getName());
        bookForm .setAuthorFirstName(book.getAuthor().getFirstName());
        bookForm.setAuthorLastName(book.getAuthor().getLastName());
        bookForm.setPublisher(book.getPublisher());
        bookForm.setPublicationYear(book.getPublicationYear());
        bookForm.setNumberOfPages(book.getNumberOfPages());
        bookForm.setLanguage(book.getLanguage());
        bookForm.setDescription(book.getDescription());
        bookForm.setHardcoverFile(new MediaMapper().map(book.getHardcoverFile()));
        bookForm.setBookFile(new MediaMapper().map(book.getBookFile()));

        return bookForm;
    }
}
