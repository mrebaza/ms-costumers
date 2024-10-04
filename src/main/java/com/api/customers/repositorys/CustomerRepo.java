package com.api.customers.repositorys;

import com.api.customers.models.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends ReactiveMongoRepository<Customer, String> {
}
