package com.example.ToDo.controller;

import com.example.ToDo.model.Task;
import com.example.ToDo.service.TaskService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTodosByUser(@RequestParam("userId") Long userId) {
        return taskService.getTodosByUser(userId);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        if (task.getUserId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El userId no puede ser nulo");
        }
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task existingTask = taskService.findById(id);
        if (existingTask != null) {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setCompleted(updatedTask.getCompleted());
            existingTask.setPriority(updatedTask.getPriority());
            return taskService.update(existingTask);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
    }
}
