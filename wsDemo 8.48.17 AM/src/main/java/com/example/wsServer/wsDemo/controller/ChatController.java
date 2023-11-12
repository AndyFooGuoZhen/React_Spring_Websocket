package com.example.wsServer.wsDemo.controller;

import com.example.wsServer.wsDemo.model.ChatHistory;
import com.example.wsServer.wsDemo.model.Message;
import com.example.wsServer.wsDemo.model.Status;
import com.example.wsServer.wsDemo.repository.ChatControllerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    ChatControllerRepository chatRep;


    @MessageMapping("/message")
    @Transactional
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message, @Header(name="token") String header){
        if(message.getStatus().equals(Status.MESSAGE)){
            System.out.println("hhhe");
            ChatHistory tempChatHistory = chatRep.findById(Integer.parseInt(header));
            tempChatHistory.appendMessage(message);
            System.out.println(tempChatHistory.getMessages().size());
//            chatRep.save(tempChatHistory);
        }

        return message;
    }

    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message, @Header(name="token") String header){
        System.out.println(header); // use token as id to save chats
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        System.out.println(message.toString());
        return message;
    }
}