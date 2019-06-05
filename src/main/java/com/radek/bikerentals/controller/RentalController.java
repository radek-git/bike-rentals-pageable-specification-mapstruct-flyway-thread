package com.radek.bikerentals.controller;

import com.radek.bikerentals.annotation.PageableDefaults;
import com.radek.bikerentals.dto.BikeLocationDTO;
import com.radek.bikerentals.dto.RentalDTO;
import com.radek.bikerentals.entity.Rental;
import com.radek.bikerentals.mapper.BikeLocationMapper;
import com.radek.bikerentals.mapper.RentalMapper;
import com.radek.bikerentals.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/rentals")
public class RentalController {

    private RentalService rentalService;
    private RentalMapper rentalMapper;

    @Autowired
    public RentalController(RentalService rentalService, RentalMapper rentalMapper) {
        this.rentalService = rentalService;
        this.rentalMapper = rentalMapper;
    }

    @GetMapping("/api/rentals")
    public List<RentalDTO> findAll(@PageableDefaults(size = 50, minSize = 50, maxSize = 50) Pageable pageable) {
        return rentalMapper.toDTO(rentalService.findAll(pageable));
    }

    @GetMapping("/api/rentals/{id}")
    public RentalDTO findById(@PathVariable Long id) {
        return rentalMapper.toDTO(rentalService.findById(id));
    }

    @GetMapping("/api/users/{username}/rentals")
    public List<RentalDTO> findRentalsByUsername(@PathVariable String username,
                                                 @PageableDefaults(size = 50, minSize = 50, maxSize = 50) Pageable pageable) {
        return rentalMapper.toDTO(rentalService.findAllByUsername(username, pageable));
    }

    @PostMapping("/api/rentals")
    public RentalDTO save(@RequestBody Rental rental) {
        return rentalMapper.toDTO(rentalService.save(rental));
    }

//    @PatchMapping("/api/rentals/{id}")
//    public RentalDTO update(@PathVariable Long id, @RequestBody RentalDTO rentalDTO) {
//
//    }


    @DeleteMapping("/api/rentals/{id}")
    public void deleteById(@PathVariable Long id) {
        rentalService.deleteById(id);
    }
}



