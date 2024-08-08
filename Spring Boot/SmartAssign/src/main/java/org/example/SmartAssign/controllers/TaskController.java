package org.example.SmartAssign.controllers;

import lombok.AllArgsConstructor;
import org.example.SmartAssign.models.Task;
import org.example.SmartAssign.services.ITaskService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Projects")
@AllArgsConstructor
@PreAuthorize("hasRole('PROJECT_MANAGER')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowedHeaders = "*", allowCredentials = "true")

public class TaskController {
    ITaskService taskService;
    @GetMapping("/GetAll/Tasks")
    public Task getTasks(@PathVariable("Task-id") String TaskID) {
        return taskService.retrieveTask(TaskID) ;

    }

    @GetMapping("/GetByID/{Task-id}")
    public List<Task> getTask() {
        return taskService.retrieveAllTasks();

    }

    @PostMapping("/add-Task")
    public Task addTask(@RequestBody Task Task) {
        return taskService.addTask(Task);

    }

    @DeleteMapping("/remove-Task/{Task-id}")
    public void removeTransports(@PathVariable("Task-id") String TaskID) {
        taskService.removeTask(TaskID);
    }




}
