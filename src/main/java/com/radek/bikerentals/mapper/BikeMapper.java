package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.BikeDTO;
import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.Color;
import com.radek.bikerentals.repository.ColorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BikeMapper {

    private ColorRepository colorRepository;

    @Autowired //wstrzykiwanie w mapperach mapstruct tylko za pomocą setterów
    public void setColorRepository(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Mappings({
            @Mapping(target = "color", source = "color.name")
    })
    public abstract BikeDTO toDTO(Bike bike);

    public abstract List<BikeDTO> toDTO(List<Bike> bikes);

    public Bike toEntity(BikeDTO bikeDTO) {
        if ( bikeDTO == null ) {
            return null;
        }

        Bike bike = new Bike();

        bike.setId( bikeDTO.getId() );
        bike.setSerialNumber( bikeDTO.getSerialNumber() );
        bike.setDateOfProduction( bikeDTO.getDateOfProduction() );
        bike.setColor(colorRepository.findByName(bikeDTO.getColor()).orElseThrow(() ->
                new RuntimeException("Nie ma takiego koloru")));
        bike.setCreatedAt( bikeDTO.getCreatedAt() );
        bike.setUpdatedAt( bikeDTO.getUpdatedAt() );

        return bike;
    }

    public abstract List<Bike> toEntity(List<BikeDTO> bikeDTOList);

}
