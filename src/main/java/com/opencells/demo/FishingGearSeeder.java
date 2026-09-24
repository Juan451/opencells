package com.opencells.demo;

import com.opencells.demo.model.FishingGear;
import com.opencells.demo.repository.FishingGearRepository;
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
                    "https://www.rhodani.com/354886-large_default/cana-rapala-classic-cd.jpg",
                    "Caña de spinning para lucio y black bass, acción rápida."
            ));
            fishingGearRepository.save(new FishingGear(
                    "Señuelo Jerkbait",
                    "Rapala",
                    "FRESHWATER_PREDATOR",
                    14.50,
                    "https://tiendabass.es/cdn/shop/files/jerkbait-rapala-floater-elite-85-gdcy-5046722.png?v=1768305914&width=300",
                    "Señuelo flotante para depredadores de agua dulce."
            ));
            fishingGearRepository.save(new FishingGear(
                    "Caña Trout Master",
                    "Daiwa",
                    "TROUT",
                    54.99,
                    "https://img.pecheur.com/cana-spinning-trout-master-pro-lake-z-2190-219089.jpg",
                    "Caña ultraligera para pesca de trucha en río."
            ));
            fishingGearRepository.save(new FishingGear(
                    "Cucharilla giratoria",
                    "Mepps",
                    "TROUT",
                    6.90,
                    "https://www.fish4kayak.com/11895-large_default/mepps-aglia-cucharilla.jpg",
                    "Cucharilla clásica para trucha, tamaño 2."
            ));
        }
    }
}