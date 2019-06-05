package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.RentalDTO;
import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.Color;
import com.radek.bikerentals.entity.Rental;
import com.radek.bikerentals.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RentalMapperTest {

    private RentalMapper rentalMapper = new RentalMapperImpl();

    @Test
    public void shouldMapRentalToDTO() {
        //given
        User user1 = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));
        Color color = new Color("blue");
        LocalDateTime now = LocalDateTime.now();
        Bike bike = new Bike("12345", false, now.toLocalDate(), color);

        Rental rental = new Rental(user1, bike, now, now.plusHours(1L), "1.1", "2.2",
                "3.1", "3.2", new BigDecimal("2"));

        //when
        RentalDTO rentalDTO = rentalMapper.toDTO(rental);

        //then
        assertEquals(user1.getId(), rentalDTO.getUserId());
        assertEquals(bike.getId(), rentalDTO.getBikeId());
        assertEquals(now, rentalDTO.getStartedAt());
        assertEquals(now.plusHours(1L), rentalDTO.getFinishedAt());
        assertEquals("1.1", rentalDTO.getStartLatitude());
        assertEquals("2.2", rentalDTO.getStartLongitude());
        assertEquals("3.1", rentalDTO.getEndLatitude());
        assertEquals("3.2", rentalDTO.getEndLongitude());

    }


    @Test
    public void shouldMapRentalListToDTO() {
        //given
        User user1 = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));
        Color color = new Color("blue");
        LocalDateTime now = LocalDateTime.now();
        Bike bike = new Bike("12345", false, now.toLocalDate(), color);

        Rental rental = new Rental(user1, bike, now, now.plusHours(1L), "1.1", "2.2",
                "3.1", "3.2", new BigDecimal("2"));
        Rental renta2 = new Rental(user1, bike, now, now.plusHours(1L), "1.1", "2.2",
                "3.1", "3.2", new BigDecimal("2"));

        List<Rental> rentals = List.of(rental, renta2);

        //when
        List<RentalDTO> rentalDTOList = rentalMapper.toDTO(rentals);

        //then
        assertEquals(user1.getId(), rentalDTOList.get(0).getUserId());
        assertEquals(user1.getId(), rentalDTOList.get(1).getUserId());
        assertEquals(bike.getId(), rentalDTOList.get(1).getBikeId());
        assertEquals(bike.getId(), rentalDTOList.get(0).getBikeId());
        assertEquals(now, rentalDTOList.get(0).getStartedAt());
        assertEquals(now.plusHours(1L), rentalDTOList.get(0).getFinishedAt());
        assertEquals("1.1", rentalDTOList.get(0).getStartLatitude());
        assertEquals("2.2", rentalDTOList.get(0).getStartLongitude());
        assertEquals("3.1", rentalDTOList.get(0).getEndLatitude());
        assertEquals("3.2", rentalDTOList.get(0).getEndLongitude());
        assertEquals("2", rentalDTOList.get(0).getPrice().toString());
        assertEquals("2", rentalDTOList.get(1).getPrice().toString());
    }
}
