package com.codegym.classroom.service.class_room_schedule;

import com.codegym.classroom.model.ClassRoomSchedule;
import com.codegym.classroom.repository.IClassRoomScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomScheduleService implements IClassRoomScheduleService {
    @Autowired
    private IClassRoomScheduleRepository classRoomScheduleRepository;

    @Override
    public Iterable<ClassRoomSchedule> findAll() {
        return classRoomScheduleRepository.findAll();
    }

    @Override
    public Optional<ClassRoomSchedule> findById(Long id) {
        return classRoomScheduleRepository.findById(id);
    }

    @Override
    public ClassRoomSchedule save(ClassRoomSchedule classRoomSchedule) {
        return classRoomScheduleRepository.save(classRoomSchedule);
    }

    @Override
    public void remove(Long id) {
        classRoomScheduleRepository.deleteById(id);
    }
}
