package com.opencells.demo.repository;

import com.opencells.demo.model.FishingGear;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FishingGearRepository extends MongoRepository<FishingGear, String> {

    List<FishingGear> findByCategory(String category);
}