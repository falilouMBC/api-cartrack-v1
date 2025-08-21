package com.falilou.cartrack.web.controllers;

import com.falilou.cartrack.services.serviceInterface.IUtilisateur;
import com.falilou.cartrack.web.dtos.request.UtilisateurRequestDto;
import com.falilou.cartrack.web.dtos.response.UtilisateurResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UtilisateurController {
    private final IUtilisateur iUtilisateur;

    @PostMapping("/utilisateur")
    public UtilisateurResponseDto save(@Validated @RequestBody UtilisateurRequestDto utilisateur) {
        return iUtilisateur.save(utilisateur);
    }

    @GetMapping("/utilisateur")
    public List<UtilisateurResponseDto> listeUtilisateurs() {
        return iUtilisateur.listeUtilisateurs();
    }

    @PatchMapping("/utilisateur/{id}")
    public UtilisateurResponseDto update(@Validated @RequestBody UtilisateurRequestDto utilisateur,@PathVariable Long id) {
        return iUtilisateur.update(id, utilisateur);
    }

    @DeleteMapping("/utilisateur/{id}")
    public void delete(@PathVariable Long id) {
        iUtilisateur.delete(id);
    }
}