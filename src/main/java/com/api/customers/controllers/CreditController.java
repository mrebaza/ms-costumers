package com.api.customers.controllers;

import com.api.customers.models.Credit;
import com.api.customers.repositorys.CreditRepo;
import com.api.customers.services.credit.CreditService;
import com.api.customers.services.credit.CreditServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/credits")
@Slf4j
@Tag(name = "Credits")
public class CreditController {

    @Autowired
    private CreditServiceImpl creditService;

    @Operation(
            summary = "Listado de créditos.",
            description = "Listado de todos los créditos creados en la base de datos.")
    @GetMapping
    public Flux<Credit> ListCredits(){
        return creditService.findAll();
    }

    @Operation(
            summary = "Obtener crédito.",
            description = "Obtener un crédito por ID.")
    @GetMapping("/{id}")
    public Mono<Credit> CreditById(@PathVariable String id){
        return creditService.findById(id);
    }

    @Operation(
            summary = "Creación de crédito.",
            description = "Crear un crédito en la BD.")
    @PostMapping
    public Mono<Credit> CreateCredit(@RequestBody Credit data){
        return creditService.save(data);
    }

    @Operation(
            summary = "Actualizar crédito.",
            description = "Actualizar un crédito en la BD.")
    @PutMapping("/{id}")
    public Mono<Credit> UpdateCredit(@PathVariable String id, Credit data){
        return creditService.findById(id).flatMap(c -> {
            c.setId(data.getId());
            c.setMount(data.getMount());
            c.setType(data.getType());
            c.setRateInterest(data.getRateInterest());
            return creditService.save(c);
        });
    }

    @Operation(
            summary = "Eliminar crédito.",
            description = "Eliminar un crédito de la BD.")
    @DeleteMapping("/{id}")
    public Mono<Void> DeleteCredit(@PathVariable String id){
        return creditService.deleteById(id);
    }

}
