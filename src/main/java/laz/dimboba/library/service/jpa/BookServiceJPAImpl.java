package laz.dimboba.library.service.jpa;

import laz.dimboba.library.Exceptions.AlreadyExistException;
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
        return bookRepository.findAllByTitleAndAuthor(title, author);
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
