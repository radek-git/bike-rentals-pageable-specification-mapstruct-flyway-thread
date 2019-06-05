package com.radek.bikerentals.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "rentals")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rental extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "bike_id", referencedColumnName = "id")
    private Bike bike;

    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private String startLatitude;
    private String startLongitude;
    private String endLatitude;
    private String endLongitude;
    private BigDecimal price;





}
