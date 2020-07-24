package com.codegym.classroom.controller;

import com.codegym.classroom.model.ClassRoomSchedule;
import com.codegym.classroom.service.class_room_schedule.IClassRoomScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/class-room-schedules")
public class ClassRoomScheduleController {
    @Autowired
    private IClassRoomScheduleService classRoomScheduleService;

    @GetMapping
    public ResponseEntity<Iterable<ClassRoomSchedule>> getAllClassRoomSchedule() {
        return new ResponseEntity<>(classRoomScheduleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRoomSchedule> getClassRoomSchedule(@PathVariable Long id) {
        Optional<ClassRoomSchedule> classRoomScheduleOptional = classRoomScheduleService.findById(id);
        return classRoomScheduleOptional.map(classroom -> new ResponseEntity<>(classroom, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ClassRoomSchedule> createNewClassRoomSchedule(@RequestBody ClassRoomSchedule classRoomSchedule) {
        return new ResponseEntity<>(classRoomScheduleService.save(classRoomSchedule), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassRoomSchedule> updateClassRoomSchedule(@PathVariable Long id, @RequestBody ClassRoomSchedule classRoomSchedule) {
        Optional<ClassRoomSchedule> classRoomScheduleOptional = classRoomScheduleService.findById(id);
        return classRoomScheduleOptional.map(classRoomSchedule1 -> {
            classRoomSchedule.setId(classRoomSchedule1.getId());
            return new ResponseEntity<>(classRoomScheduleService.save(classRoomSchedule), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassRoomSchedule> deleteClassRoomSchedule(@PathVariable Long id) {
        Optional<ClassRoomSchedule> classRoomScheduleOptional = classRoomScheduleService.findById(id);
        return classRoomScheduleOptional.map(classRoomSchedule -> {
            classRoomScheduleService.remove(id);
            return new ResponseEntity<>(classRoomSchedule, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/classes")
    public ResponseEntity<Iterable<Long>> getAllClasses() {
        return new ResponseEntity<>(classRoomScheduleService.getAllClass(), HttpStatus.OK);
    }
}
