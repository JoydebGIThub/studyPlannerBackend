package com.studyplanner.study_planner_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studyplanner.study_planner_backend.entity.StudySession;

public interface StudySessionRepository
        extends JpaRepository<StudySession, Long> {
}
