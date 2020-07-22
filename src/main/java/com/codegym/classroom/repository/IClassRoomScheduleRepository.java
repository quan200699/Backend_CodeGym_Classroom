package com.codegym.classroom.repository;

import com.codegym.classroom.model.ClassRoomSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRoomScheduleRepository extends JpaRepository<ClassRoomSchedule, Long> {
}
