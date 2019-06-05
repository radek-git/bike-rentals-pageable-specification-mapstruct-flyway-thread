package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.Color;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

public class BikeRepositoryTest1 {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private TestEntityManager testEntityManager;



    @Test
    public void shouldFindBikeById() {
        Color color = new Color("blue");
        LocalDate localDate = LocalDate.now();
        Bike bike = new Bike("12345", false, localDate, color);

        testEntityManager.persistAndFlush(color);
        testEntityManager.persistAndFlush(bike);

        Optional<Bike> optionalBike = bikeRepository.findById(bike.getId());

        assertThat(bike, samePropertyValuesAs(optionalBike.get()));

    }
}
