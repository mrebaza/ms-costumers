package com.ms.customers.controllers;

import com.ms.customers.models.Customer;
import com.ms.customers.services.customer.CustomerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customers")
@Slf4j
@Tag(name = "Customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Operation(
            summary = "Listado de clientes.",
            description = "Listado de todos los clientes creados en la base de datos.")
    @GetMapping()
    public Flux<Customer> ListCustomers(){
        return customerService.findAll();
    }

    @Operation(
            summary = "Obtener cliente.",
            description = "Obtener un cliente por ID.")
    @GetMapping("/{id}")
    public Mono<Customer> CustomerById(@PathVariable String id){
        return customerService.findById(id);
    }

    @Operation(
            summary = "Creación de cliente.",
            description = "Crear un cliente en la BD.")
    @PostMapping
    public Mono<Customer> CreateCustomer(@RequestBody Customer data){
        return customerService.save(data);
    }

    @Operation(
            summary = "Actualizar cliente.",
            description = "Actualizar un cliente en la BD.")
    @PutMapping("/{id}")
    public Mono<Customer> UpdateCustomer(@PathVariable String id, Customer data){
        return customerService.findById(id)
                .flatMap(c-> {
                    c.setId(data.getId());
                    c.setName(data.getName());
                    return customerService.save(c);
                });
    }

    @Operation(
            summary = "Eliminar cliente.",
            description = "Eliminar un cliente de la BD.")
    @DeleteMapping("/{id}")
    public Mono<Void> DeleteCustomer(String id){
        return customerService.deleteById(id);
    }
}
