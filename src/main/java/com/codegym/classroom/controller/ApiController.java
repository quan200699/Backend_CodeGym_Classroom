package com.codegym.classroom.controller;

import com.codegym.classroom.model.Classes;
import com.codegym.classroom.model.Module;
import com.codegym.classroom.model.Program;
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

    @GetMapping("/modules")
    public ResponseEntity<List<Module>> showListModule() {
        final String uri = apiUrl + "/modules";
        ResponseEntity<Object> responseEntity = apiService.getObjectFromAndy(uri);
        List<Module> modules = (List<Module>) responseEntity.getBody();
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }
}
