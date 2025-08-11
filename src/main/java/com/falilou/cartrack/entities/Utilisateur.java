package com.falilou.cartrack.entities;

import com.falilou.cartrack.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TD_utilisateur")
public class Utilisateur {
    @Column(unique = true, nullable = false, name = "Uti_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;

    @Column(nullable = false,name = "Uti_nom", length = 50)
    private String nom;

    @Column(name = "Uti_prenom", length = 50, nullable = false)
    private String prenom;

    @Column(name = "Uti_username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "Uti_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
