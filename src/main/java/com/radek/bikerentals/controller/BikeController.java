package com.radek.bikerentals.controller;

import com.radek.bikerentals.annotation.PageableDefaults;
import com.radek.bikerentals.dto.BikeDTO;
import com.radek.bikerentals.entity.Bike;
import com.radek.bikerentals.entity.BikeLocation;
import com.radek.bikerentals.mapper.BikeMapper;
import com.radek.bikerentals.service.BikeService;
import com.radek.bikerentals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BikeController {

    private BikeMapper bikeMapper;
    private BikeService bikeService;

    @Autowired
    public BikeController(BikeMapper bikeMapper, BikeService bikeService) {
        this.bikeMapper = bikeMapper;
        this.bikeService = bikeService;
    }

    @GetMapping("/api/bikes")
    public List<BikeDTO> findAll(@PageableDefaults(size = 50, minSize = 50, maxSize = 50) Pageable pageable) {
       return bikeMapper.toDTO(bikeService.findAll(pageable));
    }

    @GetMapping("/api/bikes/{serialNumber}")
    public BikeDTO findBySerialNumber(@PathVariable String serialNumber) {
        return bikeMapper.toDTO(bikeService.findBySerialNumber(serialNumber));
    }

    @PostMapping("/api/bikes")
    public BikeDTO save(@Valid @RequestBody BikeDTO bikeDTO) {
        return bikeMapper.toDTO(bikeService.save(bikeMapper.toEntity(bikeDTO)));
    }


//    @PatchMapping("/{serialNumber}")
//    public BikeDTO update(@RequestBody BikeDTO bikeDTO, @PathVariable String serialNumber) {
//        return bikeMapper.toDTO(bikeService.update(bikeDTO, serialNumber));

//    }

    @DeleteMapping("/api/bikes/{serialNumber}")
    public void delete(@PathVariable String serialNumber) {
        bikeService.deleteBySerialNumber(serialNumber);
    }
}
