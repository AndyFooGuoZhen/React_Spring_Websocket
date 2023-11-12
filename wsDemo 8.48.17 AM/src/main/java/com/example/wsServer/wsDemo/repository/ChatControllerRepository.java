package com.example.wsServer.wsDemo.repository;

import com.example.wsServer.wsDemo.model.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatControllerRepository extends JpaRepository<ChatHistory, Long> {
    ChatHistory findById(int id);

}
