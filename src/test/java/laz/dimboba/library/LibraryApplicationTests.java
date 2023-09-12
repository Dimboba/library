package laz.dimboba.library;

import laz.dimboba.library.entity.Book;
import laz.dimboba.library.entity.Customer;
import laz.dimboba.library.entity.Gender;
import laz.dimboba.library.entity.Order;
import laz.dimboba.library.exceptions.NotFoundException;
import laz.dimboba.library.service.BookService;
import laz.dimboba.library.service.CustomerService;
import laz.dimboba.library.service.OrderService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class LibraryApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    private Customer customerA, customerB;
    private Book book;

    @BeforeEach
    void setup() {
        customerA = Customer.builder()
                .firstName("a")
                .lastName("A")
                .gender(Gender.MALE)
                .build();


        customerB = Customer.builder()
                .firstName("a")
                .lastName("A")
                .gender(Gender.FEMALE)
                .build();

        book = Book.builder()
                .title("a")
                .author("A")
                .build();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void getCustomer() {

        assertThrowsExactly(
                NotFoundException.class,
                () -> customerService.getCustomer(UUID.randomUUID())
        );


        Customer newCustomer = customerService.saveCustomer(customerA);
        Customer findCustomer = customerService.getCustomer(newCustomer.getId());
        customerService.saveCustomer(customerB);

        assertEquals(newCustomer.getId(), findCustomer.getId());
        assertEquals(newCustomer.getFirstName(), findCustomer.getFirstName());
        assertEquals(newCustomer.getLastName(), findCustomer.getLastName());

    }

    @Test
    void updateCustomer() {
        Customer newCustomer = customerService.saveCustomer(customerA);

        customerA.setFirstName("AAA");
        customerA.setGender(Gender.FEMALE);

        customerService.updateCustomer(customerA);

        assertEquals(newCustomer.getId(), customerA.getId());
        assertEquals(newCustomer.getFirstName(), customerA.getFirstName());
        assertEquals(newCustomer.getLastName(), customerA.getLastName());

    }

    @Test
    void getBook() {

        assertThrowsExactly(
                NotFoundException.class,
                () -> bookService.getBook(UUID.randomUUID())
        );


        Book newBook = bookService.saveBook(book);
        Book findBook = bookService.getBook(newBook.getId());

        assertEquals(newBook.getId(), newBook.getId());
        assertEquals(newBook.getTitle(), newBook.getTitle());
        assertEquals(newBook.getAuthor(), newBook.getAuthor());

    }

    @Test
    void updateBook() {
        Book newBook = bookService.saveBook(book);

        book.setTitle("Hello");
        bookService.updateBook(book);

        assertEquals(newBook.getId(), book.getId());
        assertEquals(newBook.getTitle(), book.getTitle());
        assertEquals(newBook.getAuthor(), book.getAuthor());

    }

    @Test
    void order(){
        Customer newCustomer = customerService.saveCustomer(customerA);
        Book newBook = bookService.saveBook(book);


        Order newOrder = orderService.createOrder(
                newCustomer.getId(),
                newBook.getId()
        );

        Order findOrder = orderService.getOrder(newOrder.getId());

        assertEquals(newOrder.getId(), findOrder.getId());
        assertEquals(newOrder.getBook().getId(), findOrder.getBook().getId());
        assertEquals(newOrder.getCustomer().getId(), findOrder.getCustomer().getId());
        assertFalse(newOrder.isReturned());

        newOrder = orderService.returnBook(newOrder.getId());

        assertTrue(newOrder.isReturned());
    }

}
