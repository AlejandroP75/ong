package com.campuslands.ong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.ong.dto.SocioDTO;
import com.campuslands.ong.repositories.entities.SocioEntity;

@Component
public class SocioDTOConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public SocioDTO convertToDTO(SocioEntity socioEntity) {
        SocioDTO socioDTO = modelMapper.map(socioEntity, SocioDTO.class);
        socioDTO.setUsuarioId(socioEntity.getUsuario().getId()); 
        socioDTO.setTipoCuotaId(socioEntity.getTipoCuota().getId());
        socioDTO.setSedeId(socioEntity.getSede().getId());
        return socioDTO;
    }

    public SocioEntity convertToEntity(SocioDTO socioDTO) {
        return modelMapper.map(socioDTO, SocioEntity.class);
    }
}
