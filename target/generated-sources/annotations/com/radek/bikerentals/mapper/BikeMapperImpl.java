package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.BikeDTO;
import com.radek.bikerentals.entity.Bike;
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
public class BikeMapperImpl extends BikeMapper {

    @Override
    public BikeDTO toDTO(Bike bike) {
        if ( bike == null ) {
            return null;
        }

        BikeDTO bikeDTO = new BikeDTO();

        bikeDTO.setColor( bikeColorName( bike ) );
        bikeDTO.setId( bike.getId() );
        bikeDTO.setSerialNumber( bike.getSerialNumber() );
        bikeDTO.setDateOfProduction( bike.getDateOfProduction() );
        bikeDTO.setBusy( bike.isBusy() );
        bikeDTO.setCreatedAt( bike.getCreatedAt() );
        bikeDTO.setUpdatedAt( bike.getUpdatedAt() );

        return bikeDTO;
    }

    @Override
    public List<BikeDTO> toDTO(List<Bike> bikes) {
        if ( bikes == null ) {
            return null;
        }

        List<BikeDTO> list = new ArrayList<BikeDTO>( bikes.size() );
        for ( Bike bike : bikes ) {
            list.add( toDTO( bike ) );
        }

        return list;
    }

    @Override
    public List<Bike> toEntity(List<BikeDTO> bikeDTOList) {
        if ( bikeDTOList == null ) {
            return null;
        }

        List<Bike> list = new ArrayList<Bike>( bikeDTOList.size() );
        for ( BikeDTO bikeDTO : bikeDTOList ) {
            list.add( toEntity( bikeDTO ) );
        }

        return list;
    }

    private String bikeColorName(Bike bike) {
        if ( bike == null ) {
            return null;
        }
        Color color = bike.getColor();
        if ( color == null ) {
            return null;
        }
        String name = color.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
