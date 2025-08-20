package com.falilou.cartrack.web.controllers;

import com.falilou.cartrack.services.serviceInterface.IUtilisateur;
import com.falilou.cartrack.web.dtos.request.UtilisateurRequestDto;
import com.falilou.cartrack.web.dtos.request.response.UtilisateurResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UtilisateurController {
    private final IUtilisateur iUtilisateur;

    @PostMapping("/utilisateur")
    public UtilisateurResponseDto save(@Validated @RequestBody UtilisateurRequestDto utilisateur) {
        return iUtilisateur.save(utilisateur);
    }
}