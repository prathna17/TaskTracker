package com.example.task_tracker.service.impl;

import com.example.task_tracker.dto.TaskTrackerDto;
import com.example.task_tracker.entity.TaskTracker;
import com.example.task_tracker.enums.TaskTrackerEnum;
import com.example.task_tracker.repository.TaskTrackerRepository;
import com.example.task_tracker.service.TaskTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskTrackerServiceImpl implements TaskTrackerService {

    private final TaskTrackerRepository taskTrackerRepository;

    @Override
    public void addNewTask(TaskTrackerDto taskTrackerDto) {
        TaskTracker taskTracker=TaskTracker.builder().taskName(taskTrackerDto.getTaskName()).taskStatus(taskTrackerDto.getTaskStatus()).build();
        taskTrackerRepository.save(taskTracker);
    }

    @Override
    public List<TaskTrackerDto> getAllTasks() {
        List<TaskTracker> allTasks=taskTrackerRepository.findAll();
        return allTasks.stream().map(
                task->TaskTrackerDto.builder().taskName(task.getTaskName()).taskStatus(task.getTaskStatus()).build())
                .toList();
    }

    @Override
    public TaskTrackerDto updateTaskStatus(TaskTrackerEnum taskTrackerEnum, int taskId) {
        Optional<TaskTracker> listTasks=taskTrackerRepository.findById(taskId);
        if(listTasks.isPresent()){
            TaskTracker updatedTask=listTasks.get();
            updatedTask.setTaskStatus(taskTrackerEnum);
            taskTrackerRepository.save(updatedTask);
            return TaskTrackerDto.builder().taskName(updatedTask.getTaskName()).taskStatus(updatedTask.getTaskStatus()).build();
        }
        return null;
    }

    @Override
    public List<TaskTrackerDto> getAllDoneTask() {
        List<TaskTracker> listAllDoneTasks=taskTrackerRepository.findByTaskStatus(TaskTrackerEnum.DONE);
        return listAllDoneTasks.stream().map(
                doneTask->TaskTrackerDto.builder().taskName(doneTask.getTaskName()).taskStatus(doneTask.getTaskStatus()).build())
                .toList();
    }

    @Override
    public List<TaskTrackerDto> getAllNotDoneTask() {
        List<TaskTracker> listAllNotDoneTasks=taskTrackerRepository.findByTaskStatus(TaskTrackerEnum.NOT_DONE);
        return listAllNotDoneTasks.stream().map(
                        notDoneTask->TaskTrackerDto.builder().taskName(notDoneTask.getTaskName()).taskStatus(notDoneTask.getTaskStatus()).build())
                .toList();
    }

    @Override
    public List<TaskTrackerDto> getAllInProgressTask() {
        List<TaskTracker> listAllInProgressTasks=taskTrackerRepository.findByTaskStatus(TaskTrackerEnum.IN_PROGRESS);
        return listAllInProgressTasks.stream().map(
                        inProgressTask->TaskTrackerDto.builder().taskName(inProgressTask.getTaskName()).taskStatus(inProgressTask.getTaskStatus()).build())
                .toList();
    }

    @Override
    public void updateTask(TaskTrackerDto taskTrackerDto,int taskId) {
        Optional<TaskTracker> taskById=taskTrackerRepository.findById(taskId);
        if(taskById.isPresent()){
            TaskTracker task=taskById.get();
            task.setTaskStatus(taskTrackerDto.getTaskStatus());
            task.setTaskName(taskTrackerDto.getTaskName());
            taskTrackerRepository.save(task);
        }
    }

    @Override
    public void deleteTaskById(int id) {
        taskTrackerRepository.deleteById(id);
    }
}
