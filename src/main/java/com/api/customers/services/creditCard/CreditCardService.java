package com.api.customers.services.creditCard;

import com.api.customers.models.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {

    public Flux<CreditCard> findAll();
    public Mono<CreditCard> findById(String id);
    public Mono<CreditCard> save(CreditCard data);
    public Mono<Void> deleteById(String id);

}
