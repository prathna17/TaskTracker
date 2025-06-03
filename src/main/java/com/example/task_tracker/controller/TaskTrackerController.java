package com.example.task_tracker.controller;

import com.example.task_tracker.dto.TaskTrackerDto;
import com.example.task_tracker.enums.TaskTrackerEnum;
import com.example.task_tracker.service.TaskTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task/tracker")
@RequiredArgsConstructor
public class TaskTrackerController {

    private final TaskTrackerService taskTrackerService;

    @PostMapping("/add_data")
    public ResponseEntity<?> addNewTask(@RequestBody TaskTrackerDto taskTrackerDto){
        taskTrackerService.addNewTask(taskTrackerDto);
        return ResponseEntity.ok().body("Task added successfully");
    }

    @GetMapping("get/all_tasks")
    public ResponseEntity<List<TaskTrackerDto>> getAllTasks(){
        return ResponseEntity.ok().body(taskTrackerService.getAllTasks());
    }

    @GetMapping("get/all_tasks/done")
    public ResponseEntity<List<TaskTrackerDto>> getAllDoneTasks(){
        return ResponseEntity.ok().body(taskTrackerService.getAllDoneTask());
    }

    @GetMapping("get/all_tasks/not_done")
    public ResponseEntity<List<TaskTrackerDto>> getAllNotDoneTasks(){
        return ResponseEntity.ok().body(taskTrackerService.getAllNotDoneTask());
    }

    @GetMapping("get/all_tasks/in_progress")
    public ResponseEntity<List<TaskTrackerDto>> getAllInProgressTasks(){
        return ResponseEntity.ok().body(taskTrackerService.getAllInProgressTask());
    }

    @PutMapping("update_task/taskId/{taskId}")
    public ResponseEntity<?> updateTask(@RequestBody TaskTrackerDto taskTrackerDto,@PathVariable int taskId){
        taskTrackerService.updateTask(taskTrackerDto,taskId);
        return ResponseEntity.ok().body("Task with given id updated successfully");
    }

    @DeleteMapping("delete_task/id/{taskId}")
    public ResponseEntity<?> deleteTaskById(@PathVariable int taskId){
        taskTrackerService.deleteTaskById(taskId);
        return ResponseEntity.ok().body("Task with given id deleted successfully");
    }

    @PutMapping("update/task_status/status/{taskTrackerEnum}/id/{taskId}")
    public ResponseEntity<TaskTrackerDto> updateTaskStatus(@PathVariable TaskTrackerEnum taskTrackerEnum,@PathVariable int taskId){
        return ResponseEntity.ok().body(taskTrackerService.updateTaskStatus(taskTrackerEnum,taskId));
    }
}
