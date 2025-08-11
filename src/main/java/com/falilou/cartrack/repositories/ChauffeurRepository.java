package com.falilou.cartrack.repositories;

import com.falilou.cartrack.entities.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
}