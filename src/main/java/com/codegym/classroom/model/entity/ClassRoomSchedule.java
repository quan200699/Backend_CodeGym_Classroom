package com.codegym.classroom.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ClassRoomSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Classroom classroom;

    private Long classId;

    private Integer numberOfStudent;

    private Date createdDate;
}
