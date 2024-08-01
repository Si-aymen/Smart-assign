package org.example.SmartAssign.repositories;

import org.example.SmartAssign.models.Transports;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportsRepository extends MongoRepository<Transports, String> {
}
