package com.api.customers.controllers;

import com.api.customers.models.CreditCard;
import com.api.customers.services.credit.CreditServiceImpl;
import com.api.customers.services.creditCard.CreditCardServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/credit-card")
@Slf4j
@Tag(name = "CreditCard")
public class CreditCardController {

    @Autowired
    private CreditCardServiceImpl creditCardService;

    @Operation(
            summary = "Listado de tarjetas de crédito.",
            description = "Listado de todas las tarjetas de crédito en la base de datos.")
    @GetMapping
    public Flux<CreditCard> ListCreditCard(){
        return creditCardService.findAll();
    }

    @Operation(
            summary = "Obtener tarjeta de crédito.",
            description = "Obtener una tarjeta de crédito por ID.")
    @GetMapping("/{id}")
    public Mono<CreditCard> CreditCardById(@PathVariable String id){
        return creditCardService.findById(id);
    }

    @Operation(
            summary = "Creación de tarjeta de crédito.",
            description = "Crear una tarjeta de crédito en la BD.")
    @PostMapping
    public Mono<CreditCard> CreateCreditCard(@RequestBody CreditCard data){
        return creditCardService.save(data);
    }

    @Operation(
            summary = "Actualizar tarjeta crédito.",
            description = "Actualizar una tarjeta de crédito en la BD.")
    @PutMapping("/{id}")
    public Mono<CreditCard> UpdateCreditCard(@PathVariable String id, @RequestBody CreditCard data){
        return creditCardService.findById(id).flatMap(c -> {
            c.setId(data.getId());
            c.setNumber_card(data.getNumber_card());
            c.setCredit_limit(data.getCredit_limit());
            c.setType(data.getType());
            return creditCardService.save(c);
        });
    }

    @Operation(
            summary = "Eliminar tarjeta de crédito.",
            description = "Eliminar una tarjeta de crédito de la BD.")
    @DeleteMapping("/{id}")
    public Mono<Void> DeleteCreditCard(@PathVariable String id){
        return creditCardService.deleteById(id);
    }
}
