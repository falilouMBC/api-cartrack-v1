package com.falilou.cartrack.web.dtos.request.response;

import com.falilou.cartrack.enums.TypePermis;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.falilou.cartrack.entities.Permis}
 */
public record PermisResponseDto(TypePermis typePermis, String numeroPermis, LocalDate datePermis) implements Serializable {
}