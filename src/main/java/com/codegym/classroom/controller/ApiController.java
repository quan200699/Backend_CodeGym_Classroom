package com.codegym.classroom.controller;

import com.codegym.classroom.model.Classes;
import com.codegym.classroom.model.Program;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ApiController {

    @Value("${apiUr}")
    private String apiUrl;

    @Value("${http.auth-token-header-name}")
    private String principalRequestHeader;

    @Value("${http.auth-token}")
    private String principalRequestValue;

    @GetMapping("/classes")
    public ResponseEntity<List<Classes>> showListClass() {
        final String uri = apiUrl + "/classes";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(principalRequestHeader, principalRequestValue);
        HttpEntity<String> entity = new HttpEntity<>("headers", headers);
        ResponseEntity<Object> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);
        List<Classes> classes = (List<Classes>) responseEntity.getBody();
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }


    @GetMapping("/programs")
    public ResponseEntity<List<Program>> showListProgram() {
        final String uri = apiUrl + "/programs";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(principalRequestHeader, principalRequestValue);
        HttpEntity<String> entity = new HttpEntity<>("headers", headers);
        ResponseEntity<Object> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);
        List<Program> programs = (List<Program>) responseEntity.getBody();
        return new ResponseEntity<>(programs, HttpStatus.OK);
    }

}
