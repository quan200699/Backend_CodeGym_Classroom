package com.codegym.classroom.service.coach_schedule;

import com.codegym.classroom.model.CoachSchedule;
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
}
