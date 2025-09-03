package com.falilou.cartrack.exceptions;

import com.falilou.cartrack.web.dtos.response.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(BusinessException.BadRequest.class)
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Void>> handleValidationError(MethodArgumentNotValidException ex) {

        log.warn("Validation errors: {}",ex.getMessage(), ex);

        List<Response.ValidationError> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::mapFieldError)
                .collect(Collectors.toList());

        Response<Void> response = Response.<Void>badRequest("Erreur de validation")
                .withValidationErrors(validationErrors)
                .withError("VALIDATION_ERROR");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }

    @ExceptionHandler(BusinessException.ValidationError.class)
    public ResponseEntity<Response<Void>> handleValidation(BusinessException.ValidationError ex) {

        log.warn("Validation error: {}",ex.getMessage(), ex);

        Response<Void> response = Response.<Void>badRequest("Erreur de validation")
                .withError("VALIDATION_ERROR");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Response<Void>> handleIllegalArgumentException(
            IllegalArgumentException ex) {

        log.warn("Illegal argument: {}",ex.getMessage(), ex);

        Response<Void> response = Response.<Void>badRequest(ex.getMessage())
                .withError("ILLEGAL_ARGUMENT");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response<Void>> handleRuntimeException(RuntimeException ex) {

        log.error("RuntimeException: {}",ex.getMessage(), ex);

        Response<Void> response = Response.<Void>internalServerError(ex.getMessage())
                .withError("INTERNAL_SERVER_ERROR")
                .withAdditionalInfo("exceptionType", ex.getClass().getName());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handleGeneralException(Exception ex) {
        log.error("GeneralException: {}",ex.getMessage(), ex);

        Response<Void> response = Response.<Void>internalServerError(ex.getMessage())
                .withError("INTERNAL_ERROR")
                .withAdditionalInfo("exceptionType", ex.getClass().getName());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    private Response.ValidationError mapFieldError(FieldError fieldError) {
        return Response.ValidationError.builder()
                .field(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .rejectedValue(fieldError.getRejectedValue())
                .build();
    }
}
