package com.studyplanner.study_planner_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studyplanner.study_planner_backend.entity.Task;
import com.studyplanner.study_planner_backend.service.TaskService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping
    public List<Task> getAll() {
        return service.getAllTasks();
    }

    @PostMapping
    public Task save(@Valid @RequestBody Task task) {
        return service.saveTask(task);
    }

    //get task by id:
    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    //Update the task:
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task updatedTask) {

        return service.updateTask(id, updatedTask);
    }

    //delete task:
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTask(id);
    }

    @PatchMapping("/{id}/complete")
    public Task markCompleted(@PathVariable Long id) {
        return service.markCompleted(id);
    }

    @GetMapping("/subject/{subjectId}")
    public List<Task> getTasksBySubject(@PathVariable Long subjectId) {
        return service.getTasksBySubject(subjectId);
    }

    @GetMapping("/pending")
    public List<Task> getPendingTasks() {
        return service.getPendingTasks();
    }

    @GetMapping("/completed")
    public List<Task> getCompletedTasks() {
        return service.getCompletedTasks();
    }
}
