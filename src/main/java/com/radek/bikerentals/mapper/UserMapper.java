package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.UserDTO;
import com.radek.bikerentals.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    List<UserDTO> toDTO(List<User> users);

    User toEntity(UserDTO userDTO);

    List<User> toEntity(List<UserDTO> userDTOList);
}
