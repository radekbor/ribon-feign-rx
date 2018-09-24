package org.radekbor.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerDetailsController {

    private static final Logger log = LoggerFactory.getLogger(CustomerDetailsController.class);

    @Autowired
    private CustomerClient customerClient;

    @GetMapping("/customer/{customerId}")
    public CustomerDetails getDetails(@PathVariable("customerId") int customerId) {
        Customer customer = customerClient.getClient(customerId);
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Book", customerId));
        CustomerDetails result = new CustomerDetails(customer, books);
        return result;
    }
}
