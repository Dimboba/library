package laz.dimboba.library.dao;

import laz.dimboba.library.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Optional<Order> findFirstByBookIdAndCustomerIdAndReturnedIsFalse(
            UUID bookId,
            UUID customerId
    );
}
