package com.api.customers.services.customer;

import com.api.customers.models.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    public Flux<Customer> findAll();
    public Mono<Customer> findById(String id);
    public Mono<Customer> save(Customer data);
    public  Mono<Void> deleteById(String id);
}
