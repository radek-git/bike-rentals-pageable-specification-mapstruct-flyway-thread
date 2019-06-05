package com.radek.bikerentals.ui;

import com.radek.bikerentals.dto.UserDTO;
import com.radek.bikerentals.mapper.UserMapper;
import com.radek.bikerentals.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "users/add", layout = MainView.class)
public class AddUserView extends VerticalLayout {

    private UserService userService;
    private UserMapper userMapper;

    private TextField name = new TextField("name");
    private TextField surname = new TextField("surname");
    private TextField username = new TextField("username");
    private PasswordField password = new PasswordField("password");
    private PasswordField confirmPassword = new PasswordField("confirm password");
    private TextField pesel = new TextField("pesel");

    Binder<UserDTO> binder = new BeanValidationBinder<>(UserDTO.class);
    private UserDTO userDTO = new UserDTO();

    private Button save = new Button("Add user");

    @Autowired
    public AddUserView(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;

        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        binder.bindInstanceFields(this);
        binder.setBean(userDTO);

        save.addClickListener(buttonClickEvent -> {
            binder.validate();
            if (binder.isValid()) { //dopisany warunek z confirm passord
                if ((password.getValue().equals(confirmPassword.getValue()))) {

                    userService.save(userMapper.toEntity(userDTO));
                    Notification.show("User added");
                }
            } else {
                Notification.show("Try again");
            }
        });

        add(name, surname, username, password, confirmPassword, pesel);
        add(save);


    }
}
