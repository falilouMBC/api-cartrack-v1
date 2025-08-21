package com.falilou.cartrack.services.serviceInterface;

import com.falilou.cartrack.web.dtos.request.UtilisateurRequestDto;
import com.falilou.cartrack.web.dtos.response.Response;
import com.falilou.cartrack.web.dtos.response.UtilisateurResponseDto;

import java.util.List;

public interface IUtilisateur {
    UtilisateurResponseDto save(UtilisateurRequestDto utilisateur);
    List<UtilisateurResponseDto> listeUtilisateurs();
    UtilisateurResponseDto findById(Long id);
    UtilisateurResponseDto update(Long id,UtilisateurRequestDto utilisateur);
    Response<Object> delete(Long id);
}