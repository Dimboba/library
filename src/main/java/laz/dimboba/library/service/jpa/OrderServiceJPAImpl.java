package laz.dimboba.library.service.jpa;

import laz.dimboba.library.entity.Order;
import laz.dimboba.library.service.OrderService;

import java.util.Optional;
import java.util.UUID;

public class OrderServiceJPAImpl implements OrderService {
    @Override
    public Optional<Order> getOrder(UUID id) {
        return Optional.empty();
    }

    @Override
    public Order createOrder(UUID customerId, UUID orderId) {
        return null;
    }

    @Override
    public void returnBook(UUID orderId) {

    }
}
