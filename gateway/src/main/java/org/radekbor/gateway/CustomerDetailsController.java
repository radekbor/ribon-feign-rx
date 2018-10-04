package org.radekbor.gateway;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Mapping was changed due problems on zipkin
 */
@RestController
@RequestMapping(value = "/customer/details")
public class CustomerDetailsController {

    private static final Logger log = LoggerFactory.getLogger(CustomerDetailsController.class);

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private BooksClient booksClient;

    private Observable<Customer> makeRequestToServiceA(int customerId) {
        return Observable.fromCallable(() -> {
            log.info("customerClient.getClient");
            return customerClient.getClient(customerId);
        }); //some network call
    }

    private Observable<List<Book>> makeRequestToServiceB(int customerId) {
        return Observable.fromCallable(() -> {
                    log.info("booksClient.getBooks");
                    return booksClient.getBooks(customerId);
                }
        ); //some network call based on response from ServiceA
    }

    @GetMapping("/{customerId}")
    public Observable<Object> getDetails(@PathVariable("customerId") int customerId) {
        Observable<List<Book>> booksObervable = makeRequestToServiceB(customerId);
        Observable<Customer> customerObservable = makeRequestToServiceA(customerId);
        log.info("obervables are ready");
        return Observable.zip(
                customerObservable,
                booksObervable,
                (BiFunction<Customer, List<Book>, Object>) CustomerDetails::new);
    }
}
