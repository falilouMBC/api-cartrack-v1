package com.falilou.cartrack.exceptions;

import com.falilou.cartrack.web.dtos.response.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.UserNotFoundException.class)
    public ResponseEntity<Response<Void>> handleUserNotFound(
            BusinessException.UserNotFoundException ex, HttpServletRequest request) {

        log.error("Utilisateur non trouvé: {}",ex.getMessage(), ex);

        Response<Void> response = Response.<Void>notFound(ex.getMessage())
                .withError("USER_NOT_FOUND");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.Unauthorized.class)
    public ResponseEntity<Response<Void>> handleUnauthorized(BusinessException.Unauthorized ex) {
        log.warn("Unauthorized exception: {}",ex.getMessage(), ex);

        Response<Void> response = Response.<Void>unauthorized(ex.getMessage())
                .withError("UNAUTHORIZED");

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BusinessException.InternalServerError.class)
    public ResponseEntity<Response<Void>> handleInternalServerError(
            BusinessException.InternalServerError ex) {

        log.warn("Internal server error: {}",ex.getMessage(), ex);

        Response<Void> response = Response.<Void>internalServerError(ex.getMessage())
                .withError("INTERNAL_SERVER_ERROR");

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Response<Void>> handleBadRequest(BusinessException.BadRequest ex) {

        log.warn("Bad request: {}",ex.getMessage(), ex);

        Response<Void> response = Response.<Void>badRequest(ex.getMessage())
                .withError("BAD_REQUEST");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.InsufficientPermissionsException.class)
    public ResponseEntity<Response<Void>> handleInsufficientPermissions(
            BusinessException.InsufficientPermissionsException ex, HttpServletRequest request) {

        log.warn("Insufficient permissions: {}",ex.getMessage(), ex);

        Response<Void> response = Response.<Void>forbidden(ex.getMessage())
                .withError("INSUFFICIENT_PERMISSIONS");

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

/*    public ResponseEntity<Response<Void>> handleValidationErros(
            BusinessException.MethodArgumentNotValidException ex) {

        log.warn("Validation errors: {}",ex.getMessage(), ex);

        BindingResult bindingResult = ex.getB

        List<Response.ValidationError> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::mapFieldError)
                .collect(Collectors.toList());
    }*/
}
