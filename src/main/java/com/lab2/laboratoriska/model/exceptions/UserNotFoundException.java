package com.lab2.laboratoriska.model.exceptions;

import com.lab2.laboratoriska.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String username){
        super(String.format("The user with username %s does not exist", username));
    }

}
