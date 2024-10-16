package com.ms.customers.services.customer;

import com.ms.customers.models.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Flux<Customer> findAll();
    Mono<Customer> findById(String id);
    Mono<Customer> save(Customer data);
    Mono<Void> deleteById(String id);
}
