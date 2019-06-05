package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.BikeLocationDTO;
import com.radek.bikerentals.entity.BikeLocation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-03T19:19:16+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12 (Oracle Corporation)"
)
@Component
public class BikeLocationMapperImpl implements BikeLocationMapper {

    @Override
    public BikeLocationDTO toDTO(BikeLocation bikeLocation) {
        if ( bikeLocation == null ) {
            return null;
        }

        BikeLocationDTO bikeLocationDTO = new BikeLocationDTO();

        bikeLocationDTO.setId( bikeLocation.getId() );
        bikeLocationDTO.setLatitude( bikeLocation.getLatitude() );
        bikeLocationDTO.setLongitude( bikeLocation.getLongitude() );
        bikeLocationDTO.setBike( bikeLocation.getBike() );
        bikeLocationDTO.setDatetime( bikeLocation.getDatetime() );

        return bikeLocationDTO;
    }

    @Override
    public List<BikeLocationDTO> toDTO(List<BikeLocation> bikeLocations) {
        if ( bikeLocations == null ) {
            return null;
        }

        List<BikeLocationDTO> list = new ArrayList<BikeLocationDTO>( bikeLocations.size() );
        for ( BikeLocation bikeLocation : bikeLocations ) {
            list.add( toDTO( bikeLocation ) );
        }

        return list;
    }

    @Override
    public BikeLocation toEntity(BikeLocationDTO bikeLocationDTO) {
        if ( bikeLocationDTO == null ) {
            return null;
        }

        BikeLocation bikeLocation = new BikeLocation();

        bikeLocation.setId( bikeLocationDTO.getId() );
        bikeLocation.setLatitude( bikeLocationDTO.getLatitude() );
        bikeLocation.setLongitude( bikeLocationDTO.getLongitude() );
        bikeLocation.setBike( bikeLocationDTO.getBike() );
        bikeLocation.setDatetime( bikeLocationDTO.getDatetime() );

        return bikeLocation;
    }

    @Override
    public List<BikeLocation> toEntity(List<BikeLocationDTO> bikeLocationDTOList) {
        if ( bikeLocationDTOList == null ) {
            return null;
        }

        List<BikeLocation> list = new ArrayList<BikeLocation>( bikeLocationDTOList.size() );
        for ( BikeLocationDTO bikeLocationDTO : bikeLocationDTOList ) {
            list.add( toEntity( bikeLocationDTO ) );
        }

        return list;
    }
}
