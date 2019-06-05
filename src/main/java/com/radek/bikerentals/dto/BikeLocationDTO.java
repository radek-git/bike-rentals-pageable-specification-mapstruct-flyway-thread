package com.radek.bikerentals.dto;

import com.radek.bikerentals.entity.Bike;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BikeLocationDTO implements Serializable {

    private Long id;
    private String latitude;
    private String longitude;
    private Bike bike;
    private LocalDateTime datetime;
}
