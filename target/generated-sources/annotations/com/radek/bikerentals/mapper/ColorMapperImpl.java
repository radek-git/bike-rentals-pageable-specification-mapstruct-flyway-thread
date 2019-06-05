package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.ColorDTO;
import com.radek.bikerentals.entity.Color;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-03T19:19:17+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12 (Oracle Corporation)"
)
@Component
public class ColorMapperImpl implements ColorMapper {

    @Override
    public ColorDTO toDTO(Color color) {
        if ( color == null ) {
            return null;
        }

        ColorDTO colorDTO = new ColorDTO();

        colorDTO.setId( color.getId() );
        colorDTO.setName( color.getName() );

        return colorDTO;
    }

    @Override
    public List<ColorDTO> colorsDTO(List<Color> colors) {
        if ( colors == null ) {
            return null;
        }

        List<ColorDTO> list = new ArrayList<ColorDTO>( colors.size() );
        for ( Color color : colors ) {
            list.add( toDTO( color ) );
        }

        return list;
    }

    @Override
    public Color toEntity(ColorDTO colorDTO) {
        if ( colorDTO == null ) {
            return null;
        }

        Color color = new Color();

        color.setId( colorDTO.getId() );
        color.setName( colorDTO.getName() );

        return color;
    }
}
