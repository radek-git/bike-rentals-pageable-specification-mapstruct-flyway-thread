package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.Color;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BikeRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BikeRepository bikeRepository;


    @Test
    public void shouldFindBikeById() {
        Color color = new Color("blue");
        LocalDate localDate = LocalDate.now();
        Bike bike = new Bike("12345", false, localDate, color);

        testEntityManager.persistAndFlush(color);
        testEntityManager.persistAndFlush(bike);

        Optional<Bike> optionalBike = bikeRepository.findById(bike.getId());
        assertTrue(optionalBike.isPresent());
        assertEquals("12345", optionalBike.get().getSerialNumber());
        assertFalse(optionalBike.get().isBusy());
        assertEquals(localDate, optionalBike.get().getDateOfProduction());
        assertEquals(color, optionalBike.get().getColor());

        //albo w 1 linijce (hamcrest)
        assertThat(bike, samePropertyValuesAs(optionalBike.get()));
    }

    @Test
    public void shouldFindBikeBySerialNumber() {
        LocalDateTime now = LocalDateTime.now();
        Color color = new Color("blue");
        Bike bike = new Bike("12345", false, now.toLocalDate(), color);

        testEntityManager.persistAndFlush(color);
        testEntityManager.persistAndFlush(bike);

        Optional<Bike> optionalBike = bikeRepository.findBySerialNumber(bike.getSerialNumber());
        assertThat(bike, samePropertyValuesAs(optionalBike.get()));
    }

}