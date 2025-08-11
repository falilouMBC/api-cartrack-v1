package com.falilou.cartrack.repositories;

import com.falilou.cartrack.entities.Permis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisRepository extends JpaRepository<Permis, Long> {
}