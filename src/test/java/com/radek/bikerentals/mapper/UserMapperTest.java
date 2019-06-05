package com.radek.bikerentals.mapper;


import com.radek.bikerentals.dto.UserDTO;
import com.radek.bikerentals.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserMapperTest {

    private UserMapper userMapper = new UserMapperImpl();

    @Test
    public void shouldMapUserToDTO() {
        //given
        LocalDateTime now = LocalDateTime.now();
        User user = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));
        user.setId(200L);
        user.setCreatedAt(now);

        //when
        UserDTO userDTO = userMapper.toDTO(user);

        //then
        assertEquals(200L, userDTO.getId().longValue());
        assertEquals("Jan", userDTO.getName());
        assertEquals("Nowak", userDTO.getSurname());
        assertEquals("jnowak", userDTO.getUsername());
        assertEquals("dupa", userDTO.getPassword());
        assertEquals("11111111111", userDTO.getPesel());
        assertEquals(now, userDTO.getCreatedAt());
    }


    //porobić testy do repo i mapperów na dto

}
