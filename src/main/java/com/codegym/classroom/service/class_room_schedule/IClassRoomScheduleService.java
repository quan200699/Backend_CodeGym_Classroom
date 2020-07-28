package com.codegym.classroom.service.class_room_schedule;

import com.codegym.classroom.model.entity.ClassRoomSchedule;
import com.codegym.classroom.service.IGeneralService;

import java.util.Optional;

public interface IClassRoomScheduleService extends IGeneralService<ClassRoomSchedule> {
    Iterable<Long> getAllClassId(Long id, Integer month);

    Iterable<Long> getAllClass();

    Optional<ClassRoomSchedule> findByClassId(Long classId);

    void deleteByClassId(Long classId);

    Iterable<ClassRoomSchedule> getAllClassRoomScheduleByMonth(Integer month);
}
