package org.radekbor.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RibbonClient(name = "book-service", configuration = ClientConfiguration.class)
public class CustomerDetailsController {

    private static final Logger log = LoggerFactory.getLogger(CustomerDetailsController.class);

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private BooksClient booksClient;

    @GetMapping("/customer/{customerId}")
    public CustomerDetails getDetails(@PathVariable("customerId") int customerId) {
        Customer customer = customerClient.getClient(customerId);
        List<Book> books = booksClient.getBooks(customerId);
        CustomerDetails result = new CustomerDetails(customer, books);
        return result;
    }
}
