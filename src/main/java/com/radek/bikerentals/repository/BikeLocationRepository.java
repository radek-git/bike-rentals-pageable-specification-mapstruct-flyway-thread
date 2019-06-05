package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.BikeLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeLocationRepository extends JpaRepository<BikeLocation, Long> {

    Page<BikeLocation> findAllByBike_SerialNumber(String serialNumber, Pageable pageable);

}
