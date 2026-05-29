package com.studyplanner.study_planner_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studyplanner.study_planner_backend.entity.Subject;
import com.studyplanner.study_planner_backend.service.SubjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService service;

    @GetMapping
    public List<Subject> getAll() {
        return service.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getById(@PathVariable Long id) {
        return service.getSubjectById(id);
    }

    @PostMapping
    public Subject save(@Valid @RequestBody Subject subject) {
        return service.saveSubject(subject);
    }

    @PutMapping("/{id}")
    public Subject update(@PathVariable Long id,
                          @Valid @RequestBody Subject subject) {
        return service.updateSubject(id, subject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSubject(id);
    }
}
