package laz.dimboba.library.dto.order;

import laz.dimboba.library.entity.Book;
import laz.dimboba.library.entity.Customer;
import laz.dimboba.library.entity.Order;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class OrderDTOMapper implements Function<Order, OrderDTO> {

    @Override
    public OrderDTO apply(Order key) {
        Book book = key.getBook();
        Customer customer = key.getCustomer();

        return new OrderDTO(
                key.getId(),
                key.isReturned(),
                key.getOrderTimestamp(),
                key.getReturnTimestamp(),
                new OrderDTO.BookInfo(
                        book.getId(),
                        book.getAuthor(),
                        book.getTitle()
                ),
                new OrderDTO.CustomerInfo(
                        customer.getId(),
                        customer.getFirstName(),
                        customer.getLastName()
                )
        );
    }
}
