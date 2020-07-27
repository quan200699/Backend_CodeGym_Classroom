package com.codegym.classroom.controller;

import com.codegym.classroom.model.Classroom;
import com.codegym.classroom.service.class_room_schedule.IClassRoomScheduleService;
import com.codegym.classroom.service.classroom.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/classrooms")
public class ClassroomController {
    @Autowired
    private IClassroomService classroomService;

    @Autowired
    private IClassRoomScheduleService classRoomScheduleService;

    @GetMapping
    public ResponseEntity<Iterable<Classroom>> getAllClassroom() {
        return new ResponseEntity<>(classroomService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getClassroom(@PathVariable Long id) {
        Optional<Classroom> classroomOptional = classroomService.findById(id);
        return classroomOptional.map(classroom -> new ResponseEntity<>(classroom, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Classroom> createNewClassroom(@RequestBody Classroom classroom) {
        return new ResponseEntity<>(classroomService.save(classroom), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable Long id, @RequestBody Classroom classroom) {
        Optional<Classroom> classroomOptional = classroomService.findById(id);
        return classroomOptional.map(classroom1 -> {
            classroom.setId(classroom1.getId());
            return new ResponseEntity<>(classroomService.save(classroom), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Classroom> deleteClassroom(@PathVariable Long id) {
        Optional<Classroom> classroomOptional = classroomService.findById(id);
        return classroomOptional.map(classroom -> {
            classroomService.remove(id);
            return new ResponseEntity<>(classroom, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/classes")
    public ResponseEntity<Iterable<Long>> getAllClassesByClassroom(@PathVariable Long id, @RequestParam Integer month) {
        Optional<Classroom> classroomOptional = classroomService.findById(id);
        if (month == null) {
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            month = localDate.getMonthValue();
        }
        Integer finalMonth = month;
        return classroomOptional.map(classroom ->
                new ResponseEntity<>(classRoomScheduleService.getAllClassId(classroom.getId(), finalMonth), HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
