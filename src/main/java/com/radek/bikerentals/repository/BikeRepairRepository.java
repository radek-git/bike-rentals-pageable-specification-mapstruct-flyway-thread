package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.BikeRepair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BikeRepairRepository extends JpaRepository<BikeRepair, Long> {

    void deleteAllById(Long id);

    List<BikeRepair> findAllByBike_SerialNumber(String serialNumber, Pageable pageable);
}
