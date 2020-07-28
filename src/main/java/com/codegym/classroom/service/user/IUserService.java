package com.codegym.classroom.service.user;

import com.codegym.classroom.model.entity.auth.User;
import com.codegym.classroom.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByEmail(String email);
}
