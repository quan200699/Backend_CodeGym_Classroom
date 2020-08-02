package com.codegym.classroom.service.coach_schedule;

import com.codegym.classroom.model.entity.CoachSchedule;
import com.codegym.classroom.repository.ICoachScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachScheduleService implements ICoachScheduleService {
    @Autowired
    private ICoachScheduleRepository coachScheduleRepository;

    @Override
    public Iterable<CoachSchedule> findAll() {
        return coachScheduleRepository.findAll();
    }

    @Override
    public Optional<CoachSchedule> findById(Long id) {
        return coachScheduleRepository.findById(id);
    }

    @Override
    public CoachSchedule save(CoachSchedule coachSchedule) {
        return coachScheduleRepository.save(coachSchedule);
    }

    @Override
    public void remove(Long id) {
        coachScheduleRepository.deleteById(id);
    }

    @Override
    public void deleteByClassId(Long classId) {
        coachScheduleRepository.deleteByClassId(classId);
    }

    @Override
    public Optional<CoachSchedule> findByClassId(Long classId) {
        return coachScheduleRepository.findByClassId(classId);
    }

    @Override
    public Long getCoachInClass(Long classId) {
        return coachScheduleRepository.getCoachInClass(classId);
    }

    @Override
    public Iterable<Long> getAllByLectureId(Long lectureId) {
        return coachScheduleRepository.getAllByLectureId(lectureId);
    }
}
