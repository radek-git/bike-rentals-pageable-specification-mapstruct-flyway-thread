package com.radek.bikerentals.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "pricing")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pricing extends AbstractEntity {

    @Column(unique = true)
    private String name;

    private BigDecimal price;
}
