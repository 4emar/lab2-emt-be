package com.lab2.laboratoriska.web;


import com.lab2.laboratoriska.model.dto.LoginDto;
import com.lab2.laboratoriska.model.dto.RegisterDto;
import com.lab2.laboratoriska.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public HttpStatus registerUser(@RequestBody RegisterDto registerDto){
        this.userService.signUpUser(registerDto);
        return HttpStatus.OK;
    }

    @PostMapping("/signIn")
    public ResponseEntity<Boolean> loginUser(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok().body(this.userService.signInUser(loginDto));
    }

}
