package com.radek.bikerentals.service;

import com.radek.bikerentals.entity.User;
import com.radek.bikerentals.exception.UsernameNotFoundException;
import com.radek.bikerentals.repository.UserRepository;
import com.radek.bikerentals.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService  {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> findAll(UserSpecification userSpecification, Pageable pageable) {
        return userRepository.findAll(userSpecification, pageable);
    }

    public List<User> findAll () {
        return userRepository.findAll();
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Nie ma"));
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


    @Transactional
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
}
