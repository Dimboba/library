package laz.dimboba.library.service;

import laz.dimboba.library.entity.Order;

import java.util.UUID;

public interface OrderService {

    Order getOrder(UUID orderId);

    Order createOrder(
            UUID customerId,
            UUID bookId
    );

    Order returnBook(
            UUID customerId,
            UUID bookId
    );

    Order returnBook(UUID orderId);
}
