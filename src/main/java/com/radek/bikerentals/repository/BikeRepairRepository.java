package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.BikeRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BikeRepairRepository extends JpaRepository<BikeRepair, Long> {
}
