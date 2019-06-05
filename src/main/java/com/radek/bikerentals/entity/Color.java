package com.radek.bikerentals.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "bike_colors")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Color extends AbstractEntity{

    @Column(unique = true)
    private String name;
}
