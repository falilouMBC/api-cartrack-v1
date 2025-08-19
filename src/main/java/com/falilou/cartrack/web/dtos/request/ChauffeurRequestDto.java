package com.falilou.cartrack.web.dtos.request;

import com.falilou.cartrack.entities.Livraison;
import com.falilou.cartrack.entities.Permis;
import com.falilou.cartrack.entities.Utilisateur;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.falilou.cartrack.entities.Chauffeur}
 */
public record ChauffeurRequestDto(Utilisateur utilisateur, Permis permis,
                                  List<Livraison> livraisons) implements Serializable {
}