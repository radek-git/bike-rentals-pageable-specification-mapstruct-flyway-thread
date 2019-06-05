package com.radek.bikerentals.controller;

import com.radek.bikerentals.annotation.PageableDefaults;
import com.radek.bikerentals.dto.RentalDTO;
import com.radek.bikerentals.dto.UserDTO;
import com.radek.bikerentals.entity.User;
import com.radek.bikerentals.mapper.RentalMapper;
import com.radek.bikerentals.mapper.UserMapper;
import com.radek.bikerentals.security.SecurityUtils;
import com.radek.bikerentals.service.UserService;
import com.radek.bikerentals.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @GetMapping("/api/user")
    public String getAuthenticatedUser() {
        return SecurityUtils.getUsername();
    }


    @GetMapping("/api/users")
    public List<UserDTO> findAll(UserSpecification userSpecification, @PageableDefaults(size = 50, minSize = 50, maxSize = 50) Pageable pageable) {
        return userMapper.toDTO(userService.findAll(userSpecification, pageable).getContent());
    }

    @GetMapping("/api/users/{username}")
    public UserDTO findByUsername(@PathVariable String username) {
        return userMapper.toDTO(userService.findByUsername(username));
    }

    @PostMapping("/api/users")
    public UserDTO save(@Valid @RequestBody UserDTO userDTO) {
        return userMapper.toDTO(userService.save(userMapper.toEntity(userDTO)));
    }

//    @PatchMapping("/api/users/{username}")
//    public User update(@PathVariable String username, @RequestBody UserDTO userDTO) {
//
//    }

    @DeleteMapping("/api/users/{username}")
    public void deleteByUsername(@PathVariable String username) {
        userService.deleteByUsername(username);
    }
}
