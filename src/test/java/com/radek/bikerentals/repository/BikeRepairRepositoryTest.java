package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.BikeRepair;
import com.radek.bikerentals.entity.Color;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BikeRepairRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BikeRepairRepository bikeRepairRepository;


    @Test
    public void shouldReturnBikeRepairById() {
        LocalDateTime now = LocalDateTime.now();
        Color color = new Color("blue");
        Bike bike = new Bike("12345", false, now.toLocalDate(), color);
        BikeRepair bikeRepair = new BikeRepair(now, "cos tam", new BigDecimal(10), bike);

        testEntityManager.persistAndFlush(color);
        testEntityManager.persistAndFlush(bike);
        testEntityManager.persistAndFlush(bikeRepair);


        Optional<BikeRepair> optionalBikeRepair = bikeRepairRepository.findById(bikeRepair.getId());
        assertEquals(true, optionalBikeRepair.isPresent());
    }




}