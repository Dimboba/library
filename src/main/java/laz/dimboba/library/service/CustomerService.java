package laz.dimboba.library.service;

import laz.dimboba.library.entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    Optional<Customer> getCustomer(UUID customerId);

    List<Customer> getCustomersByFirstNameAndLastName(
            String firstName,
            String lastName
    );

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Customer customer);
}
