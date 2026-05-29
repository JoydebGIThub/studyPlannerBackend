package com.studyplanner.study_planner_backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studyplanner.study_planner_backend.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findBySubjectId(Long subjectId);
    List<Task> findByCompletedFalse();
    List<Task> findByCompletedTrue();
    long countByCompletedTrue();

    long countByCompletedFalse();
    List<Task> findByTitleContainingIgnoreCase(String keyword);
    List<Task> findByPriority(Integer priority);
    List<Task> findByDueDate(LocalDate dueDate);
    List<Task> findByDueDateBeforeAndCompletedFalse(LocalDate date);
}
