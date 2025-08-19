package com.falilou.cartrack.mappers;

import com.falilou.cartrack.entities.Utilisateur;
import com.falilou.cartrack.web.dtos.request.UtilisateurRequestDto;
import com.falilou.cartrack.web.dtos.request.response.UtilisateurResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UtilisateurMapper {


    Utilisateur toEntity(UtilisateurRequestDto utilisateurRequestDto);

    UtilisateurResponseDto toResponse(Utilisateur utilisateur);
}
