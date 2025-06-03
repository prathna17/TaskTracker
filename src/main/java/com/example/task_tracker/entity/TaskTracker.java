package com.example.task_tracker.entity;

import com.example.task_tracker.enums.TaskTrackerEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    private String taskName;

    @Enumerated(EnumType.STRING)
    private TaskTrackerEnum taskStatus;
}
