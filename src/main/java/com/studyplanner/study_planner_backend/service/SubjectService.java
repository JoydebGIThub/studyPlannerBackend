package com.studyplanner.study_planner_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studyplanner.study_planner_backend.entity.Subject;
import com.studyplanner.study_planner_backend.exception.ResourceNotFoundException;
import com.studyplanner.study_planner_backend.repository.SubjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository repository;

    public List<Subject> getAllSubjects() {
        return repository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
    }

    public Subject saveSubject(Subject subject) {
        return repository.save(subject);
    }

    public Subject updateSubject(Long id, Subject updatedSubject) {

        Subject subject = getSubjectById(id);

        subject.setName(updatedSubject.getName());

        return repository.save(subject);
    }

    public void deleteSubject(Long id) {
        repository.deleteById(id);
    }

}
