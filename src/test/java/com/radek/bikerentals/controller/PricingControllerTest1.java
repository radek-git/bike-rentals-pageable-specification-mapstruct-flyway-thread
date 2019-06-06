package com.radek.bikerentals.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricingControllerTest1 {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricingService pricingService;

    @MockBean
    private PricingMapper pricingMapper;


    @Test
    public void shouldRetirnListOfPricing() throws Exception {
        List<Pricing> pricings = List.of(
                new Pricing("1h", new BigDecimal("5")),
                new Pricing("2h", new BigDecimal("10"))
        );

        List<PricingDTO> pricingDTOS = List.of(
                new PricingDTO("1h", new BigDecimal("5")),
                new PricingDTO("2h", new BigDecimal("10"))
        );

        when(pricingMapper.toDTO(pricings)).thenReturn(pricingDTOS);

        List<PricingDTO> dtos = pricingMapper.toDTO(pricings);

        when(pricingService.findAll()).thenReturn(pricings);

        mockMvc.perform(get("/api/prices")).andExpect(status().isOk())
                .andExpect(content().json(JSONUtils.toJsonString(dtos, true)));
    }

    @Test
    public void shouldReturnPricingById() throws Exception {
        Pricing pricing = new Pricing("1h", new BigDecimal("5"));

        PricingDTO pricingDTO = new PricingDTO("1h", new BigDecimal("5"));

        when(pricingMapper.toDTO(pricing)).thenReturn(pricingDTO);

        PricingDTO dto = pricingMapper.toDTO(pricing);

        when(pricingService.findById(1L)).thenReturn(pricing);

        mockMvc.perform(get("/api/prices/1")).andExpect(status().isOk())
                .andExpect(content().json(JSONUtils.toJsonString(dto, true)));
    }


    @Test
    public void saveIsOk() throws Exception {
        Pricing pricing = new Pricing("1h", new BigDecimal("5"));
        PricingDTO pricingDTO = new PricingDTO("1h", new BigDecimal("5"));

        when(pricingMapper.toDTO(pricing)).thenReturn(pricingDTO);

        PricingDTO dto = pricingMapper.toDTO(pricing);

        when(pricingService.save(pricing)).thenReturn(pricing);

        mockMvc.perform(post("/api/prices")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSONUtils.toJsonString(dto, false)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(JSONUtils.toJsonString(dto, true)));
    }
}
