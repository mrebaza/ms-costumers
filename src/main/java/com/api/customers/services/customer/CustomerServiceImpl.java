package com.api.customers.services.customer;

import com.api.customers.models.Customer;
import com.api.customers.repositorys.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo clienteRepo;

    @Override
    public Flux<Customer> findAll() {
        return clienteRepo.findAll();
    }

    @Override
    public Mono<Customer> findById(String id) {
        return clienteRepo.findById(id);
    }

    @Override
    public Mono<Customer> save(Customer data) {
        return clienteRepo.save(data);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clienteRepo.deleteById(id);
    }

}
