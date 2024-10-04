package com.ms.customers.services.credit;

import com.ms.customers.models.Credit;
import com.ms.customers.repositorys.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService{

    @Autowired
    private CreditRepo creditRepo;

    @Override
    public Flux<Credit> findAll() {
        return creditRepo.findAll();
    }

    @Override
    public Mono<Credit> findById(String id) {
        return creditRepo.findById(id);
    }

    @Override
    public Mono<Credit> save(Credit data) {
        return creditRepo.save(data);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return creditRepo.deleteById(id);
    }
}
