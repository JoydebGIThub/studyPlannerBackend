package com.studyplanner.study_planner_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponse {

    private Long totalTasks;
    private Long completedTasks;
    private Long pendingTasks;
    private Long totalSubjects;
}
