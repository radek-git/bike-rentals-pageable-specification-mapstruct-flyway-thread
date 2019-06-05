package com.radek.bikerentals.controller;


import com.radek.bikerentals.dto.UserDTO;
import com.radek.bikerentals.entity.User;
import com.radek.bikerentals.mapper.UserMapper;
import com.radek.bikerentals.service.UserService;
import com.radek.bikerentals.utils.JSONUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @Test
    public void shouldReturnUserList() throws Exception {
        User user1 = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));

        User user2 = new User("Jana", "Nowaka", "jnowaka", "dupa", "11111111111",
                new BigDecimal("10.50"));

        List<User> users = List.of(user1, user2);

        List<UserDTO> userDTOList = userMapper.toDTO(users);

        when(userService.findAll()).thenReturn(users);

        mockMvc.perform(get("/api/users")).andExpect(status().isOk())
                .andExpect(content().json(JSONUtils.toJsonString(userDTOList, true)));
    }

}
