package org.radekbor.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "clients-service")
public interface CustomerClient {

    @GetMapping("/customers/{customerId}")
    Customer getClient(@PathVariable("customerId") int customerId);

}
