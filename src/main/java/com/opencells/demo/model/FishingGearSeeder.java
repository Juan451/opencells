package com.opencells.demo.model;

import com.opencells.demo.FishingGearRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FishingGearSeeder implements CommandLineRunner {

    private final FishingGearRepository fishingGearRepository;

    public FishingGearSeeder(FishingGearRepository fishingGearRepository) {
        this.fishingGearRepository = fishingGearRepository;
    }

    @Override
    public void run(String... args) {
        if (fishingGearRepository.count() == 0) {
            fishingGearRepository.save(new FishingGear(
                    "Caña Predator X",
                    "Shimano",
                    "FRESHWATER_PREDATOR",
                    89.99,
                    "https://via.placeholder.com/300x300?text=Predator+Rod",
                    "Caña de spinning para lucio y black bass, acción rápida."
            ));
            fishingGearRepository.save(new FishingGear(
                    "Señuelo Jerkbait",
                    "Rapala",
                    "FRESHWATER_PREDATOR",
                    14.50,
                    "https://via.placeholder.com/300x300?text=Jerkbait",
                    "Señuelo flotante para depredadores de agua dulce."
            ));
            fishingGearRepository.save(new FishingGear(
                    "Caña Trout Master",
                    "Daiwa",
                    "TROUT",
                    54.99,
                    "https://via.placeholder.com/300x300?text=Trout+Rod",
                    "Caña ultraligera para pesca de trucha en río."
            ));
            fishingGearRepository.save(new FishingGear(
                    "Cucharilla giratoria",
                    "Mepps",
                    "TROUT",
                    6.90,
                    "https://via.placeholder.com/300x300?text=Spinner",
                    "Cucharilla clásica para trucha, tamaño 2."
            ));
        }
    }
}