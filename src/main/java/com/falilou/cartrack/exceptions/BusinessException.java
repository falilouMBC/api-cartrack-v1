package com.falilou.cartrack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BusinessException extends RuntimeException {
    private final String code;

    protected BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    protected BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class UserNotFoundException extends BusinessException {
        public UserNotFoundException(Long id) {
            super("Not Found", String.format("Not Found: %s", id));
        }
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public static class InternalServerError extends BusinessException {
        public InternalServerError(String message) {
            super("Internal Server Error", message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequest extends BusinessException {
        public BadRequest(String message) {
            super("Bad Request", message);
        }
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public static class Unauthorized extends BusinessException {
        public Unauthorized(String message) {
            super("Unauthorized", message);
        }
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    public static class InsufficientPermissionsException extends BusinessException {
        public InsufficientPermissionsException(String action) {
            super("Insufficient Permissions", action);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class MethodArgumentNotValidException extends BusinessException {
        public MethodArgumentNotValidException(String message) {
            super("MethodArgumentNotValid", message);
        }
    }
}
