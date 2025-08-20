package com.falilou.cartrack.services.serviceInterface;

import com.falilou.cartrack.web.dtos.request.UtilisateurRequestDto;
import com.falilou.cartrack.web.dtos.request.response.UtilisateurResponseDto;

public interface IUtilisateur {
    UtilisateurResponseDto save(UtilisateurRequestDto utilisateur);
}
