package com.radek.bikerentals.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "bike_locations")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BikeLocation extends AbstractEntity {


    private String latitude;
    private String longitude;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "bike_id", referencedColumnName = "id")
    private Bike bike;

    private LocalDateTime datetime;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
