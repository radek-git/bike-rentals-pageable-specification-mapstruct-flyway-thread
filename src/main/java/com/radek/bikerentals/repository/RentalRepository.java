package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.Rental;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    Page<Rental> findAllByUser_Username(String username, Pageable pageable);



    Optional<Rental> findAllByBike_SerialNumber(String serialNumber);




}
