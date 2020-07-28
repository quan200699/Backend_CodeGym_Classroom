package com.codegym.classroom.service.coach_schedule;

import com.codegym.classroom.model.entity.CoachSchedule;
import com.codegym.classroom.service.IGeneralService;

import java.util.Optional;

public interface ICoachScheduleService extends IGeneralService<CoachSchedule> {
    void deleteByClassId(Long classId);

    Optional<CoachSchedule> findByClassId(Long classId);

    Long getCoachInClass(Long classId);
}
