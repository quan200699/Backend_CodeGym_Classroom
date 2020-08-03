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

    Iterable<TutorSchedule> getAllByLectureId(Long lectureId);

    @Query(value = "select distinct lecture_id " +
            "from classroom_management.tutor_schedule" +
            "         left join classroom_management.class_room_schedule crs on" +
            " classroom_management.tutor_schedule.class_id = crs.class_id left join classroom_management.classroom c" +
            " on crs.classroom_id = c.id " +
            "where classroom_id = ?1 and lecture_id not in (select distinct lecture_id " +
            "from classroom_management.class_room_schedule left join classroom_management.instructor_schedule i " +
            "on class_room_schedule.class_id = i.class_id where class_time=?2);", nativeQuery = true)
    Iterable<Long> getAllLectureHasFreeTime(Long classroomId, String classTime);
}
