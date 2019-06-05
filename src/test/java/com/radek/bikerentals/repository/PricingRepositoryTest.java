package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.Pricing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PricingRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PricingRepository pricingRepository;

    @Test
    public void shouldFindPricingById() {
        Pricing pricing = new Pricing("1 hour", new BigDecimal("5"));

        testEntityManager.persistAndFlush(pricing);

        Optional<Pricing> pricingTest = pricingRepository.findById(pricing.getId());
        assertEquals(true, pricingTest.isPresent());
    }


    @Test
    public void shouldNotSaveTheSamePricings () {
        Pricing pricing1 = new Pricing("1 hour", new BigDecimal("5"));
        Pricing pricing2 = new Pricing("1 hour", new BigDecimal("5"));

        testEntityManager.persistAndFlush(pricing1);

        assertThrows(PersistenceException.class, () -> {
        testEntityManager.persistAndFlush(pricing2);

         });
    }

}