package com.radek.bikerentals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO implements Serializable {

    private Long id;

    private Long userId;
    private Long bikeId;

    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private String startLatitude;
    private String startLongitude;
    private String endLatitude;
    private String endLongitude;
    private BigDecimal price;



}
