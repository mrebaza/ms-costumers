package com.ms.customers.services.creditCard;

import com.ms.customers.models.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {

    Flux<CreditCard> findAll();
    Mono<CreditCard> findById(String id);
    Mono<CreditCard> save(CreditCard data);
    Mono<Void> deleteById(String id);

}
