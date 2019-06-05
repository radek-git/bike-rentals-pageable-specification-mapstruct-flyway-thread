package com.radek.bikerentals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

import javax.persistence.Column;
import java.io.Serializable;

@Mapper(componentModel = "spring")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColorDTO implements Serializable {

    private Long id;

    @Column(unique = true)
    private String name;
}

