package com.falilou.cartrack.services.serviceInterface;

import com.falilou.cartrack.entities.Utilisateur;
import com.falilou.cartrack.web.request.UtilisateurRequestDto;
import com.falilou.cartrack.web.response.UtilisateurResponseDto;

public interface IUtilisateur {
    UtilisateurResponseDto save(UtilisateurRequestDto utilisateur, boolean isRegister);
}
