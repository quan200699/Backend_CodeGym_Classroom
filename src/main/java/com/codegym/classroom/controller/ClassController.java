package com.codegym.classroom.controller;

import com.codegym.classroom.service.coach_schedule.ICoachScheduleService;
import com.codegym.classroom.service.instructor_schedule.IInstructorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ICoachScheduleService coachScheduleService;

    @Autowired
    private IInstructorScheduleService instructorScheduleService;

    @GetMapping("/{id}/coaches")
    public ResponseEntity<Long> getCoachInClass(@PathVariable Long id) {
        return new ResponseEntity<>(coachScheduleService.getCoachInClass(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/instructors")
    public ResponseEntity<Long> getInstructorInClass(@PathVariable Long id) {
        return new ResponseEntity<>(instructorScheduleService.getInstructorInClass(id), HttpStatus.OK);
    }
}
