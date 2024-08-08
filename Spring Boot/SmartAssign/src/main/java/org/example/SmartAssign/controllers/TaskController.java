package org.example.SmartAssign.controllers;
import lombok.AllArgsConstructor;
import org.example.SmartAssign.models.Task;
import org.example.SmartAssign.services.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Tasks")
@AllArgsConstructor
@PreAuthorize("hasRole('PROJECT_MANAGER')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowedHeaders = "*", allowCredentials = "true")

public class TaskController {
    ITaskService taskService;
    @GetMapping("/GetAll/Tasks")
    public List<Task> getTasks() {
        return taskService.retrieveAllTasks() ;

    }

    @GetMapping("/GetByID/{Task-id}")
    public Task getTask(@PathVariable("Task-id") String TaskID) {
        return taskService.retrieveTask(TaskID) ;
    }

    @PostMapping("/add-Task")
    public Task addTask(@RequestBody Task Task) {
        return taskService.addTask(Task);
    }

    @DeleteMapping("/remove-Task/{Task-id}")
    public void removeTransports(@PathVariable("Task-id") String TaskID) {
        taskService.removeTask(TaskID);
    }

    @PostMapping("/{projectID}/tasks/{taskID}/assign")
    public ResponseEntity<String> assignTaskToProject(@PathVariable String projectID, @PathVariable String taskID) {
        try {
            taskService.AssignTaskToProject(projectID, taskID);
            return ResponseEntity.status(HttpStatus.OK).body("Task assigned to project successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while assigning the task to the project.");
        }
    }

    @PostMapping("/{projectID}/tasks/assign")
    public ResponseEntity<String> assignNewTaskToProject(@PathVariable String projectID, @RequestBody Task task) {
        try {
            taskService.AssignNewTaskToProject(projectID,task);
            return ResponseEntity.status(HttpStatus.OK).body("Task assigned to project successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while assigning the task to the project.");
        }
    }


}
