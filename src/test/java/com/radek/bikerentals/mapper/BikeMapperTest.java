package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.BikeDTO;
import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BikeMapperTest {

    private BikeMapper bikeMapper = new BikeMapperImpl();

    @Test
    public void shouldMapBikeToBikeDTO () {
        //given
        Color color = new Color("red");
        LocalDate localDate = LocalDate.now();
        Bike bike = new Bike("12345", false, localDate, color);
        bike.setId(1L);

        //when
        BikeDTO bikeDTO = bikeMapper.toDTO(bike);

        //then
        assertEquals(1L, bikeDTO.getId().longValue());
        assertEquals("12345", bikeDTO.getSerialNumber());
        assertEquals(false, bikeDTO.isBusy());
        assertEquals(localDate, bikeDTO.getDateOfProduction());
        assertEquals("red", bikeDTO.getColor());
    }

    @Test
    public void shouldMapBikeListToBikeListDTO() {
        //given
        Color color = new Color("red");
        LocalDate localDate = LocalDate.now();
        Bike bike1 = new Bike("12345", false, localDate, color);
        Bike bike2 = new Bike("22345", true, localDate, color);
        List<Bike> bikes = List.of(bike1, bike2);

        //when
        List<BikeDTO> bikeDTOList = bikeMapper.toDTO(bikes);

        //then
        assertEquals("12345", bikeDTOList.get(0).getSerialNumber());
        assertEquals("22345", bikeDTOList.get(1).getSerialNumber());
        assertFalse(bikeDTOList.get(0).isBusy());
        assertFalse(bikeDTOList.get(1).isBusy());
        assertEquals("red", bikeDTOList.get(0).getColor());
        assertEquals("red", bikeDTOList.get(1).getColor());

    }

}
