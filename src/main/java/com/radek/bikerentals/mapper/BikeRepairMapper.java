package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.BikeRepairDTO;
import com.radek.bikerentals.entity.BikeRepair;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BikeRepairMapper {

    @Mappings({
            @Mapping(target = "bike", source = "bike.serialNumber")
    })
    BikeRepairDTO toDTO(BikeRepair bikeRepair);

    List<BikeRepairDTO> toDTO(List<BikeRepair> bikeRepairs);

//    BikeRepair toEntity(BikeRepairDTO bikeRepairDTO);
//
//    List<BikeRepair> toEntity(List<BikeRepairDTO> bikeRepairDTOS);


}
