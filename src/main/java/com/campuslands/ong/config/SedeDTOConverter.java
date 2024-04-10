package com.campuslands.ong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.ong.dto.SedeDTO;
import com.campuslands.ong.repositories.entities.SedeEntity;

@Component
public class SedeDTOConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public SedeDTO convertToDTO(SedeEntity sedeEntity) {
        if (sedeEntity == null) {
            return null;
        }

        SedeDTO sedeDTO = modelMapper.map(sedeEntity, SedeDTO.class);

        if (sedeEntity.getCiudad() != null) {
            sedeDTO.setCiudadId(sedeEntity.getCiudad().getId());
        }

        if (sedeEntity.getDirector() != null) {
            sedeDTO.setDirectorId(sedeEntity.getDirector().getId());
        }

        return sedeDTO;
    }

    public SedeEntity convertToEntity(SedeDTO sedeDTO) {
        if (sedeDTO == null) {
            return null;
        }

        return modelMapper.map(sedeDTO, SedeEntity.class);
    }
}
