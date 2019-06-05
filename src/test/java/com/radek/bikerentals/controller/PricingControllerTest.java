package com.radek.bikerentals.controller;


import com.radek.bikerentals.dto.PricingDTO;
import com.radek.bikerentals.entity.Pricing;
import com.radek.bikerentals.mapper.PricingMapper;
import com.radek.bikerentals.service.PricingService;
import com.radek.bikerentals.utils.JSONUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//przypadek z mapperem i servicem
public class PricingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricingService pricingService;

    //mapper wstrzykuje się sam

    @Autowired
    private PricingMapper pricingMapper;

    @Test
    public void shouldReturnList() throws Exception {
        List<Pricing> pricings = List.of(
                new Pricing("1 h", new BigDecimal("5")),
                new Pricing("2 h", new BigDecimal("10"))
        );

        List<PricingDTO> pricingDTOS = pricingMapper.toDTO(pricings);

        when(pricingService.findAll()).thenReturn(pricings);

        mockMvc.perform(get("/api/prices")).andExpect(status().isOk())
                .andExpect(content().json(JSONUtils.toJsonString(pricingDTOS, true)));

    }


    @Test
    public void shouldReturnPricingById() throws Exception {
        Pricing pricing = new Pricing("1h", new BigDecimal("5"));
        pricing.setId(2L);

        PricingDTO pricingDTO = pricingMapper.toDTO(pricing);

        when(pricingService.findById(2L)).thenReturn(pricing);

        mockMvc.perform(get("/api/prices/2")).andExpect(status().isOk())
                .andExpect(content().json(JSONUtils.toJsonString(pricingDTO, true)));
    }

//    @Test
//    public void shouldDeletePricingById() {
//        Pricing pricing = new Pricing("1h", new BigDecimal("5"));
//        pricing.setId(1L);
//
//        pricingService.save(pricing);
//
//        when(pricingService.deletePricingById(1L)).
//    }
}
