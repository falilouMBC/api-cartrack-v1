package com.falilou.cartrack.web.response;

import com.falilou.cartrack.enums.Role;

import java.io.Serializable;

/**
 * DTO for {@link com.falilou.cartrack.entities.Utilisateur}
 */
public record UtilisateurResponseDto(Long idUtilisateur, String nom, String prenom, String username,
                                     Role role) implements Serializable {
}