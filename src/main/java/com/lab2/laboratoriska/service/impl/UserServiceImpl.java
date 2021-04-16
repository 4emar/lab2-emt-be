package com.lab2.laboratoriska.service.impl;

import com.lab2.laboratoriska.model.Role;
import com.lab2.laboratoriska.model.User;
import com.lab2.laboratoriska.model.dto.LoginDto;
import com.lab2.laboratoriska.model.dto.RegisterDto;
import com.lab2.laboratoriska.model.exceptions.UserExistsException;
import com.lab2.laboratoriska.model.exceptions.UserNotFoundException;
import com.lab2.laboratoriska.repository.RoleRepository;
import com.lab2.laboratoriska.repository.UserRepository;
import com.lab2.laboratoriska.service.UserService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public User findById(String username) {
        return this.userRepository.findById(username).orElseThrow(
                () -> new UserNotFoundException(username));
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Boolean signInUser(LoginDto loginDto) {
        User user = this.userRepository.findById(loginDto.getUsername()).orElseThrow(
                () -> new UserNotFoundException(loginDto.getUsername()));
        return true;
    }

    @Override
    public void signUpUser(RegisterDto registerDto) {

        if(this.userRepository.findById(registerDto.getUsername()).isPresent()){
            throw new UserExistsException(registerDto.getUsername());
        }

        User user = new User();

        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        Role role = this.roleRepository.findAll().stream().
                filter(r -> r.geteRole().name().equals(registerDto.getRole())).findFirst().get();

        user.setRole(role);

    }
}
