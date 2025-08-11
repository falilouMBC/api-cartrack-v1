package com.falilou.cartrack.enums;

import lombok.Getter;

@Getter
public enum TypePermis {
    PERMIS_A("Permis_A"),
    PERMIS_B("Permis_B");

    private final String permis;
    TypePermis(final String permis) {
        this.permis = permis;
    }
}
