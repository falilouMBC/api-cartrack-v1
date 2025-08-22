package com.falilou.cartrack.web.dtos.response;

import com.falilou.cartrack.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Response<T> {
    private Object message;
    private T payload;
    private Status status;
    private int code;
    private LocalDateTime timestamp;
    private List<ValidationError> validationErrors;
    private Map<String, Object> additionalInfo;
    private String error;

    public Response(String message, T payload, String status) {
        this.message = message;
        this.payload = payload;
        this.status = Status.valueOf(status);
        this.timestamp = LocalDateTime.now();
    }

    // ============ Méthodes de succès ============

    public static <T> Response<T> ok() {
        return Response.<T>builder()
                .status(Status.OK)
                .code(200)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> ok(T payload) {
        return Response.<T>builder()
                .status(Status.OK)
                .code(200)
                .payload(payload)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> ok(T payload, String message) {
        return Response.<T>builder()
                .status(Status.OK)
                .code(200)
                .payload(payload)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> created() {
        return Response.<T>builder()
                .status(Status.CREATED)
                .code(201)
                .timestamp(LocalDateTime.now())
                .build();
    }

    // ============ Méthodes d'erreur ============

    public static <T> Response<T> badRequest() {
        return Response.<T>builder()
                .status(Status.BAD_REQUEST)
                .code(400)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> badRequest(String message) {
        return Response.<T>builder()
                .status(Status.BAD_REQUEST)
                .code(400)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> badRequest(String message, List<ValidationError> validationErrors) {
        return Response.<T>builder()
                .status(Status.BAD_REQUEST)
                .code(400)
                .message(message)
                .validationErrors(validationErrors)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> unauthorized() {
        return Response.<T>builder()
                .status(Status.UNAUTHORIZED)
                .code(401)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> unauthorized(String message) {
        return Response.<T>builder()
                .status(Status.UNAUTHORIZED)
                .code(401)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> forbidden() {
        return Response.<T>builder()
                .status(Status.FORBIDDEN)
                .code(403)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> forbidden(String message) {
        return Response.<T>builder()
                .status(Status.FORBIDDEN)
                .code(403)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> notFound() {
        return Response.<T>builder()
                .status(Status.NOT_FOUND)
                .code(404)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> notFound(String message) {
        return Response.<T>builder()
                .status(Status.NOT_FOUND)
                .code(404)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> internalServerError() {
        return Response.<T>builder()
                .status(Status.INTERNAL_SERVER_ERROR)
                .code(500)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> internalServerError(String message) {
        return Response.<T>builder()
                .status(Status.INTERNAL_SERVER_ERROR)
                .code(500)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> disabledAccount() {
        return Response.<T>builder()
                .status(Status.DISABLED_ACCOUNT)
                .code(423) // Locked
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> Response<T> disabledAccount(String message) {
        return Response.<T>builder()
                .status(Status.DISABLED_ACCOUNT)
                .code(423)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    // ============ Méthodes utilitaires ============

    public Response<T> withMessage(String message) {
        this.message = message;
        return this;
    }

    public Response<T> withPayload(T payload) {
        this.payload = payload;
        return this;
    }

    public Response<T> withError(String error) {
        this.error = error;
        return this;
    }

    public Response<T> withValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
        return this;
    }

    public Response<T> withAdditionalInfo(String key, Object value) {
        if (this.additionalInfo == null) {
            this.additionalInfo = new java.util.HashMap<>();
        }
        this.additionalInfo.put(key, value);
        return this;
    }

    public Response<T> withAdditionalInfo(Map<String, Object> additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public boolean isSuccess() {
        return status == Status.OK;
    }

    public boolean isError() {
        return !isSuccess();
    }

    // ============ Classe ValidationError ============

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ValidationError {
        private String field;
        private String message;
        private Object rejectedValue;
    }
}