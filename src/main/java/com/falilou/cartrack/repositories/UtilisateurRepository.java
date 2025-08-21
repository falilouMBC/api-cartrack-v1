package com.falilou.cartrack.repositories;

import com.falilou.cartrack.entities.Utilisateur;
import com.falilou.cartrack.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    List<Utilisateur> findByUsername(String username);
    Optional<Utilisateur> findFirstByUsername(String username);
    List<Utilisateur> findByRole(Role role);
    boolean existsByUsername(String username);

}