package com.falilou.cartrack.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TD_chauffeur")
@Getter
@Setter
public class Chauffeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false,name = "Chauf_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Uti_chauff_id", nullable = false, referencedColumnName = "Uti_id")
    private Utilisateur utilisateur;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Per_chauff_id", nullable = false, referencedColumnName = "Per_id")
    private Permis permis;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Tpr_livaison_chauffeur",
        joinColumns = @JoinColumn(name = "CHAUF_id",referencedColumnName = "chauf_id"),
        inverseJoinColumns =@JoinColumn(name = "LIV_id",referencedColumnName = "Liv_id")
    )
    private List<Livraison> livraisons = new ArrayList<>();
}
