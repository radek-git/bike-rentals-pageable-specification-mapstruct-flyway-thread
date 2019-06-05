package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

    Optional<Color> findByName(String name);

    void deleteByName(String name);
}
