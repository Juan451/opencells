package com.opencells.demo.repository;

import com.opencells.demo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByOwnerEmail(String ownerEmail);
}