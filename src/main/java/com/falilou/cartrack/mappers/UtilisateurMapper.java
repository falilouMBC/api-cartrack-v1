package com.falilou.cartrack.mappers;

import com.falilou.cartrack.entities.Utilisateur;
import com.falilou.cartrack.web.request.UtilisateurRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UtilisateurMapper {


    Utilisateur toEntit(UtilisateurRequestDto utilisateurRequestDto);

    UtilisateurRequestDto toDto(Utilisateur utilisateur);
}
