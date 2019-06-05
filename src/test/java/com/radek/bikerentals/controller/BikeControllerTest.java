package com.radek.bikerentals.controller;

import com.radek.bikerentals.annotation.PageableDefaults;
import com.radek.bikerentals.dto.BikeDTO;
import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.Color;
import com.radek.bikerentals.mapper.BikeMapper;
import com.radek.bikerentals.service.BikeService;
import com.radek.bikerentals.utils.JSONUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BikeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BikeService bikeService;

    @MockBean
    private BikeMapper bikeMapper;


    @Test
    public void shouldReturnList() throws Exception {
        Color color = new Color("blue");
        LocalDateTime now = LocalDateTime.now();
        List<Bike> bikes = List.of(
                new Bike("12345", false, now.toLocalDate(), color),
                new Bike("13345", false, now.toLocalDate(), color)
        );

        List<BikeDTO> bikeDTOS = List.of(
                new BikeDTO("12345",  now.toLocalDate(), color.getName(), false),
                new BikeDTO("13345",  now.toLocalDate(), color.getName(), false)
        );

        when(bikeMapper.toDTO(bikes)).thenReturn(bikeDTOS);

        List<BikeDTO> bikeDTOList = bikeMapper.toDTO(bikes);

        when(bikeService.findAll(PageRequest.of(0, 50))).thenReturn(bikes);

        mockMvc.perform(get("/api/bikes")).andExpect(status().isOk())
                .andExpect(content().json(JSONUtils.toJsonString(bikeDTOList, true)));
    }


    @Test
    public void shouldReturnBikeBySerialNumber() throws Exception {
        Color color = new Color("blue");
        LocalDateTime now = LocalDateTime.now();
        Bike bike = new Bike("12345", false, now.toLocalDate(), color);
        BikeDTO dto = new BikeDTO("12345",now.toLocalDate(), color.getName(), false);

        when(bikeMapper.toDTO(bike)).thenReturn(dto);
        BikeDTO bikeDTO = bikeMapper.toDTO(bike);

        when(bikeService.findBySerialNumber("12345")).thenReturn(bike);

        mockMvc.perform(get("/api/bikes/12345")).andExpect(status().isOk())
                .andExpect(content().json(JSONUtils.toJsonString(bikeDTO, true)));
    }


    @Test
    public void saveBikeIsOk() throws Exception {
        Color color = new Color("white");
        LocalDateTime now = LocalDateTime.now().minusDays(30);
        Bike bike = new Bike("12345", false, now.toLocalDate(), color);
        BikeDTO dto = new BikeDTO("12345", now.toLocalDate(), color.getName(), false);

        when(bikeMapper.toDTO(bike)).thenReturn(dto);

        BikeDTO bikeDTO = bikeMapper.toDTO(bike);

        when(bikeMapper.toEntity(bikeDTO)).thenReturn(bike);
        when(bikeService.save(bike)).thenReturn(bike);

        mockMvc.perform(post("/api/bikes")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSONUtils.toJsonString(bikeDTO, false)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(JSONUtils.toJsonString(bikeDTO, true)));

    }




    }


