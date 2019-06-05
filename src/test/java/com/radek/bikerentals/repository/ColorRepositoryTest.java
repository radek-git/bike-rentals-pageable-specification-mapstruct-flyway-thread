package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ColorRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ColorRepository colorRepository;

    @Test
    public void shouldSaveColor() {
        Color color = new Color("purple");

        testEntityManager.persistAndFlush(color);

        Optional<Color> colorTest = colorRepository.findById(color.getId());
        assertEquals(true, colorTest.isPresent());
        assertEquals("purple", colorTest.get().getName());

    }

    @Test
    public void shouldFindColorByName() {
        Color color = new Color("purple");

        testEntityManager.persistAndFlush(color);

        Optional<Color> colorTest = colorRepository.findByName(color.getName());
        assertEquals(true, colorTest.isPresent());
        assertEquals("purple", colorTest.get().getName());
    }


    @Test
    public void shouldNotSaveTheSameColors() {
        Color color1 = new Color("blue");
        Color color2 = new Color("blue");

        testEntityManager.persistAndFlush(color1);

        assertThrows(PersistenceException.class, () -> {
            testEntityManager.persistAndFlush(color2);
        });
    }

}
