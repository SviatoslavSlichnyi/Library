package com.sviatoslav.library.controller.mapper;

import com.sviatoslav.library.entity.Author;
import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.Media;
import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.form.BookForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class BookMapper {

    private final AuthorMapper authorMapper;
    private final MediaMapper mediaMapper;

    public Book map(BookForm bookForm, User user) {
        String authorFirstName = bookForm.getAuthorFirstName();
        String authorLastName = bookForm.getAuthorLastName();

        Author author = authorMapper.map(authorFirstName, authorLastName);

        Media hardcoverFile = mediaMapper.map(bookForm.getHardcoverFile());
        Media bookFile = mediaMapper.map(bookForm.getBookFile());

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
                .user(user)
                .build();
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
                .user(book.getUser())
                .build();
    }
}
