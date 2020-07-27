package com.codegym.classroom.service.class_room_schedule;

import com.codegym.classroom.model.ClassRoomSchedule;
import com.codegym.classroom.repository.IClassRoomScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        long currentTime = System.currentTimeMillis();
        Date currentDate = new Date(currentTime);
        classRoomSchedule.setCreatedDate(currentDate);
        return classRoomScheduleRepository.save(classRoomSchedule);
    }

    @Override
    public void remove(Long id) {
        classRoomScheduleRepository.deleteById(id);
    }

    @Override
    public Iterable<Long> getAllClassId(Long id, Integer month) {
        return classRoomScheduleRepository.getAllClassId(id, month);
    }

    @Override
    public Iterable<Long> getAllClass() {
        return classRoomScheduleRepository.getAllClass();
    }

    @Override
    public Optional<ClassRoomSchedule> findByClassId(Long classId) {
        return classRoomScheduleRepository.findByClassId(classId);
    }

    @Override
    public void deleteByClassId(Long classId) {
        classRoomScheduleRepository.deleteByClassId(classId);
    }

    @Override
    public Iterable<ClassRoomSchedule> getAllClassRoomScheduleByMonth(Integer month) {
        return classRoomScheduleRepository.getAllClassRoomScheduleByMonth(month);
    }
}
