package com.ms.customers.repositorys;

import com.ms.customers.models.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepo extends ReactiveMongoRepository<Credit, String> {
}
