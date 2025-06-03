package com.example.task_tracker.repository;

import com.example.task_tracker.entity.TaskTracker;
import com.example.task_tracker.enums.TaskTrackerEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskTrackerRepository extends JpaRepository<TaskTracker,Integer> {

    List<TaskTracker> findByTaskStatus(TaskTrackerEnum taskTrackerEnum);
}
