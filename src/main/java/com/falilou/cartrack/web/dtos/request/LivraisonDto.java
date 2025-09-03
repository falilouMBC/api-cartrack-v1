package com.falilou.cartrack.web.dtos.request;

import com.falilou.cartrack.entities.Chauffeur;
import com.falilou.cartrack.enums.StatutLivraison;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.falilou.cartrack.entities.Livraison}
 */
public record LivraisonDto(String codeLivraison, String description, StatutLivraison statut, Integer priorite,
                           String adresseDepart, String adresseArrivee, LocalDate dateLivraison,
                           Chauffeur chauffeur) implements Serializable {
}