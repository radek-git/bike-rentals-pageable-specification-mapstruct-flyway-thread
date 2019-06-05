package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.BikeLocationDTO;
import com.radek.bikerentals.entity.BikeLocation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BikeLocationMapper {

    BikeLocationDTO toDTO (BikeLocation bikeLocation);

    List<BikeLocationDTO> toDTO(List<BikeLocation> bikeLocations);

    BikeLocation toEntity(BikeLocationDTO bikeLocationDTO);

    List<BikeLocation> toEntity(List<BikeLocationDTO> bikeLocationDTOList);
}
