package com.codegym.classroom.service.tutor_schedule;

import com.codegym.classroom.model.entity.TutorSchedule;
import com.codegym.classroom.service.IGeneralService;

import java.util.Optional;

public interface ITutorScheduleService extends IGeneralService<TutorSchedule> {
    void deleteByClassId(Long classId);

    Optional<TutorSchedule> findByClassId(Long classId);

    Iterable<Long> getTutorsInClass(Long classId);
}
