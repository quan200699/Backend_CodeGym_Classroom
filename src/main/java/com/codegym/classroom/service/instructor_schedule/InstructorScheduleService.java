package com.codegym.classroom.service.instructor_schedule;

import com.codegym.classroom.model.entity.InstructorSchedule;
import com.codegym.classroom.repository.IInstructorScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorScheduleService implements IInstructorScheduleService {
    @Autowired
    private IInstructorScheduleRepository instructorScheduleRepository;

    @Override
    public void deleteByClassId(Long classId) {
        instructorScheduleRepository.deleteByClassId(classId);
    }

    @Override
    public Optional<InstructorSchedule> findByClassId(Long classId) {
        return instructorScheduleRepository.findByClassId(classId);
    }

    @Override
    public Iterable<InstructorSchedule> findAll() {
        return instructorScheduleRepository.findAll();
    }

    @Override
    public Optional<InstructorSchedule> findById(Long id) {
        return instructorScheduleRepository.findById(id);
    }

    @Override
    public InstructorSchedule save(InstructorSchedule instructorSchedule) {
        return instructorScheduleRepository.save(instructorSchedule);
    }

    @Override
    public void remove(Long id) {
        instructorScheduleRepository.deleteById(id);
    }
}
