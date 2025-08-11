package com.falilou.cartrack.repositories;

import com.falilou.cartrack.entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
}