package com.codegym.classroom.controller;

import com.codegym.classroom.model.CoachSchedule;
import com.codegym.classroom.service.coach_schedule.ICoachScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/coach-schedules")
public class CoachScheduleController {
    @Autowired
    private ICoachScheduleService coachScheduleService;

    @GetMapping
    public ResponseEntity<Iterable<CoachSchedule>> getAllCoachSchedule() {
        return new ResponseEntity<>(coachScheduleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachSchedule> getCoachSchedule(@PathVariable Long id) {
        Optional<CoachSchedule> coachScheduleOptional = coachScheduleService.findById(id);
        return coachScheduleOptional.map(coachSchedule -> new ResponseEntity<>(coachSchedule, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CoachSchedule> createCoachSchedule(@RequestBody CoachSchedule coachSchedule) {
        return new ResponseEntity<>(coachScheduleService.save(coachSchedule), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoachSchedule> updateCoachSchedule(@PathVariable Long id, @RequestBody CoachSchedule coachSchedule) {
        Optional<CoachSchedule> coachScheduleOptional = coachScheduleService.findByClassId(id);
        return coachScheduleOptional.map(coachSchedule1 -> {
            coachSchedule.setId(coachSchedule1.getId());
            return new ResponseEntity<>(coachScheduleService.save(coachSchedule), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CoachSchedule> deleteCoachSchedule(@PathVariable Long id) {
        Optional<CoachSchedule> coachScheduleOptional = coachScheduleService.findByClassId(id);
        return coachScheduleOptional.map(coachSchedule -> {
            coachScheduleService.deleteByClassId(id);
            return new ResponseEntity<>(coachSchedule, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
