package com.img.Event_organization.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CollegeNotAllowedException extends Exception{
    public CollegeNotAllowedException(String exception){
        super(exception);
    }
}
