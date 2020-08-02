package com.codegym.classroom.controller;

import com.codegym.classroom.service.coach_schedule.ICoachScheduleService;
import com.codegym.classroom.service.instructor_schedule.IInstructorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LectureController {
    @Autowired
    private ICoachScheduleService coachScheduleService;

    @Autowired
    private IInstructorScheduleService instructorScheduleService;

    @GetMapping("/coaches/{id}/classes")
    public ResponseEntity<Iterable<Long>> getAllClassesByCoach(@PathVariable Long id) {
        return new ResponseEntity<>(coachScheduleService.getAllByLectureId(id), HttpStatus.OK);
    }

    @GetMapping("/instructors/{id}/classes")
    public ResponseEntity<Iterable<Long>> getAllClassesByInstructor(@PathVariable Long id) {
        return new ResponseEntity<>(instructorScheduleService.getAllByLectureId(id), HttpStatus.OK);
    }
}
