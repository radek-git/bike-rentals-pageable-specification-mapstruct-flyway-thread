package com.radek.bikerentals.service;

import com.radek.bikerentals.entity.Color;
import com.radek.bikerentals.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ColorService {

    private ColorRepository colorRepository;

    @Autowired
    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public List<Color> findAll(Pageable pageable) {
        return colorRepository.findAll(pageable).getContent();
    }

    public Color findById(Long id) {
        return colorRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma"));
    }

    public Color save(Color color) {
        return colorRepository.save(color);
    }

    public Color update(Color color) {
        return colorRepository.save(color);
    }

    @Transactional
    public void deleteColorById(Long id) {
        colorRepository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        colorRepository.deleteByName(name);
    }
}
