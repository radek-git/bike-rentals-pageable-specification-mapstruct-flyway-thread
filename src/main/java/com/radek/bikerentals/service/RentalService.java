package com.radek.bikerentals.service;

import com.radek.bikerentals.entity.Rental;
import com.radek.bikerentals.exception.RentalNotFoundException;
import com.radek.bikerentals.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class RentalService {

    private RentalRepository rentalRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> findAll (Pageable pageable) {
        return rentalRepository.findAll(pageable).getContent();
    }

    public Rental findById(Long id) {
        return rentalRepository.findById(id).orElseThrow(() -> new RentalNotFoundException("Nie ma"));
    }

    public Rental save(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental update(Rental rental) {
        return rentalRepository.save(rental);
    }

    @Transactional
    public void deleteById(Long id) {
        rentalRepository.deleteById(id);
    }

    public List<Rental> findAllByUsername(String username, Pageable pageable) {
        return rentalRepository.findAllByUser_Username(username, pageable).getContent();
    }
}
