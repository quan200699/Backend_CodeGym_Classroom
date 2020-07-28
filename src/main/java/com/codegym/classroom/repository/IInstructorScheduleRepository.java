package com.codegym.classroom.repository;

import com.codegym.classroom.model.entity.InstructorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IInstructorScheduleRepository extends JpaRepository<InstructorSchedule, Long> {
    void deleteByClassId(Long classId);
    Optional<InstructorSchedule> findByClassId(Long classId);
}
