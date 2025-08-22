package com.falilou.cartrack.enums;

public enum Status {
    // Succès (20x)
    OK,
    CREATED,

    // Erreurs client (4xx)
    BAD_REQUEST,
    UNAUTHORIZED,
    FORBIDDEN,
    NOT_FOUND,
    METHOD_NOT_ALLOWED,
    CONFLICT,
    VALIDATION_ERROR,

    // Erreurs spécifiques métier
    DISABLED_ACCOUNT,
    EXPIRED_TOKEN,
    INVALID_CREDENTIALS,
    ACCOUNT_LOCKED,

    // Erreurs serveur (5xx)
    INTERNAL_SERVER_ERROR,
    SERVICE_UNAVAILABLE,
    DATABASE_ERROR
}
