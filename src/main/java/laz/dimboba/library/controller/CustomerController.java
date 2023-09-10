package laz.dimboba.library.controller;

import laz.dimboba.library.dto.book.BookDTO;
import laz.dimboba.library.dto.customer.CustomerDTO;
import laz.dimboba.library.dto.customer.CustomerDTOMapper;
import laz.dimboba.library.entity.Customer;
import laz.dimboba.library.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerDTOMapper customerDTOMapper;

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(
            @RequestBody CustomerDTO customerDTO
    ) {
        return ResponseEntity.ok(
                customerDTOMapper.apply(
                        customerService.saveCustomer(
                                Customer.builder()
                                        .firstName(customerDTO.getFirstName())
                                        .lastName(customerDTO.getLastName())
                                        .gender(customerDTO.getGender())
                                        .build()
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(
                customerDTOMapper.apply(
                        customerService.getCustomer(id)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCustomersByName(
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "lastName", defaultValue = "") String lastName
    ){
        return ResponseEntity.ok(
                customerService.getCustomersByFirstNameAndLastName(
                        firstName,
                        lastName
                ).stream()
                        .map(customerDTOMapper::apply)
                        .toList()
        );
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> updateCustomer(
            @RequestBody CustomerDTO customerDTO
    ){
        return ResponseEntity.ok(
            customerDTOMapper.apply(
                customerService.updateCustomer(
                        Customer.builder()
                                .id(customerDTO.getId())
                                .firstName(customerDTO.getFirstName())
                                .lastName(customerDTO.getLastName())
                                .gender(customerDTO.getGender())
                                .build()
                )
            )
        );
    }
}
