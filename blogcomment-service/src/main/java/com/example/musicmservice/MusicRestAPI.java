package com.example.musicmservice;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/music")
public class MusicRestAPI {

    private String title = "hello from Music api";


    @RequestMapping("hello")
    public String sayHallo() {
        System.out.println(title);
        return title;
    }







}
