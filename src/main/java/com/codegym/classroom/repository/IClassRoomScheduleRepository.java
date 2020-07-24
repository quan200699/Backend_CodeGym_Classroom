package com.codegym.classroom.repository;

import com.codegym.classroom.model.ClassRoomSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRoomScheduleRepository extends JpaRepository<ClassRoomSchedule, Long> {
    @Query(value = "select class_id from classroom_management.class_room_schedule left join classroom_management.classroom c on class_room_schedule.classroom_id = c.id where classroom_id = ?1", nativeQuery = true)
    Iterable<Long> getAllClassId(Long id);
}
