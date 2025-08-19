package com.falilou.cartrack.services.serviceImp;


import com.falilou.cartrack.entities.Utilisateur;
import com.falilou.cartrack.mappers.UtilisateurMapper;
import com.falilou.cartrack.repositories.UtilisateurRepository;
import com.falilou.cartrack.services.serviceInterface.IUtilisateur;
import com.falilou.cartrack.web.request.UtilisateurRequestDto;
import com.falilou.cartrack.web.response.UtilisateurResponseDto;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisateurService implements IUtilisateur {
    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    @Override
    public UtilisateurResponseDto save(UtilisateurRequestDto utilisateurDTO, boolean isRegister) {
        try {
            if(utilisateurDTO.username() != null && !utilisateurDTO.username().isEmpty()){
                List<Utilisateur> existingUser = utilisateurRepository.findByUsername(utilisateurDTO.username());
                Utilisateur utilisateur = existingUser.get(0);
                if(!utilisateur.getUsername().equals(utilisateurDTO.username())){
                    utilisateur.setUsername(utilisateurDTO.username());
                    utilisateur.setNom(utilisateurDTO.nom());
                    utilisateur.setPrenom(utilisateurDTO.prenom());
                }
            }
            Utilisateur user = utilisateurMapper.toEntit(utilisateurDTO);
            utilisateurRepository.saveAndFlush(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
