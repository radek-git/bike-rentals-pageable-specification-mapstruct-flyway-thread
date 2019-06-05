package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.PricingDTO;
import com.radek.bikerentals.entity.Pricing;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PricingMapperTest {

    private PricingMapper pricingMapper = new PricingMapperImpl();


    @Test
    public void shouldMapPricingToDTO() {
        //given
        Pricing pricing = new Pricing("1h", new BigDecimal("5"));

        //when
        PricingDTO pricingDTO = pricingMapper.toDTO(pricing);

        //then
        assertEquals("1h", pricingDTO.getName());
        assertEquals("5", pricingDTO.getPrice().toString());
    }

    @Test
    public void shouldMapPricingListToDTO() {
        //given
        Pricing pricing1 = new Pricing("1h", new BigDecimal("5"));
        Pricing pricing2 = new Pricing("2h", new BigDecimal("5"));
        List<Pricing> pricings = List.of(pricing1, pricing2);
        pricing1.setId(1L);
        pricing2.setId(2L);

        //when
        List<PricingDTO> pricingDTOList = pricingMapper.toDTO(pricings);

        //then
        assertEquals("1h", pricingDTOList.get(0).getName());
        assertEquals("2h", pricingDTOList.get(1).getName());
        assertEquals("5", pricingDTOList.get(0).getPrice().toString());
        assertEquals("5", pricingDTOList.get(1).getPrice().toString());
        assertEquals(1L, pricingDTOList.get(0).getId().longValue());
        assertEquals(2L, pricingDTOList.get(1).getId().longValue());

    }


}
