package com.example.wsServer.wsDemo.controller;

import com.example.wsServer.wsDemo.model.User;
import com.example.wsServer.wsDemo.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController
{
    @Autowired
    UserRepository userRep;

    @Transactional
    public boolean isExistByUserId(String id) {
        return userRep.existsById(id);
    }

    @GetMapping(path = "/user")
    List<User> getAllUsers()
    {
        return userRep.findAll();
    }

    @GetMapping(path = "/user/{id}")
    User getUserById(@PathVariable String id)
    {
        return userRep.findById(id);
    }

    @PostMapping(path = "/user")
    User createUser(@RequestBody User user)
    {
        if(!isExistByUserId(user.getId())){
            userRep.save(user);
        }

        return user;
    }

    @PutMapping(path = "/user/{id}")
    User updateUser(@PathVariable String id, @RequestBody User update)
    {
        if(userRep.findById(id) == null)
        {
            return null;
        }
        userRep.save(update);
        return userRep.findById(id);
    }

    @DeleteMapping(path = "/user/{id}")
    List<User> deleteUser(@PathVariable String id)
    {
        userRep.deleteById(id);
        return userRep.findAll();
    }

    @GetMapping(path = "/userExist/{id}")
    Boolean checkUserExists(@PathVariable String id)
    {
        return (userRep.findById(id) != null);
    }

}

