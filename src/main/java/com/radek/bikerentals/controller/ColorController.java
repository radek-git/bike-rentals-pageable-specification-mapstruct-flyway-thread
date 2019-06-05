package com.radek.bikerentals.controller;

import com.radek.bikerentals.annotation.PageableDefaults;
import com.radek.bikerentals.dto.ColorDTO;
import com.radek.bikerentals.entity.Color;
import com.radek.bikerentals.mapper.ColorMapper;
import com.radek.bikerentals.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

    private ColorService colorService;
    private ColorMapper colorMapper;

    @Autowired
    public ColorController(ColorService colorService, ColorMapper colorMapper) {
        this.colorService = colorService;
        this.colorMapper = colorMapper;
    }

    @GetMapping
    public List<Color> findAll(@PageableDefaults(size = 50, minSize = 50, maxSize = 50) Pageable pageable) {
        return colorService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Color findById(@PathVariable Long id) {
        return colorService.findById(id);
    }

    @PostMapping
    public ColorDTO save(@RequestBody Color color) {
        return colorMapper.toDTO(colorService.save(color));
    }

//    @PatchMapping("/api/colors/{id}")
//    public ColorDTO update(@PathVariable Long id, @RequestBody ColorDTO colorDTO) {
//        return
//    }

    @DeleteMapping("/{name}")
    public void deleteByName (@PathVariable String name) {
        colorService.deleteByName(name);
    }


}
