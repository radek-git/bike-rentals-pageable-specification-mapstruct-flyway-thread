package com.radek.bikerentals.controller;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(APIController.class)  //przy takim zapisie wstanie tylko testowany kontroller
//@WebMvcTest - przy takim zapisie wstaną wszystkie kontrollery
public class APIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/api/hello")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(CoreMatchers.containsString("Hello")));
    }
}