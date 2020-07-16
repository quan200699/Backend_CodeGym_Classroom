package com.codegym.classroom.service.role;

import com.codegym.classroom.model.auth.Role;
import com.codegym.classroom.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
