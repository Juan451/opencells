package com.opencells.demo.controller;

import com.opencells.demo.dto.TaskRequest;
import com.opencells.demo.model.Task;
import com.opencells.demo.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> findAll(Authentication authentication) {
        String email = authentication.getName();
        return taskRepository.findByOwnerEmail(email);
    }

    @PostMapping
    public ResponseEntity<Task> create(
            @Valid @RequestBody TaskRequest request,
            Authentication authentication
    ) {
        String email = authentication.getName();
        Task task = new Task(request.title(), false, email);
        Task saved = taskRepository.save(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Task> toggle(@PathVariable String id, Authentication authentication) {
        String email = authentication.getName();

        return taskRepository.findById(id)
                .filter(task -> task.getOwnerEmail().equals(email))
                .map(task -> {
                    task.setCompleted(!task.isCompleted());
                    return ResponseEntity.ok(taskRepository.save(task));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}