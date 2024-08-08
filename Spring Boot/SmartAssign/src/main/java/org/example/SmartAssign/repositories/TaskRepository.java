package org.example.SmartAssign.repositories;

import org.example.SmartAssign.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository  extends MongoRepository<Task, String> {
    List<Task> findAllByProjectID(String projectId);
}
