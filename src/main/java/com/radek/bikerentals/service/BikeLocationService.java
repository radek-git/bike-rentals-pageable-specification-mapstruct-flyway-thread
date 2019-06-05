package com.radek.bikerentals.service;

import com.radek.bikerentals.entity.BikeLocation;
import com.radek.bikerentals.repository.BikeLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BikeLocationService {

    private BikeLocationRepository bikeLocationRepository;

    @Autowired
    public BikeLocationService(BikeLocationRepository bikeLocationRepository) {
        this.bikeLocationRepository = bikeLocationRepository;
    }

    public BikeLocation findById(Long id) {
        return bikeLocationRepository.findById(id).orElseThrow(() -> new RuntimeException("nie ma"));
    }

    public List<BikeLocation> findAll (Pageable pageable) {
        return bikeLocationRepository.findAll(pageable).getContent();
    }


    public BikeLocation save(BikeLocation bikeLocation) {
        return bikeLocationRepository.save(bikeLocation);
    }


    public BikeLocation update(BikeLocation bikeLocation) {
        return bikeLocationRepository.save(bikeLocation);
    }


    @Transactional
    public void deleteById(Long id) {
        bikeLocationRepository.deleteById(id);
    }


    public List<BikeLocation> findAllBySerialNumber(String serialNumber, Pageable pageable) {
        return bikeLocationRepository.findAllByBike_SerialNumber(serialNumber, pageable).getContent();
    }
}
