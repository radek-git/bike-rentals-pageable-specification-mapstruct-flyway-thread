package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.BikeLocationDTO;
import com.radek.bikerentals.entity.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BikeLocationMapperTest {

    private BikeLocationMapper bikeLocationMapper = new BikeLocationMapperImpl();

    @Test
    public void shouldMapBikeLocationToDTO() {
        //given
        User user1 = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));
        Color color = new Color("blue");
        LocalDateTime now = LocalDateTime.now();

        Bike bike = new Bike("12345", false, now.toLocalDate(), color);

        Rental rental = new Rental(user1, bike, now, now.plusHours(1L), "1.1", "2.2",
                "3.1", "3.2", new BigDecimal("2"));
        BikeLocation bikeLocation = new BikeLocation("1.1", "2.2", bike, now, rental);

        //when
        BikeLocationDTO bikeLocationDTO = bikeLocationMapper.toDTO(bikeLocation);

        //then
        assertEquals("1.1", bikeLocationDTO.getLatitude());
        assertEquals("2.2", bikeLocationDTO.getLongitude());
        assertEquals(bike, bikeLocationDTO.getBike());

    }


    @Test
    public void shouldMapBikeLocationListToDTO() {
        //given
        LocalDateTime now = LocalDateTime.now();
        User user1 = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));
        Color color = new Color("blue");

        Bike bike = new Bike("12345", false, now.toLocalDate(), color);

        Rental rental = new Rental(user1, bike, now, now.plusHours(1L), "1.1", "2.2",
                "3.1", "3.2", new BigDecimal("2"));
        BikeLocation bikeLocation1 = new BikeLocation("1.1", "2.2", bike, now, rental);
        BikeLocation bikeLocation2 = new BikeLocation("1.8", "2.8", bike, now, rental);

        List<BikeLocation> bikeLocationList = List.of(bikeLocation1, bikeLocation2);

        //when
        List<BikeLocationDTO> bikeLocationDTOList = bikeLocationMapper.toDTO(bikeLocationList);

        //then
        assertEquals("1.1", bikeLocationDTOList.get(0).getLatitude());
        assertEquals("1.8", bikeLocationDTOList.get(1).getLatitude());
        assertEquals("2.2", bikeLocationDTOList.get(0).getLongitude());
        assertEquals("2.8", bikeLocationDTOList.get(1).getLongitude());
        assertEquals(bike, bikeLocationDTOList.get(0).getBike());
        assertEquals(bike, bikeLocationDTOList.get(1).getBike());
        assertEquals(now, bikeLocationDTOList.get(0).getDatetime());

    }
}
