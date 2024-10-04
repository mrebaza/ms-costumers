package com.api.customers.services.credit;
import com.api.customers.models.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {

    public Flux<Credit> findAll();
    public Mono<Credit> findById(String id);
    public Mono<Credit> save(Credit data);
    public Mono<Void> deleteById(String id);
}
