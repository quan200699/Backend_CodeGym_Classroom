package com.codegym.classroom.controller;

import com.codegym.classroom.model.entity.TutorSchedule;
import com.codegym.classroom.service.tutor_schedule.ITutorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/tutor-schedules")
public class TutorScheduleController {
    @Autowired
    private ITutorScheduleService tutorScheduleService;

    @GetMapping
    public ResponseEntity<Iterable<TutorSchedule>> getAllTutorSchedule() {
        return new ResponseEntity<>(tutorScheduleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorSchedule> getTutorSchedule(@PathVariable Long id) {
        Optional<TutorSchedule> tutorScheduleOptional = tutorScheduleService.findById(id);
        return tutorScheduleOptional.map(tutorSchedule -> new ResponseEntity<>(tutorSchedule, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TutorSchedule> createTutorSchedule(@RequestBody TutorSchedule tutorSchedule) {
        return new ResponseEntity<>(tutorScheduleService.save(tutorSchedule), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorSchedule> updateTutorSchedule(@PathVariable Long id, @RequestBody TutorSchedule tutorSchedule) {
        Optional<TutorSchedule> tutorScheduleOptional = tutorScheduleService.findByClassId(id);
        return tutorScheduleOptional.map(tutorSchedule1 -> {
            tutorSchedule.setId(tutorSchedule1.getId());
            return new ResponseEntity<>(tutorScheduleService.save(tutorSchedule), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TutorSchedule> deleteTutorSchedule(@PathVariable Long id) {
        Optional<TutorSchedule> tutorScheduleOptional = tutorScheduleService.findByClassId(id);
        return tutorScheduleOptional.map(tutorSchedule -> {
            tutorScheduleService.deleteByClassId(id);
            return new ResponseEntity<>(tutorSchedule, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
