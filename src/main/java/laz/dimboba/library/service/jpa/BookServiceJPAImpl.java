package laz.dimboba.library.service.jpa;

import laz.dimboba.library.exceptions.AlreadyExistException;
import laz.dimboba.library.exceptions.NotFoundException;
import laz.dimboba.library.dao.BookRepository;
import laz.dimboba.library.entity.Book;
import laz.dimboba.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceJPAImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book getBook(UUID bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book with id = " + bookId + " not found"));
    }

    @Override
    public List<Book> getBooksByTitleAndAuthor(String title, String author) {
        return bookRepository.findAllByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(
                title,
                author
        );
    }

    @Override
    public Book saveBook(Book book) {
        if(bookRepository.existsById(book.getId())){
            throw new AlreadyExistException("Book with id = " + book.getId() + " already exists");
        }
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        if(!bookRepository.existsById(book.getId())){
            throw new NotFoundException("Book with id = " + book.getId() + " not found");
        }
        return bookRepository.save(book);
    }
}
