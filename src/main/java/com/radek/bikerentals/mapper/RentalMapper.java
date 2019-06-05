package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.RentalDTO;
import com.radek.bikerentals.entity.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface RentalMapper {

    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "bikeId", source = "bike.id")
    })
    RentalDTO toDTO(Rental rental);

    Set<RentalDTO> toDTO(Set<Rental> rentals);

    List<RentalDTO> toDTO(List<Rental> rentals);





    @Mappings({
            @Mapping(target = "user.id", source = "userId"),
            @Mapping(target = "bike.id", source = "bikeId")
    })
    Rental toEntity(RentalDTO rentalDTO);


}
