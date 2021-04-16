package com.lab2.laboratoriska.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorIdNotFoundException extends RuntimeException{

    public AuthorIdNotFoundException(Long id){
        super(String.format("The author with id %d cannot be found", id));
    }

}
