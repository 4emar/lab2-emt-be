package com.lab2.laboratoriska.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserExistsException extends RuntimeException{

    public UserExistsException(String username){
        super(String.format("The user with username %s already exists.", username));
    }

}
