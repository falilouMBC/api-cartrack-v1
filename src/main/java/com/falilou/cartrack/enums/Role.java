package com.falilou.cartrack.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Role {
    ADMIN("Administrateur"),
    DRIVER("Chauffeur");

    public final String role;

    Role(String role) {
        this.role = role;
    }

}
