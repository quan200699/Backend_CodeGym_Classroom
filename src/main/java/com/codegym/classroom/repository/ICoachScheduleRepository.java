package com.codegym.classroom.repository;

import com.codegym.classroom.model.entity.CoachSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICoachScheduleRepository extends JpaRepository<CoachSchedule, Long> {
    void deleteByClassId(Long classId);

    Optional<CoachSchedule> findByClassId(Long classId);

    @Query(value = "select lecture_id from classroom_management.coach_schedule where class_id = ?1", nativeQuery = true)
    Long getCoachInClass(Long classId);

    Iterable<CoachSchedule> getAllByLectureId(Long lectureId);

    @Query(value = "Select max(total)\n" +
            "from (Select count(class_id) as total\n" +
            "      from classroom_management .coach_schedule\n" +
            "      group by lecture_id) as result", nativeQuery = true)
    Integer getMaxValueCoachClass();
}
