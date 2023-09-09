package laz.dimboba.library.service.jpa;

import laz.dimboba.library.exceptions.NotFoundException;
import laz.dimboba.library.dao.OrderRepository;
import laz.dimboba.library.entity.Book;
import laz.dimboba.library.entity.Customer;
import laz.dimboba.library.entity.Order;
import laz.dimboba.library.service.BookService;
import laz.dimboba.library.service.CustomerService;
import laz.dimboba.library.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceJPAImpl implements OrderService {
    private final BookService bookService;
    private final CustomerService customerService;
    private final OrderRepository orderRepository;
    @Override
    public Order getOrder(UUID orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order with id = " + orderId + " not found"));
    }

    @Override
    public Order createOrder(UUID customerId, UUID bookId) {
        Book book = bookService.getBook(bookId);
        Customer customer = customerService.getCustomer(customerId);

        Order order = Order.builder()
                .book(book)
                .customer(customer)
                .build();

        return orderRepository.save(order);
    }

    @Override
    public void returnBook(UUID orderId) {
        Order order = getOrder(orderId);

        order.setReturned(true);
        order.setReturnTimestamp(Timestamp.from(Instant.now()));

        orderRepository.save(order);
    }
}
