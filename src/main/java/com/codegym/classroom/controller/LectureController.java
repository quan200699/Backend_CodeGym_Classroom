package com.codegym.classroom.controller;

import com.codegym.classroom.model.entity.CoachSchedule;
import com.codegym.classroom.model.entity.InstructorSchedule;
import com.codegym.classroom.model.entity.TutorSchedule;
import com.codegym.classroom.service.coach_schedule.ICoachScheduleService;
import com.codegym.classroom.service.instructor_schedule.IInstructorScheduleService;
import com.codegym.classroom.service.tutor_schedule.ITutorScheduleService;
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

    @Autowired
    private ITutorScheduleService tutorScheduleService;

    @GetMapping("/coaches/{id}/classes")
    public ResponseEntity<Iterable<CoachSchedule>> getAllClassesByCoach(@PathVariable Long id) {
        return new ResponseEntity<>(coachScheduleService.getAllByLectureId(id), HttpStatus.OK);
    }

    @GetMapping("/coaches/max")
    public ResponseEntity<Integer> getAllClassesByCoach() {
        return new ResponseEntity<>(coachScheduleService.getMaxValueCoachClass(), HttpStatus.OK);
    }

    @GetMapping("/instructors/{id}/classes")
    public ResponseEntity<Iterable<InstructorSchedule>> getAllClassesByInstructor(@PathVariable Long id) {
        return new ResponseEntity<>(instructorScheduleService.getAllByLectureId(id), HttpStatus.OK);
    }

    @GetMapping("/tutors/{id}/classes")
    public ResponseEntity<Iterable<TutorSchedule>> getAllClassesByTutor(@PathVariable Long id) {
        return new ResponseEntity<>(tutorScheduleService.getAllByLectureId(id), HttpStatus.OK);
    }
}
