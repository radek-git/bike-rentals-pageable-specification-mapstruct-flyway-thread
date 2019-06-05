package com.radek.bikerentals.controller;

import com.radek.bikerentals.annotation.PageableDefaults;
import com.radek.bikerentals.dto.BikeLocationDTO;
import com.radek.bikerentals.mapper.BikeLocationMapper;
import com.radek.bikerentals.service.BikeLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeLocationController {

    private BikeLocationService bikeLocationService;
    private BikeLocationMapper bikeLocationMapper;

    @Autowired
    public BikeLocationController(BikeLocationService bikeLocationService, BikeLocationMapper bikeLocationMapper) {
        this.bikeLocationService = bikeLocationService;
        this.bikeLocationMapper = bikeLocationMapper;
    }

    @GetMapping("/api/bike-locations")
    public List<BikeLocationDTO> findAll(@PageableDefaults(size = 50, minSize = 50, maxSize = 50)Pageable pageable) {
        return bikeLocationMapper.toDTO(bikeLocationService.findAll(pageable));
    }

    @GetMapping("/api/bikes/{serialNumber}/locations")
    public List<BikeLocationDTO> findAllBySerialNumber(@PathVariable String serialNumber, @PageableDefaults(size = 50, minSize = 50, maxSize = 50)Pageable pageable) {
        return bikeLocationMapper.toDTO(bikeLocationService.findAllBySerialNumber(serialNumber, pageable));
    }

    @PostMapping("/api/bike-locations")
    public BikeLocationDTO save(@RequestBody BikeLocationDTO bikeLocationDTO) {
        return bikeLocationMapper.toDTO(bikeLocationService.save(bikeLocationMapper.toEntity(bikeLocationDTO)));
    }

//    @PatchMapping("/bikeLocations/{id}")
//    public BikeLocationDTO update(@PathVariable Long id, @RequestBody BikeLocationDTO bikeLocationDTO) {
//        return
//    }

    @DeleteMapping("/api/bike-locations/{id}")
    public void deleteById(@PathVariable Long id) {
        bikeLocationService.deleteById(id);
    }
}
