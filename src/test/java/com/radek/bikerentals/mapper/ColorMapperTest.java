package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.ColorDTO;
import com.radek.bikerentals.entity.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ColorMapperTest {


    private ColorMapper colorMapper = new ColorMapperImpl();


    @Test
    public void shouldMapColorToDTO() {
        Color color = new Color("blue");
        color.setId(500L);

        ColorDTO colorDTO = colorMapper.toDTO(color);

        assertEquals("blue", colorDTO.getName());
        assertEquals(500L, colorDTO.getId().longValue());
    }

}