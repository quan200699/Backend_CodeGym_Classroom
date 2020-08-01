package com.codegym.classroom.controller;

import com.codegym.classroom.model.entity.InstructorSchedule;
import com.codegym.classroom.model.entity.TutorSchedule;
import com.codegym.classroom.service.coach_schedule.ICoachScheduleService;
import com.codegym.classroom.service.instructor_schedule.IInstructorScheduleService;
import com.codegym.classroom.service.tutor_schedule.ITutorScheduleService;
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

    @Autowired
    private ITutorScheduleService tutorScheduleService;

    @GetMapping("/{id}/coaches")
    public ResponseEntity<Long> getCoachInClass(@PathVariable Long id) {
        return new ResponseEntity<>(coachScheduleService.getCoachInClass(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/instructors")
    public ResponseEntity<InstructorSchedule> getInstructorInClass(@PathVariable Long id) {
        return new ResponseEntity<>(instructorScheduleService.getInstructorInClass(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/tutors")
    public ResponseEntity<Iterable<TutorSchedule>> getTutorsInClass(@PathVariable Long id) {
        return new ResponseEntity<>(tutorScheduleService.getTutorsInClass(id), HttpStatus.OK);
    }
}
