package com.falilou.cartrack.web.dtos.request;

import com.falilou.cartrack.enums.Role;

import java.io.Serializable;

/**
 * DTO for {@link com.falilou.cartrack.entities.Utilisateur}
 */
public record UtilisateurRequestDto(String nom, String prenom, String username, Role role) implements Serializable {
}