package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {


    Optional<Bike> findBySerialNumber(String name);

    void deleteBySerialNumber(String serialNumber);


}
