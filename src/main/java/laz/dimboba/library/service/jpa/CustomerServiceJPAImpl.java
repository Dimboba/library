package laz.dimboba.library.service.jpa;

import laz.dimboba.library.exceptions.AlreadyExistsException;
import laz.dimboba.library.exceptions.NotFoundException;
import laz.dimboba.library.dao.CustomerRepository;
import laz.dimboba.library.entity.Customer;
import laz.dimboba.library.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerServiceJPAImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    @Override
    public Customer getCustomer(UUID customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundException("Customer with id = " + customerId + " not found"));
    }

    @Override
    public List<Customer> getCustomersByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findAllByFirstNameContainingIgnoreCaseAAndLastNameContainingIgnoreCase(
                firstName,
                lastName
        );
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        if(customerRepository.existsById(customer.getId())){
            throw new AlreadyExistsException("Customer with id = " + customer.getId() + " already exists");
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(!customerRepository.existsById(customer.getId())){
            throw new NotFoundException("Customer with id = " + customer.getId() + " not found");
        }
        return customerRepository.save(customer);
    }
}
