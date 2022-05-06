package com.melita.task.domain;


import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class Order {
    @Valid
    @NotNull(message = "Field customerDetails must not be null")
    private CustomerDetails customerDetails;
    @Valid
    @NotNull(message = "Field product must not be null")
    private Product product;
}
