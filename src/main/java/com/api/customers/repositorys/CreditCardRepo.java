package com.api.customers.repositorys;

import com.api.customers.models.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepo extends ReactiveMongoRepository<CreditCard, String> {
}
