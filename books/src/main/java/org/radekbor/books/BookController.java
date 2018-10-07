package org.radekbor.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    private List<Book> books = new ArrayList<>();

    {
        books.add(new Book(1, "Harry Potter 1", 1));
        books.add(new Book(2, "Lord of the Rings", 1));
        books.add(new Book(3, "Hobbit", 2));
        books.add(new Book(4, "Alice in wonderland", 3));
    }

    @GetMapping("/books")
    public List<Book> bookList() {
        log.info("getting all books");
        return books;
    }

    @GetMapping("/books/user/{userId}")
    public List<Book> getUserBooks(@PathVariable("userId") int userId) {
        log.info("getting user books {}", userId);
        return books.stream().filter(book -> book.getCustomer() == userId).collect(Collectors.toList());
    }
}
