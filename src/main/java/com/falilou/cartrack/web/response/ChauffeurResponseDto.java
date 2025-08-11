package com.falilou.cartrack.web.response;

import com.falilou.cartrack.entities.Livraison;
import com.falilou.cartrack.entities.Permis;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.falilou.cartrack.entities.Chauffeur}
 */
public record ChauffeurResponseDto(Long id, UtilisateurResponseDto utilisateur, Permis permis,
                                   List<Livraison> livraisons) implements Serializable {
}