package com.example.ToDo.service;

import com.example.ToDo.model.Task;
import com.example.ToDo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTodosByUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task updatedTask) {
        return taskRepository.save(updatedTask);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

}
