package com.codegym.classroom.repository;

import com.codegym.classroom.model.entity.TutorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITutorScheduleRepository extends JpaRepository<TutorSchedule, Long> {
    void deleteByClassId(Long classId);

    Optional<TutorSchedule> findByClassId(Long classId);

    @Query(value = "select lecture_id from classroom_management.tutor_schedule where class_id = ?1", nativeQuery = true)
    Iterable<Long> getTutorsInClass(Long classId);
}
