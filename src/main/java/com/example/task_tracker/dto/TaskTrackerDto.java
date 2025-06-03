package com.example.task_tracker.dto;

import com.example.task_tracker.enums.TaskTrackerEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskTrackerDto {
    private String taskName;
    private TaskTrackerEnum taskStatus;
}
