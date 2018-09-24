package org.radekbor.customers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private List<Customer> all = new ArrayList<>();

    {
        all.add(new Customer(1, "John", "Doe"));
        all.add(new Customer(2, "Jane", "Doe"));
        all.add(new Customer(3, "Will", "Smith"));
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return all;
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") long customerId) {
        return all.stream().filter(customer -> customer.getId() == customerId)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Not found"));
    }
}
