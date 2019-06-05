package com.radek.bikerentals.controller;

import com.radek.bikerentals.dto.PricingDTO;
import com.radek.bikerentals.entity.Pricing;
import com.radek.bikerentals.mapper.PricingMapper;
import com.radek.bikerentals.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PricingController {

    private PricingService pricingService;
    private PricingMapper pricingMapper;

    @Autowired
    public PricingController(PricingService pricingService, PricingMapper pricingMapper) {
        this.pricingService = pricingService;
        this.pricingMapper = pricingMapper;
    }

    @GetMapping
    public List<PricingDTO> findAll() {
        return pricingMapper.toDTO(pricingService.findAll());
    }

    @GetMapping("/{id}")
    public PricingDTO findById(@PathVariable Long id) {
        return pricingMapper.toDTO(pricingService.findById(id));
    }

    @PostMapping
    public PricingDTO save(@RequestBody Pricing pricing) {
        return pricingMapper.toDTO(pricingService.save(pricing));
    }

//    @PatchMapping("/api/pricing/{id}")
//    public PricingDTO update(@PathVariable Long id, @RequestBody PricingDTO pricingDTO) {
//        return
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        pricingService.deletePricingById(id);
    }
}
