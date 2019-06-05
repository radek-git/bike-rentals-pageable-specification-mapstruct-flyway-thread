package com.radek.bikerentals.service;

import com.radek.bikerentals.entity.Pricing;
import com.radek.bikerentals.repository.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PricingService {

    private PricingRepository pricingRepository;

    @Autowired
    public PricingService(PricingRepository pricingRepository) {
        this.pricingRepository = pricingRepository;
    }

    public List<Pricing> findAll () {
        return pricingRepository.findAll();
    }

    public Pricing findById(Long id) {
        return pricingRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma"));
    }

    public Pricing save(Pricing pricing) {
        return pricingRepository.save(pricing);
    }

    public Pricing update(Pricing pricing) {
        return pricingRepository.save(pricing);
    }

    @Transactional
    public void deletePricingById (Long id) {
        pricingRepository.deleteById(id);
    }
}
