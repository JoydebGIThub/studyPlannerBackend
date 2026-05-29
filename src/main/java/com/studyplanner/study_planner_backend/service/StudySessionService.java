package com.studyplanner.study_planner_backend.service;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Service;

import com.studyplanner.study_planner_backend.entity.StudySession;
import com.studyplanner.study_planner_backend.exception.ResourceNotFoundException;
import com.studyplanner.study_planner_backend.repository.StudySessionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudySessionService {

    private final StudySessionRepository repository;

    public List<StudySession> getAllSessions() {
        return repository.findAll();
    }

    public StudySession getSessionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Study Session not found"));
    }

    // public StudySession saveSession(StudySession session) {
    //     return repository.save(session);
    // }

    public StudySession updateSession(Long id, StudySession updatedSession) {

        StudySession session = getSessionById(id);

        session.setSubject(updatedSession.getSubject());
        session.setStartTime(updatedSession.getStartTime());
        session.setEndTime(updatedSession.getEndTime());
        session.setDurationMinutes(updatedSession.getDurationMinutes());
        session.setNotes(updatedSession.getNotes());

        return repository.save(session);
    }

    public void deleteSession(Long id) {
        repository.deleteById(id);
    }

    public StudySession saveSession(StudySession session) {

        if (session.getStartTime() != null && session.getEndTime() != null) {
            session.setDurationMinutes(
                (int) Duration.between(
                    session.getStartTime(),
                    session.getEndTime()
                ).toMinutes()
            );
        }

        return repository.save(session);
    }
}
