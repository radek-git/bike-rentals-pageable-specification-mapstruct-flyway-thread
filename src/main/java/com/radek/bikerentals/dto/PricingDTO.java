package com.radek.bikerentals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricingDTO implements Serializable {

    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    private BigDecimal price;
}
