package com.opencells.demo.controller;

import com.opencells.demo.model.FishingGear;
import com.opencells.demo.repository.FishingGearRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fishing-gear")
public class FishingGearController {

    private final FishingGearRepository fishingGearRepository;

    public FishingGearController(FishingGearRepository fishingGearRepository) {
        this.fishingGearRepository = fishingGearRepository;
    }

    @GetMapping
    public List<FishingGear> findAll(@RequestParam(required = false) String category) {
        if (category != null && !category.isBlank()) {
            return fishingGearRepository.findByCategory(category);
        }
        return fishingGearRepository.findAll();
    }
}