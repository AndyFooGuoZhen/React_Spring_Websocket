package com.example.wsServer.wsDemo.controller;

import com.example.wsServer.wsDemo.model.ChatHistory;
import com.example.wsServer.wsDemo.repository.ChatControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*") //allows any request, fixes cors policy

public class ChatHistoryController {

    @Autowired
    ChatControllerRepository chatRep;

    @GetMapping("/chatHistory/{id}")
    ChatHistory getChatHistory(@PathVariable int id){
        return chatRep.findById(id);
    }

    /**
     * Creates chatHistory if no chats has been established
     * @param chatHistory
     * @return
     */
    @PostMapping(path = "/chatHistory")
    ChatHistory createChatHistory(@RequestBody ChatHistory chatHistory)
    {
        return chatRep.save(chatHistory);
    }



}
