package laz.dimboba.library.service.jpa;

import laz.dimboba.library.Exceptions.NotFoundException;
import laz.dimboba.library.dao.BookRepository;
import laz.dimboba.library.entity.Book;
import laz.dimboba.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceJPAImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book getBook(UUID id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("There is no book with id = " + id));
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
