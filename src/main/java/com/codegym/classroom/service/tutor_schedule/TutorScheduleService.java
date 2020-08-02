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

    @Override
    public void deleteByClassId(Long classId) {
        tutorScheduleRepository.deleteByClassId(classId);
    }

    @Override
    public Optional<TutorSchedule> findByClassId(Long classId) {
        return tutorScheduleRepository.findByClassId(classId);
    }

    @Override
    public Iterable<Long> getTutorsInClass(Long classId) {
        return tutorScheduleRepository.getTutorsInClass(classId);
    }

    @Override
    public Iterable<TutorSchedule> getAllByLectureId(Long lectureId) {
        return tutorScheduleRepository.getAllByLectureId(lectureId);
    }
}
