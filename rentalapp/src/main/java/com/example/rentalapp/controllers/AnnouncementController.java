package com.example.rentalapp.controllers;

import com.example.rentalapp.respositories.AnnouncementRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/announcements")
public class AnnouncementController {
    @Autowired
    private AnnouncementRepository announcementRepository;

    @GetMapping(value = "/")
    public ResponseEntity<String> announcements(){
        Gson gson=new Gson();
        JsonObject json=new JsonObject();
        json.addProperty("username","usener");
        return ResponseEntity.ok(gson.toJson(json));
    }

    @GetMapping(value = "/addAnnouncements")
    public ResponseEntity<String>  addAnnouncements(){
        Gson gson=new Gson();
        JsonObject json=new JsonObject();
        json.addProperty("username","usener");
        return ResponseEntity.ok(gson.toJson(json));
    }

    @PostMapping(value = "/addAnnouncements")
    public ResponseEntity<String> successAnnouncements(){
        Gson gson=new Gson();
        JsonObject json=new JsonObject();
        json.addProperty("username","usener");
        return ResponseEntity.ok(gson.toJson(json));
    }
}
