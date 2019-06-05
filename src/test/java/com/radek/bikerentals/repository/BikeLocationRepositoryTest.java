package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BikeLocationRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BikeLocationRepository bikeLocationRepository;


    @Test
    public void shouldFindBikeLocationById () {
        LocalDateTime now = LocalDateTime.now();

        Color color = new Color("blue");
        Bike bike = new Bike("12345", false, now.toLocalDate(), color);

        User user1 = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));

        Rental rental = new Rental(user1, bike, now, now.plusHours(1L), "1.1", "2.2",
                "3.1", "3.2", new BigDecimal("2"));

        BikeLocation bikeLocation = new BikeLocation("1.2", "2.3", bike, now, rental);

        testEntityManager.persistAndFlush(color);
        testEntityManager.persistAndFlush(bike);
        testEntityManager.persistAndFlush(user1);
        testEntityManager.persistAndFlush(rental);
        testEntityManager.persistAndFlush(bikeLocation);

        Optional<BikeLocation> optionalBikeLocation = bikeLocationRepository.findById(bikeLocation.getId());
        assertTrue(optionalBikeLocation.isPresent());
        assertEquals("1.2", optionalBikeLocation.get().getLatitude());
        assertEquals("2.3", optionalBikeLocation.get().getLongitude());
        assertEquals(bike, optionalBikeLocation.get().getBike());
        assertEquals(now, optionalBikeLocation.get().getDatetime());
        assertEquals(rental, optionalBikeLocation.get().getRental());

    }

}