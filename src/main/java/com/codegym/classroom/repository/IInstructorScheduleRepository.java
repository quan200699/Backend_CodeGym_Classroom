package com.codegym.classroom.repository;

import com.codegym.classroom.model.entity.InstructorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IInstructorScheduleRepository extends JpaRepository<InstructorSchedule, Long> {
    void deleteByClassId(Long classId);
    Optional<InstructorSchedule> findByClassId(Long classId);

    @Query(value = "select lecture_id from classroom_management.instructor_schedule where class_id = ?1", nativeQuery = true)
    Long getInstructorInClass(Long classId);
}
