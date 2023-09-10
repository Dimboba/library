package laz.dimboba.library.dto.customer;

import laz.dimboba.library.entity.Book;
import laz.dimboba.library.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {

    @Override
    public CustomerDTO apply(Customer key) {

        List<CustomerDTO.OrderInfo> ordersInfo = new ArrayList<>();
        if(key.getOrders() != null) {
            ordersInfo = key.getOrders()
                    .stream()
                    .map(order -> {
                        Book book = order.getBook();
                        return new CustomerDTO.OrderInfo(
                                order.getId(),
                                order.isReturned(),
                                order.getOrderTimestamp(),
                                order.getReturnTimestamp(),
                                new CustomerDTO.BookInfo(
                                        book.getId(),
                                        book.getTitle(),
                                        book.getAuthor()
                                )
                        );
                    }).toList();
        }
        return new CustomerDTO(
                key.getId(),
                key.getFirstName(),
                key.getLastName(),
                key.getGender(),
                ordersInfo
        );
    }
}
