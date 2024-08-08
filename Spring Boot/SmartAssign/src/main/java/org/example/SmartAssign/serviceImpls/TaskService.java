package org.example.SmartAssign.serviceImpls;

import org.example.SmartAssign.models.Project;
import org.example.SmartAssign.models.Task;
import org.example.SmartAssign.repositories.ProjectRepository;
import org.example.SmartAssign.repositories.TaskRepository;
import org.example.SmartAssign.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TaskService implements ITaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Task> retrieveAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task retrieveTask(String TaskID) {
        return taskRepository.findById(TaskID).get();
    }

    @Override
    public Task addTask(Task Task) {
        return taskRepository.save(Task);
    }

    @Override
    public void removeTask(String TaskID) {
        taskRepository.deleteById(TaskID);

    }

    @Override
    public Task modifyTask(Task Task) {
        return null;
    }

    @Override
    public void AssignTaskToProject(String projectID, String taskID) {
        Project project = projectRepository.findById(projectID)
                .orElseThrow(() -> new IllegalArgumentException("Project not found with ID: " + projectID));

        Task task = retrieveTask(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task not found with ID: " + taskID);
        }

        project.getTasks().add(task);

        projectRepository.save(project);
    }

    public void AssignNewTaskToProject(String projectID, Task task) {
        Project project = projectRepository.findById(projectID)
                .orElseThrow(() -> new IllegalArgumentException("Project not found with ID: " + projectID));
        task.setProjectID(projectID);
        taskRepository.save(task);
        project.getTasks().add(task);
        projectRepository.save(project);
    }

    @Override
    public List<Task> retrieveAllTasksForProject(String projectID) {
        return taskRepository.findAllByProjectID(projectID);
    }

}
