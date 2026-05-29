package com.studyplanner.study_planner_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studyplanner.study_planner_backend.entity.Task;
import com.studyplanner.study_planner_backend.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task saveTask(Task task) {
        return repository.save(task);
    }

    public Task getTaskById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task updateTask(Long id, Task updatedTask) {

        Task task = getTaskById(id);

        task.setTitle(updatedTask.getTitle());
        task.setSubject(updatedTask.getSubject());
        task.setPriority(updatedTask.getPriority());
        task.setCompleted(updatedTask.getCompleted());

        return repository.save(task);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public Task markCompleted(Long id) {

        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setCompleted(true);

        return repository.save(task);
    }

    public List<Task> getTasksBySubject(Long subjectId) {
        return repository.findBySubjectId(subjectId);
    }

    public List<Task> getPendingTasks() {
        return repository.findByCompletedFalse();
    }

    public List<Task> getCompletedTasks() {
        return repository.findByCompletedTrue();
    }
}
