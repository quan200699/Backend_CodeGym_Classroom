package com.codegym.classroom;

import com.codegym.classroom.model.Classroom;
import com.codegym.classroom.service.classroom.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class ClassroomApplication {

    @Autowired
    private IClassroomService classroomService;

    @PostConstruct
    public void init() {
        List<Classroom> classrooms = (List<Classroom>) classroomService.findAll();
        if (classrooms.isEmpty()) {
            Classroom classroom1 = new Classroom();
            classroom1.setName("Tầng 3 TT01");
            classroom1.setCapacity(49);
            classroomService.save(classroom1);
            Classroom classroom2 = new Classroom();
            classroom2.setName("Tầng 4 TT01");
            classroom2.setCapacity(45);
            classroomService.save(classroom2);
            Classroom classroom3 = new Classroom();
            classroom3.setName("Tầng 1 TT04");
            classroom3.setCapacity(36);
            classroomService.save(classroom3);
            Classroom classroom4 = new Classroom();
            classroom4.setName("Tầng 2 TT04");
            classroom4.setCapacity(30);
            classroomService.save(classroom4);
            Classroom classroom5 = new Classroom();
            classroom5.setName("Tầng 3 TT04");
            classroom5.setCapacity(36);
            classroomService.save(classroom5);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ClassroomApplication.class, args);
    }

}
