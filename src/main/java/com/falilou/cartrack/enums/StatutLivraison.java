package com.falilou.cartrack.enums;

import lombok.Getter;

@Getter
public enum StatutLivraison {
    EN_ATTENTE("En attente"),
    PLANIFIEE("Planifiée"),
    EN_COURS("En cours"),
    EN_ROUTE("En route"),
    LIVREE("Livrée"),
    ANNULEE("Annulée"),
    REPORTEE("Reportée"),
    ECHEC("Échec de livraison");

    private final String description;

    StatutLivraison(String description) {
        this.description = description;
    }
}
