package com.codegym.classroom.model;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int capacity;
}