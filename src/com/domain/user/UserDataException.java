package com.domain.user;

/**
 * Created by Nick on 17.11.2015.
 */
public class UserDataException extends NullPointerException {
    public UserDataException(String message) {
        super(message);
    }

    public UserDataException() {
        super();
    }
}
