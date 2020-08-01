package com.codegym.classroom.controller;

import com.codegym.classroom.model.entity.CoachSchedule;
import com.codegym.classroom.model.entity.InstructorSchedule;
import com.codegym.classroom.service.instructor_schedule.IInstructorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/instructor-schedules")
public class InstructorScheduleController {
    @Autowired
    private IInstructorScheduleService instructorScheduleService;

    @GetMapping
    public ResponseEntity<Iterable<InstructorSchedule>> getAllInstructorSchedule() {
        return new ResponseEntity<>(instructorScheduleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorSchedule> getInstructorSchedule(@PathVariable Long id) {
        Optional<InstructorSchedule> instructorScheduleOptional = instructorScheduleService.findById(id);
        return instructorScheduleOptional.map(instructorSchedule -> new ResponseEntity<>(instructorSchedule, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<InstructorSchedule> createInstructorSchedule(@RequestBody InstructorSchedule instructorSchedule) {
        return new ResponseEntity<>(instructorScheduleService.save(instructorSchedule), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorSchedule> updateInstructorSchedule(@PathVariable Long id, @RequestBody InstructorSchedule instructorSchedule) {
        Optional<InstructorSchedule> instructorScheduleOptional = instructorScheduleService.findByClassId(id);
        return instructorScheduleOptional.map(instructorSchedule1 -> {
            instructorSchedule.setId(instructorSchedule1.getId());
            return new ResponseEntity<>(instructorScheduleService.save(instructorSchedule), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InstructorSchedule> deleteInstructorSchedule(@PathVariable Long id) {
        Optional<InstructorSchedule> instructorScheduleOptional = instructorScheduleService.findByClassId(id);
        return instructorScheduleOptional.map(instructorSchedule -> {
            instructorScheduleService.deleteByClassId(id);
            return new ResponseEntity<>(instructorSchedule, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
