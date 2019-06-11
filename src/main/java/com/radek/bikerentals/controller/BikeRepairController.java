package com.radek.bikerentals.controller;

import com.radek.bikerentals.annotation.PageableDefaults;
import com.radek.bikerentals.dto.BikeRepairDTO;
import com.radek.bikerentals.mapper.BikeRepairMapper;
import com.radek.bikerentals.service.BikeRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BikeRepairController {

    private BikeRepairService bikeRepairService;
    private BikeRepairMapper bikeRepairMapper;


    @Autowired
    public BikeRepairController(BikeRepairService bikeRepairService, BikeRepairMapper bikeRepairMapper) {
        this.bikeRepairService = bikeRepairService;
        this.bikeRepairMapper = bikeRepairMapper;
    }

    @GetMapping("/repairs")
    public List<BikeRepairDTO> findAll(@PageableDefaults(size = 50, minSize = 50, maxSize = 50) Pageable pageable) {
        return bikeRepairMapper.toDTO(bikeRepairService.findAll(pageable));
    }

    @GetMapping("/bikes/{serialNumber}/repairs")
    public List<BikeRepairDTO> findRepairsByBikeSerialNumber(
            @PathVariable String serialNumber,
            @PageableDefaults(size = 50, minSize = 50, maxSize = 50) Pageable pageable) {
        return bikeRepairMapper.toDTO(bikeRepairService.findRepairsByBikeSerialNumber(serialNumber, pageable));
    }


    @GetMapping("/repairs/{id}")
    public BikeRepairDTO findById(@PathVariable Long id) {
        return bikeRepairMapper.toDTO(bikeRepairService.findById(id));
    }


//    @PostMapping
//    public BikeRepairDTO save(@RequestBody BikeRepairDTO bikeRepairDTO) {
//        return bikeRepairMapper.toDTO(bikeRepairService.save(bikeRepairMapper.toEntity(bikeRepairDTO)));
//    }


//    @PatchMapping("/repairs/{id}")
//    public BikeRepairDTO update(@RequestBody BikeRepairDTO bikeRepairDTO, @PathVariable Long id) {
//
//    }



    @DeleteMapping("/repairs/{id}")
    public void deleteById(@PathVariable Long id) {
        bikeRepairService.deleteById(id);
    }
}
