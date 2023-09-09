package laz.dimboba.library.service.jpa;

import laz.dimboba.library.entity.Customer;
import laz.dimboba.library.service.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CustomerServiceJPAImpl implements CustomerService {
    @Override
    public Optional<Customer> getCustomer(UUID customerId) {
        return Optional.empty();
    }

    @Override
    public List<Customer> getCustomersByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }
}
