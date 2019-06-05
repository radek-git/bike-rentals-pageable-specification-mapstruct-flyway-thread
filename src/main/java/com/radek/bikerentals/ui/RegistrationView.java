package com.radek.bikerentals.ui;

import com.radek.bikerentals.dto.UserDTO;
import com.radek.bikerentals.mapper.UserMapper;
import com.radek.bikerentals.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;



@Route(value = "users/save", layout = MainView.class)
public class RegistrationView extends VerticalLayout {


    private UserService userService;
    private UserMapper userMapper;

    private FormLayout formLayout = new FormLayout();
    private TextField name = new TextField();
    private TextField surname = new TextField();
    private TextField username = new TextField();
    private PasswordField password = new PasswordField();
    private PasswordField confirmPassword = new PasswordField();
    private TextField pesel= new TextField();

    Button save = new Button("Register");
    private Binder<UserDTO> binder = new BeanValidationBinder<>(UserDTO.class);
    private UserDTO userDTO = new UserDTO();


    @Autowired
    public RegistrationView(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;

//        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.AUTO);

        binder.bindInstanceFields(this);
        binder.setBean(userDTO);

        name.setPlaceholder("Jan");
        formLayout.addFormItem(name, "First name");

        surname.setPlaceholder("Nowak");
        formLayout.addFormItem(surname, "Last name");

        username.setPlaceholder("username");
        formLayout.addFormItem(username, "Username");

        password.setPlaceholder("password");
        formLayout.addFormItem(password, "Password");

        confirmPassword.setPlaceholder("confirm password");
        formLayout.addFormItem(confirmPassword, "Confirm password");

        pesel.setPlaceholder("pesel");
        formLayout.addFormItem(pesel, "Pesel");

        password.addValueChangeListener(e -> {
            validatePasswordFields();
        });

        confirmPassword.addValueChangeListener(e -> {
            validatePasswordFields();
        });

        save.addClickListener(buttonClickEvent -> {
            binder.validate();

            if (binder.isValid()) {
                if (password.getValue().equals(confirmPassword.getValue())) {

                    userService.save(userMapper.toEntity(userDTO));
                    Notification.show("User registered");
                } else {
                    confirmPassword.setErrorMessage("Passwords must be the same");
                    confirmPassword.setInvalid(true);

                    password.setErrorMessage("Passwords must be the same");
                    password.setInvalid(true);

                }
            } else {
                Notification.show("Try again");
            }
        });

        add(formLayout);

        add(save);

    }


    private void validatePasswordFields() {
        if (!password.getValue().equals(confirmPassword.getValue())) {
            confirmPassword.setErrorMessage("Passwords must be the same");
            confirmPassword.setInvalid(true);

            password.setErrorMessage("Passwords must be the same");
            password.setInvalid(true);
        } else {
            confirmPassword.setInvalid(false);
            password.setInvalid(false);
        }
    }
}
