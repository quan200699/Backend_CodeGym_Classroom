package com.codegym.classroom.controller;

import com.codegym.classroom.model.*;
import com.codegym.classroom.service.api.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ApiController {

    @Value("${apiUr}")
    private String apiUrl;

    @Autowired
    private ApiService apiService;

    @GetMapping("/classes")
    public ResponseEntity<List<Classes>> showListClass() {
        final String uri = apiUrl + "/classes";
        ResponseEntity<Object> responseEntity = apiService.getObjectFromAndy(uri);
        List<Classes> classes = (List<Classes>) responseEntity.getBody();
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }


    @GetMapping("/programs")
    public ResponseEntity<List<Program>> showListProgram() {
        final String uri = apiUrl + "/programs";
        ResponseEntity<Object> responseEntity = apiService.getObjectFromAndy(uri);
        List<Program> programs = (List<Program>) responseEntity.getBody();
        return new ResponseEntity<>(programs, HttpStatus.OK);
    }

    @GetMapping("/lectures")
    public ResponseEntity<List<Lecture>> showListLecture() {
        final String uri = apiUrl + "/lectures";
        ResponseEntity<Object> responseEntity = apiService.getObjectFromAndy(uri);
        List<Lecture> lectures = (List<Lecture>) responseEntity.getBody();
        return new ResponseEntity<>(lectures, HttpStatus.OK);
    }

    @GetMapping("/centers")
    public ResponseEntity<List<Center>> showListCenter() {
        final String uri = apiUrl + "/centers";
        ResponseEntity<Object> responseEntity = apiService.getObjectFromAndy(uri);
        List<Center> centers = (List<Center>) responseEntity.getBody();
        return new ResponseEntity<>(centers, HttpStatus.OK);
    }
}
