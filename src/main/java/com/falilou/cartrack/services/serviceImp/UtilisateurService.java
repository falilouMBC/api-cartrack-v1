package com.falilou.cartrack.services.serviceImp;


import com.falilou.cartrack.entities.Utilisateur;
import com.falilou.cartrack.mappers.UtilisateurMapper;
import com.falilou.cartrack.repositories.UtilisateurRepository;
import com.falilou.cartrack.services.serviceInterface.IUtilisateur;
import com.falilou.cartrack.web.dtos.request.UtilisateurRequestDto;
import com.falilou.cartrack.web.dtos.response.Response;
import com.falilou.cartrack.web.dtos.response.UtilisateurResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtilisateurService implements IUtilisateur {
    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    /**
     * Sauvegarde un nouvel utilisateur dans la base de données.
     *
     * @param utilisateurDTO les informations de l'utilisateur à créer
     * @return l'utilisateur créé sous forme de {@link UtilisateurResponseDto}
     * @throws IllegalArgumentException si les données de l'utilisateur sont invalides
     * @throws RuntimeException si un utilisateur existe déjà ou en cas d'erreur lors de la sauvegarde
     */
    @Override
    public UtilisateurResponseDto save(UtilisateurRequestDto utilisateurDTO) {
        try {
            // Validation des données d'entrée
            validateUserData(utilisateurDTO);

            // Vérifier si l'utilisateur existe déjà avec Optional
            Optional<Utilisateur> existingUser = utilisateurRepository.findFirstByUsername(utilisateurDTO.username());

            if (existingUser.isPresent()) {
                throw new RuntimeException("Un utilisateur avec ce mail d'utilisateur existe déjà: " + utilisateurDTO.username());
            }

            // Créer le nouvel utilisateur
            Utilisateur newUser = utilisateurMapper.toEntity(utilisateurDTO);
            Utilisateur savedUser = utilisateurRepository.saveAndFlush(newUser);

            return utilisateurMapper.toResponse(savedUser);

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la création de l'utilisateur: " + e.getMessage(), e);
        }
    }

    /**
     * @return la liste de tous les utilisateurs
     * @throws RuntimeException s'il y a une erreur lors de la récuperation des utilisateurs
     */
    @Override
    public List<UtilisateurResponseDto> listeUtilisateurs() {
        try {
            List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
            return utilisateurs.stream().map(utilisateurMapper::toResponse).toList();
        }catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récuperation des utilisateurs de l'utilisateur: " + e.getMessage(), e);
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public UtilisateurResponseDto findById(Long id) {
        try {
            Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
            if (utilisateurOptional.isEmpty()) {
                return null;
            }
            Utilisateur utilisateur = utilisateurOptional.get();
            return utilisateurMapper.toResponse(utilisateur);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param utilisateur
     * @param id
     * @return
     */
    @Override
    public UtilisateurResponseDto update(Long id, UtilisateurRequestDto utilisateur) {
        try {
            Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
            if (utilisateurOptional.isEmpty()) {
                return null;
            }
            Utilisateur user = utilisateurOptional.get();
            user.setNom(utilisateur.nom());
            user.setPrenom(utilisateur.prenom());
            utilisateurRepository.saveAndFlush(user);
            return utilisateurMapper.toResponse(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Response<Object> delete(Long id) {
        try{
            Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
            utilisateurOptional.ifPresent(utilisateurRepository::delete);
            return Response.ok();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Valide les données d'un utilisateur avant sa création.
     *
     * @param utilisateurDTO les informations de l'utilisateur à valider
     * @throws IllegalArgumentException si l'une des données obligatoires est absente ou invalide :
     */
    private void validateUserData(UtilisateurRequestDto utilisateurDTO) {
        if (utilisateurDTO.username() == null || utilisateurDTO.username().trim().isEmpty()) {
            throw new IllegalArgumentException("Le login ne peut pas être vide");
        }
        if (utilisateurDTO.nom() == null || utilisateurDTO.nom().trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
        if (utilisateurDTO.prenom() == null || utilisateurDTO.prenom().trim().isEmpty()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide");
        }
        if (utilisateurDTO.role() == null) {
            throw new IllegalArgumentException("Le rôle ne peut pas être vide");
        }
    }
}