package com.radek.bikerentals.controller;

import com.radek.bikerentals.entity.Color;
import com.radek.bikerentals.service.ColorService;
import com.radek.bikerentals.utils.JSONUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ColorController.class)
public class ColorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //mockować można Beany (MockBean) i nie Beany(Mock)

    @MockBean
    private ColorService colorService;

//    @Test
//    public void findAll() throws Exception {
//        List<Color> colors = List.of(
//          new Color("blue"),
//          new Color("red")
//        );
//
//        // PageRequest.of(0, 20)
//
//        when(colorService.findAll(PageRequest.of(0, 20))).thenReturn(colors);
//
//        mockMvc.perform(get("/api/colors")).andDo(print()).andExpect(status().isOk())
//        .andExpect(content().json(JSONUtils.toJsonString(colors)));
//    }

    //mockujemy service zakłądając, że on dobrze działa.
    //warstwa aplikacji z servicem nie została wybudzona i nie można wstrzykiwać niczego
    //poza rzeczami któe powiązane są z @WebMvcTest(ColorController.class), czyli tylko MockMvc

}