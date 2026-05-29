package com.studyplanner.study_planner_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studyplanner.study_planner_backend.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findBySubjectId(Long subjectId);
    List<Task> findByCompletedFalse();
    List<Task> findByCompletedTrue();
}
