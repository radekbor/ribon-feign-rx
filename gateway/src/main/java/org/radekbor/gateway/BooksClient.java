package org.radekbor.gateway;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "book-service")
public interface BooksClient {

    @GetMapping("/books/user/{customerId}")
    List<Book> getBooks(@PathVariable("customerId") int customerId);
}
