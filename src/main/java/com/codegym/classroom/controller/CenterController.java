package com.codegym.classroom.controller;

import com.codegym.classroom.model.Classroom;
import com.codegym.classroom.service.classroom.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/centers")
public class CenterController {
    @Autowired
    private IClassroomService classroomService;

    @GetMapping("/{id}/classes")
    public ResponseEntity<Iterable<Classroom>> getAllClassroomByCenter(@PathVariable Long id) {
        return new ResponseEntity<>(classroomService.getAllClassroomByCenter(id), HttpStatus.OK);
    }
}
