package com.radek.bikerentals.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "bike_repairs")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BikeRepair extends AbstractEntity {

    private LocalDateTime datetime;
    private String description;
    private BigDecimal cost;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bike_id")
    private Bike bike;
}
