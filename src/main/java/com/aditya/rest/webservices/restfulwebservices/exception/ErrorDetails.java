package com.aditya.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private final String description;
    private final String message;
    private final LocalDateTime time;

    public ErrorDetails(LocalDateTime time, String message, String description) {
        this.time = time;
        this.message = message;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
