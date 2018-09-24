package org.radekbor.gateway;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.List;

public class CustomerDetails {

    @JsonUnwrapped
    private Customer customer;

    private List<Book> books;

    public CustomerDetails(Customer customer, List<Book> books) {
        this.customer = customer;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Customer getCustomer() {
        return customer;
    }
}
