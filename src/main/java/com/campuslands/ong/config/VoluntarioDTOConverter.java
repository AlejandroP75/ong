package com.campuslands.ong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.ong.dto.VoluntarioDTO;
import com.campuslands.ong.repositories.entities.VoluntarioEntity;

@Component
public class VoluntarioDTOConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public VoluntarioDTO convertToDTO(VoluntarioEntity voluntarioEntity) {
        if (voluntarioEntity == null) {
            return null;
        }

        VoluntarioDTO voluntarioDTO = modelMapper.map(voluntarioEntity, VoluntarioDTO.class);

        if (voluntarioEntity.getSede() != null) {
            voluntarioDTO.setSedeId(voluntarioEntity.getSede().getId());
        }

        if (voluntarioEntity.getUsuario() != null) {
            voluntarioDTO.setUsuarioId(voluntarioEntity.getUsuario().getId());
        }

        return voluntarioDTO;
    }

    public VoluntarioEntity convertToEntity(VoluntarioDTO voluntarioDTO) {
        if (voluntarioDTO == null) {
            return null;
        }

        return modelMapper.map(voluntarioDTO, VoluntarioEntity.class);
    }
}
