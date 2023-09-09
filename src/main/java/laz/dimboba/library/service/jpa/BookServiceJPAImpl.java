package laz.dimboba.library.service.jpa;

import laz.dimboba.library.entity.Book;
import laz.dimboba.library.service.BookService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookServiceJPAImpl implements BookService {
    @Override
    public Optional<Book> getBook(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Book> getBooksByTitleAndAuthor(String title, String author) {
        return null;
    }

    @Override
    public Book saveBook(Book book) {
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }
}
