package com.api.customers.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "credit_card")
public class CreditCard {

    @Id
    private String id;

    @NotEmpty
    private String number_card;

    @NotEmpty
    private float credit_limit;

    @NotEmpty
    private Type type;
}
