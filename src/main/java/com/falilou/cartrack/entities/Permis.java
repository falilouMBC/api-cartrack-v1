package com.falilou.cartrack.entities;

import com.falilou.cartrack.enums.TypePermis;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TP_permis")
public class Permis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true,name = "Per_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false,name = "Per_type")
    private TypePermis typePermis;

    @Column(nullable = false,unique = true,name = "Per_code")
    private String numeroPermis;

    @Column(name = "Perm_date")
    private LocalDate datePermis;

}
