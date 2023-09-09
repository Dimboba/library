package laz.dimboba.library.service;

import laz.dimboba.library.entity.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderService {

    Optional<Order> getOrder(UUID id);

    Order createOrder(
            UUID customerId,
            UUID orderId
    );

    void returnBook(UUID orderId);
}
