package com.codegym.classroom.repository;

import com.codegym.classroom.model.CoachSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoachScheduleRepository extends JpaRepository<CoachSchedule, Long> {
}
