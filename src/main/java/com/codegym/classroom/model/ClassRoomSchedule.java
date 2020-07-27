package com.codegym.classroom.model;

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

    @Column(unique = true)
    private Long classId;

    private Integer numberOfStudent;

    private Date createdDate;
}
