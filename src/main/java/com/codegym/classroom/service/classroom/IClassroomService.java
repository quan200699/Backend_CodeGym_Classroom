package com.codegym.classroom.service.classroom;

import com.codegym.classroom.model.entity.Classroom;
import com.codegym.classroom.service.IGeneralService;

public interface IClassroomService extends IGeneralService<Classroom> {
    Iterable<Classroom> getAllClassroomByCenter(Long centerId);
}
