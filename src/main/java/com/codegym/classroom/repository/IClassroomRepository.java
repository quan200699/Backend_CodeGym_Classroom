package com.codegym.classroom.repository;

import com.codegym.classroom.model.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassroomRepository extends JpaRepository<Classroom, Long> {
    @Query(value = "SELECT * FROM classroom_management.classroom WHERE center_id = ?1", nativeQuery = true)
    Iterable<Classroom> getAllClassroomByCenter(Long centerId);
}
