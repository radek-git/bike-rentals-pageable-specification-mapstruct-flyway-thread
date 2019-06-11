package com.radek.bikerentals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BikeRepairDTO extends AbstractDTO{

    private LocalDateTime datetime;
    private String description;
    private BigDecimal cost;
    private String bike;
}
