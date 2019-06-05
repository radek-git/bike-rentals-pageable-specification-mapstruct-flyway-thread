package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.RentalDTO;
import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.Rental;
import com.radek.bikerentals.entity.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-03T19:19:17+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12 (Oracle Corporation)"
)
@Component
public class RentalMapperImpl implements RentalMapper {

    @Override
    public RentalDTO toDTO(Rental rental) {
        if ( rental == null ) {
            return null;
        }

        RentalDTO rentalDTO = new RentalDTO();

        rentalDTO.setBikeId( rentalBikeId( rental ) );
        rentalDTO.setUserId( rentalUserId( rental ) );
        rentalDTO.setId( rental.getId() );
        rentalDTO.setStartedAt( rental.getStartedAt() );
        rentalDTO.setFinishedAt( rental.getFinishedAt() );
        rentalDTO.setStartLatitude( rental.getStartLatitude() );
        rentalDTO.setStartLongitude( rental.getStartLongitude() );
        rentalDTO.setEndLatitude( rental.getEndLatitude() );
        rentalDTO.setEndLongitude( rental.getEndLongitude() );
        rentalDTO.setPrice( rental.getPrice() );

        return rentalDTO;
    }

    @Override
    public Set<RentalDTO> toDTO(Set<Rental> rentals) {
        if ( rentals == null ) {
            return null;
        }

        Set<RentalDTO> set = new HashSet<RentalDTO>( Math.max( (int) ( rentals.size() / .75f ) + 1, 16 ) );
        for ( Rental rental : rentals ) {
            set.add( toDTO( rental ) );
        }

        return set;
    }

    @Override
    public List<RentalDTO> toDTO(List<Rental> rentals) {
        if ( rentals == null ) {
            return null;
        }

        List<RentalDTO> list = new ArrayList<RentalDTO>( rentals.size() );
        for ( Rental rental : rentals ) {
            list.add( toDTO( rental ) );
        }

        return list;
    }

    @Override
    public Rental toEntity(RentalDTO rentalDTO) {
        if ( rentalDTO == null ) {
            return null;
        }

        Rental rental = new Rental();

        rental.setUser( rentalDTOToUser( rentalDTO ) );
        rental.setBike( rentalDTOToBike( rentalDTO ) );
        rental.setId( rentalDTO.getId() );
        rental.setStartedAt( rentalDTO.getStartedAt() );
        rental.setFinishedAt( rentalDTO.getFinishedAt() );
        rental.setStartLatitude( rentalDTO.getStartLatitude() );
        rental.setStartLongitude( rentalDTO.getStartLongitude() );
        rental.setEndLatitude( rentalDTO.getEndLatitude() );
        rental.setEndLongitude( rentalDTO.getEndLongitude() );
        rental.setPrice( rentalDTO.getPrice() );

        return rental;
    }

    private Long rentalBikeId(Rental rental) {
        if ( rental == null ) {
            return null;
        }
        Bike bike = rental.getBike();
        if ( bike == null ) {
            return null;
        }
        Long id = bike.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long rentalUserId(Rental rental) {
        if ( rental == null ) {
            return null;
        }
        User user = rental.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected User rentalDTOToUser(RentalDTO rentalDTO) {
        if ( rentalDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( rentalDTO.getUserId() );

        return user;
    }

    protected Bike rentalDTOToBike(RentalDTO rentalDTO) {
        if ( rentalDTO == null ) {
            return null;
        }

        Bike bike = new Bike();

        bike.setId( rentalDTO.getBikeId() );

        return bike;
    }
}
