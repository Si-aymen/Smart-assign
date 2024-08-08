package org.example.SmartAssign.serviceImpls;

import org.example.SmartAssign.models.Task;
import org.example.SmartAssign.repositories.TaskRepository;
import org.example.SmartAssign.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TaskService implements ITaskService {
    @Autowired
    private TaskRepository taskRepository;

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
}
