package com.example.task_tracker.service;

import com.example.task_tracker.dto.TaskTrackerDto;
import com.example.task_tracker.enums.TaskTrackerEnum;

import java.util.List;

public interface TaskTrackerService {

    void addNewTask(TaskTrackerDto taskTrackerDto);

    List<TaskTrackerDto> getAllTasks();

    TaskTrackerDto updateTaskStatus(TaskTrackerEnum taskTrackerEnum, int taskId);

    List<TaskTrackerDto> getAllDoneTask();

    List<TaskTrackerDto> getAllNotDoneTask();

    List<TaskTrackerDto> getAllInProgressTask();

    void updateTask(TaskTrackerDto taskTrackerDto,int taskId);

    void deleteTaskById(int id);
}
