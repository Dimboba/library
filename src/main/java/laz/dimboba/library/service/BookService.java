package laz.dimboba.library.service;

import laz.dimboba.library.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {

    Book getBook(UUID bookId);

    List<Book> getBooksByTitleAndAuthor(
            String title,
            String author
    );

    Book saveBook(Book book);

    Book updateBook(Book book);


}
