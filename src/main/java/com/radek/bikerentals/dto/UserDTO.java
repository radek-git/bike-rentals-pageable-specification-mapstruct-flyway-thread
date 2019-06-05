package com.radek.bikerentals.dto;

import com.radek.bikerentals.validation.password.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private Long id;

    @NotEmpty
    @Size( min= 1, max = 50, message = "Field can't be empty")
    private String name;

    @NotEmpty
    @Size( min= 1, max = 50, message = "Field can't be empty")
    private String surname;

    @NotEmpty
    @Size( min= 5, max = 20, message = "Field can't be empty")
    private String username;

    @ValidPassword(message = "Field can't be empty")
    private String password;

    @Size(min = 11, max = 11, message = "Pesel must contain 11 numbers")
    private String pesel;

    private LocalDateTime createdAt;
}
