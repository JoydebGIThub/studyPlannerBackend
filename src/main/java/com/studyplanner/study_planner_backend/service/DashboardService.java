package com.studyplanner.study_planner_backend.service;

import org.springframework.stereotype.Service;

import com.studyplanner.study_planner_backend.dto.DashboardResponse;
import com.studyplanner.study_planner_backend.repository.SubjectRepository;
import com.studyplanner.study_planner_backend.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final TaskRepository taskRepository;
    private final SubjectRepository subjectRepository;

    public DashboardResponse getDashboardStats() {

        long totalTasks = taskRepository.count();
        long completedTasks = taskRepository.countByCompletedTrue();
        long pendingTasks = taskRepository.countByCompletedFalse();
        long totalSubjects = subjectRepository.count();

        return new DashboardResponse(
                totalTasks,
                completedTasks,
                pendingTasks,
                totalSubjects
        );
    }
}