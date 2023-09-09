package laz.dimboba.library.dao;

import laz.dimboba.library.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    List<Customer> findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
            String firstName,
            String lastName
            );
}
