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

import com.studyplanner.study_planner_backend.entity.StudySession;
import com.studyplanner.study_planner_backend.service.StudySessionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class StudySessionController {

    private final StudySessionService service;

    @GetMapping
    public List<StudySession> getAll() {
        return service.getAllSessions();
    }

    @GetMapping("/{id}")
    public StudySession getById(@PathVariable Long id) {
        return service.getSessionById(id);
    }

    @PostMapping
    public StudySession save(@RequestBody StudySession session) {
        return service.saveSession(session);
    }

    @PutMapping("/{id}")
    public StudySession update(@PathVariable Long id,
                               @RequestBody StudySession session) {
        return service.updateSession(id, session);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSession(id);
    }
}
