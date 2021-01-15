package com.example.rentalapp.controllers;


import com.example.rentalapp.models.User;
import com.example.rentalapp.services.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private  UserService userService;

    @GetMapping(value = "/")
    public ResponseEntity<String> authenticate() {
        logger.info("Getting User authenticated");
        Date date = new Date();
        Gson gson= new Gson();
        JsonObject jsonObject = new JsonObject();
        //String[] profile= environment.getActiveProfiles();
        jsonObject.addProperty("message", "You are logged in. The current time is " + date.toString() + " .Environment is: " );
        logger.info("User successfully authenticated");
        return ResponseEntity.ok(gson.toJson(jsonObject));
    }


    @GetMapping
    public ResponseEntity<String> getUser(){
        Gson gson=new Gson();
        JsonObject json=new JsonObject();
        json.addProperty("username","usener");
        return ResponseEntity.ok(gson.toJson(json));
    }

    @GetMapping
    public ResponseEntity<String> getUsers(){
        Gson gson=new Gson();
        JsonObject json=new JsonObject();
        List<String> names=new ArrayList();
        names.add("Akshata");
        names.add("Pk");
        names.add("Gappa");
        json.addProperty("username",names.toString());
        return ResponseEntity.ok(gson.toJson(json));
    }
}
