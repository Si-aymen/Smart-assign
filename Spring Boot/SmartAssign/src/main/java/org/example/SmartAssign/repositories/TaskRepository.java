package org.example.SmartAssign.repositories;

import org.example.SmartAssign.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository  extends MongoRepository<Task, String> {
}
