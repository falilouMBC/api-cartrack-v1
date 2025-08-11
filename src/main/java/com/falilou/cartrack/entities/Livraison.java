package com.falilou.cartrack.entities;

import com.falilou.cartrack.enums.StatutLivraison;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TD_livraison")
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Liv_id", nullable = false)
    private Long id;

    @Column(name = "Liv_code", nullable = false, unique = true)
    private String codeLivraison;

    @Column(name = "Liv_desc")
    private String description;

    @Column(name = "Liv_statut", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatutLivraison statut;

    @Column(name = "Liv_pri")
    private Integer priorite;

    @Column(name = "Liv_adreDep", nullable = false)
    private String adresseDepart;

    @Column(name = "Liv_adreArr", nullable = false)
    private String adresseArrivee;

    @Column(name = "Liv_date",nullable = false)
    private LocalDate dateLivraison;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Chauf_liv_id", nullable = false,referencedColumnName = "Chauf_id")
    private Chauffeur chauffeur;

}