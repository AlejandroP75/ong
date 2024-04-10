package com.campuslands.ong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.ong.dto.SocioDTO;
import com.campuslands.ong.repositories.entities.SedeEntity;
import com.campuslands.ong.repositories.entities.SocioEntity;
import com.campuslands.ong.repositories.entities.TipoCuotaEntity;
import com.campuslands.ong.repositories.entities.UsuarioEntity;

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
        if (socioDTO == null) {
            return null;
        }

        SocioEntity socioEntity = modelMapper.map(socioDTO, SocioEntity.class);

        if (socioDTO.getUsuarioId() != null) {
            UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setId(socioDTO.getUsuarioId());
            socioEntity.setUsuario(usuarioEntity);
        } else {
            socioEntity.setUsuario(null);
        }

        if (socioDTO.getTipoCuotaId() != null) {
            TipoCuotaEntity tipoCuotaEntity = new TipoCuotaEntity();
            tipoCuotaEntity.setId(socioDTO.getTipoCuotaId());
            socioEntity.setTipoCuota(tipoCuotaEntity);
        } else {
            socioEntity.setTipoCuota(null);
        }

        if (socioDTO.getSedeId() != null) {
            SedeEntity sedeEntity = new SedeEntity();
            sedeEntity.setId(socioDTO.getSedeId());
            socioEntity.setSede(sedeEntity);
        } else {
            socioEntity.setSede(null);
        }

        return socioEntity;
    }
}
