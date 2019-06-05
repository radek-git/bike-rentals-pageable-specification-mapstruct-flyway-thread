package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.ColorDTO;
import com.radek.bikerentals.entity.Color;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColorMapper {


    ColorDTO toDTO(Color color);

    List<ColorDTO> colorsDTO(List<Color> colors);

    Color toEntity(ColorDTO colorDTO);
}
