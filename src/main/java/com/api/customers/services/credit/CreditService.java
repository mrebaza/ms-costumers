package com.api.customers.services.credit;
import com.api.customers.models.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {

    Flux<Credit> findAll();
    Mono<Credit> findById(String id);
    Mono<Credit> save(Credit data);
    Mono<Void> deleteById(String id);
}
