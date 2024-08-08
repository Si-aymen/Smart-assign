package org.example.SmartAssign.services;

import org.example.SmartAssign.models.Project;
import org.example.SmartAssign.models.Task;

import java.util.List;

public interface ITaskService {
    public List<Task> retrieveAllTasks();

    public Task retrieveTask(String TaskID);

    public Task addTask(Task Task);

    public void removeTask(String TaskID);

    public Task modifyTask(Task Task);
    public void AssignTaskToProject(String projectID, String TaskID);
    public void AssignNewTaskToProject(String projectID, Task Task);
    public List<Task> retrieveAllTasksForProject(String projectID);
}
