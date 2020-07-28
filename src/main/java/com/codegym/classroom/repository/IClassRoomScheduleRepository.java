package com.codegym.classroom.repository;

import com.codegym.classroom.model.ClassRoomSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClassRoomScheduleRepository extends JpaRepository<ClassRoomSchedule, Long> {
    @Query(value = "select class_id from classroom_management.class_room_schedule left join classroom_management.classroom c on class_room_schedule.classroom_id = c.id where classroom_id = ?1 and month(created_date) = ?2", nativeQuery = true)
    Iterable<Long> getAllClassId(Long id, Integer month);

    @Query(value = "select class_id from classroom_management.class_room_schedule left join classroom_management.classroom c on class_room_schedule.classroom_id = c.id", nativeQuery = true)
    Iterable<Long> getAllClass();

    Optional<ClassRoomSchedule> findByClassId(Long classId);

    @Query(value = "DELETE FROM classroom_management.class_room_schedule WHERE class_id = ?1 AND MONTH(created_date) = ?2", nativeQuery = true)
    void deleteByClassId(Long classId, Integer month);

    @Query(value = "SELECT * FROM classroom_management.class_room_schedule WHERE MONTH(created_date) = ?1", nativeQuery = true)
    Iterable<ClassRoomSchedule> getAllClassRoomScheduleByMonth(Integer month);
}
