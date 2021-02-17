package com.trl.userserviceb.core.service.exception;

import com.trl.userserviceb.exception.UserServiceException;

public class UserNotFoundException extends UserServiceException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
