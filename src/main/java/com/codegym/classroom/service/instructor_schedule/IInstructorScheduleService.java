package com.codegym.classroom.service.instructor_schedule;

import com.codegym.classroom.model.entity.InstructorSchedule;
import com.codegym.classroom.service.IGeneralService;

import java.util.Optional;

public interface IInstructorScheduleService extends IGeneralService<InstructorSchedule> {
    void deleteByClassId(Long classId);

    Optional<InstructorSchedule> findByClassId(Long classId);

    InstructorSchedule getInstructorInClass(Long classId);
}
