package com.radek.bikerentals.ui;

import com.radek.bikerentals.dto.UserDTO;
import com.radek.bikerentals.mapper.UserMapper;
import com.radek.bikerentals.service.UserService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "users", layout = MainView.class)
public class ShowUsersView extends VerticalLayout {

    private Grid<UserDTO> users = new Grid<>();

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public ShowUsersView(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;

        users.setItems(userMapper.toDTO(userService.findAll()));

//        users.setColumnReorderingAllowed(true);
        users.setMultiSort(true);

        users.addColumn(UserDTO::getId).setHeader("Id");
        users.addColumn(UserDTO::getName).setHeader("Name");
        users.addColumn(UserDTO::getSurname).setHeader("Surname");
        users.addColumn(UserDTO::getUsername).setHeader("Username");
        users.addColumn(UserDTO::getCreatedAt).setHeader("Created at");

        add(users);

    }
}
