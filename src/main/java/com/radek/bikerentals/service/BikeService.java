package com.radek.bikerentals.service;

import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BikeService {

    private BikeRepository bikeRepository;

    @Autowired
    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public List<Bike> findAll(Pageable pageable) {
        return bikeRepository.findAll(pageable).getContent();
    }

    public Bike findById(Long id) {
        return bikeRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma roweru o podanym id"));
    }

    public Bike save(Bike bike) {
        return bikeRepository.save(bike);
    }

    public Bike update(Bike bike, String serialNumber) {
        Bike bikeFromRepo = bikeRepository.findBySerialNumber(serialNumber).orElseThrow(() -> new RuntimeException("Nie ma"));



        return bikeRepository.save(bike);
    }


    public void deleteBikeById(Long id) {
        bikeRepository.deleteById(id);
    }

    public Bike findBySerialNumber(String serialNumber) {
        return bikeRepository.findBySerialNumber(serialNumber).orElseThrow(() -> new RuntimeException("Nie ma"));
    }

    @Transactional
    public void deleteBySerialNumber(String serialNumber) {
        bikeRepository.deleteBySerialNumber(serialNumber);
    }
}
