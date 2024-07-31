package org.example.SmartAssign.repositories;

import org.example.SmartAssign.models.Role;
import org.example.SmartAssign.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findUserByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findAByRoles(Role role);
}
