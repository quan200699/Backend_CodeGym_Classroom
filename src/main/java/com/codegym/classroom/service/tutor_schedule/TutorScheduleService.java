package com.codegym.classroom.service.tutor_schedule;

import com.codegym.classroom.model.entity.TutorSchedule;
import com.codegym.classroom.repository.ITutorScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TutorScheduleService implements ITutorScheduleService {
    @Autowired
    private ITutorScheduleRepository tutorScheduleRepository;

    @Override
    public Iterable<TutorSchedule> findAll() {
        return tutorScheduleRepository.findAll();
    }

    @Override
    public Optional<TutorSchedule> findById(Long id) {
        return tutorScheduleRepository.findById(id);
    }

    @Override
    public TutorSchedule save(TutorSchedule tutorSchedule) {
        return tutorScheduleRepository.save(tutorSchedule);
    }

    @Override
    public void remove(Long id) {
        tutorScheduleRepository.deleteById(id);
    }
}
