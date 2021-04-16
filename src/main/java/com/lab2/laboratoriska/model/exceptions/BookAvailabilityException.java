package com.lab2.laboratoriska.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookAvailabilityException extends RuntimeException {

    public BookAvailabilityException(Long id){
        super(String.format("The book with id %d is not available", id));
    }

}
