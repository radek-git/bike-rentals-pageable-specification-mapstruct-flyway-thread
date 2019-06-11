package com.radek.bikerentals.service;

import com.radek.bikerentals.entity.BikeRepair;
import com.radek.bikerentals.repository.BikeRepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeRepairService {


    private BikeRepairRepository bikeRepairRepository;

    @Autowired
    public BikeRepairService(BikeRepairRepository bikeRepairRepository) {
        this.bikeRepairRepository = bikeRepairRepository;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<BikeRepair> findAll(Pageable pageable) {
        return bikeRepairRepository.findAll(pageable).getContent();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public BikeRepair findById(Long id) {
        return bikeRepairRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma"));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteById(Long id) {
        bikeRepairRepository.deleteById(id);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public BikeRepair save(BikeRepair bikeRepair) {
        return bikeRepairRepository.save(bikeRepair);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<BikeRepair> findRepairsByBikeSerialNumber(String serialNumber, Pageable pageable) {
        return bikeRepairRepository.findAllByBike_SerialNumber(serialNumber, pageable);
    }
}
