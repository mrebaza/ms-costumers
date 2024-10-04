package com.ms.customers.services.creditCard;

import com.ms.customers.models.CreditCard;
import com.ms.customers.repositorys.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepo creditCardRepo;

    @Override
    public Flux<CreditCard> findAll() {
        return creditCardRepo.findAll();
    }

    @Override
    public Mono<CreditCard> findById(String id) {
        return creditCardRepo.findById(id);
    }

    @Override
    public Mono<CreditCard> save(CreditCard data) {
        return creditCardRepo.save(data);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return creditCardRepo.deleteById(id);
    }
}
