package com.lab2.laboratoriska.service;

import com.lab2.laboratoriska.model.User;
import com.lab2.laboratoriska.model.dto.LoginDto;
import com.lab2.laboratoriska.model.dto.RegisterDto;

import java.util.List;

public interface UserService {

    User findById(String username);

    List<User> findAll();

    Boolean signInUser(LoginDto loginDto);

    void signUpUser(RegisterDto registerDto);

}
