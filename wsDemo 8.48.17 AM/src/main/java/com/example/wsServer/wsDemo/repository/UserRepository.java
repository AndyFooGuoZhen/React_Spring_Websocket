package com.example.wsServer.wsDemo.repository;

import com.example.wsServer.wsDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long>
{
    @Transactional
    void deleteById(String id);

    User findById(String id);
    boolean existsById(String id);


}

