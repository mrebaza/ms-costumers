package com.ms.customers.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "credit")
public class Credit {
    @Id
    private String id;

    @NotEmpty
    private float mount;

    @NotEmpty
    private float rateInterest;

    @NotEmpty
    private Type type;
}
