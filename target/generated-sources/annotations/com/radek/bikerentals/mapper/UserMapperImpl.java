package com.radek.bikerentals.mapper;

import com.radek.bikerentals.dto.UserDTO;
import com.radek.bikerentals.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-03T19:19:17+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setSurname( user.getSurname() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setPesel( user.getPesel() );
        userDTO.setCreatedAt( user.getCreatedAt() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toDTO(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( toDTO( user ) );
        }

        return list;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setName( userDTO.getName() );
        user.setSurname( userDTO.getSurname() );
        user.setUsername( userDTO.getUsername() );
        user.setPassword( userDTO.getPassword() );
        user.setPesel( userDTO.getPesel() );
        user.setCreatedAt( userDTO.getCreatedAt() );

        return user;
    }

    @Override
    public List<User> toEntity(List<UserDTO> userDTOList) {
        if ( userDTOList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDTOList.size() );
        for ( UserDTO userDTO : userDTOList ) {
            list.add( toEntity( userDTO ) );
        }

        return list;
    }
}
