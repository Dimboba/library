package laz.dimboba.library.dao;

import laz.dimboba.library.entity.Book;
import laz.dimboba.library.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    List<Customer> findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
            String firstName,
            String lastName
            );

    @Query("SELECT c from Customer c INNER JOIN Order o ON c.id = o.customer.id " +
            "WHERE o.orderTimestamp >= :from AND o.returnTimestamp <= :to " +
            "group by c.id order by count(*) desc limit 1")
    Optional<Customer> findTheMostReadingCustomer(Timestamp from, Timestamp to);
}
