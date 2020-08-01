package com.codegym.classroom.repository;

import com.codegym.classroom.model.entity.TutorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITutorScheduleRepository extends JpaRepository<TutorSchedule, Long> {
}
