package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.Color;
import com.radek.bikerentals.entity.Rental;
import com.radek.bikerentals.entity.User;
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
public class RentalRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private RentalRepository rentalRepository;


    @Test
    public void shouldReturnRentalById () {
        User user1 = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));
        Color color = new Color("blue");
        LocalDateTime now = LocalDateTime.now();
        Bike bike = new Bike("12345", false, now.toLocalDate(), color);

        Rental rental = new Rental(user1, bike, now, now.plusHours(1L), "1.1", "2.2",
                "3.1", "3.2", new BigDecimal("2"));

        testEntityManager.persistAndFlush(user1);
        testEntityManager.persistAndFlush(color);
        testEntityManager.persistAndFlush(bike);
        testEntityManager.persistAndFlush(rental);

        Optional<Rental> optionalRental = rentalRepository.findById(rental.getId());
        assertTrue(optionalRental.isPresent());
        assertEquals(user1, optionalRental.get().getUser());
        assertEquals(bike, optionalRental.get().getBike());
        assertEquals(now, optionalRental.get().getStartedAt());
        assertEquals("1.1", optionalRental.get().getStartLatitude());
        assertEquals("2.2", optionalRental.get().getStartLongitude());
        assertEquals("3.1", optionalRental.get().getEndLatitude());
        assertEquals("3.2", optionalRental.get().getEndLongitude());
        assertEquals("2", optionalRental.get().getPrice().toString());
    }


}
