package com.codegym.classroom.repository;

import com.codegym.classroom.model.entity.CoachSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICoachScheduleRepository extends JpaRepository<CoachSchedule, Long> {
    void deleteByClassId(Long classId);
    Optional<CoachSchedule> findByClassId(Long classId);
}
