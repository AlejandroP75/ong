package com.campuslands.ong.config;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.ong.dto.EnvioDTO;
import com.campuslands.ong.repositories.entities.EnvioEntity;

@Component
public class EnvioDTOConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public EnvioDTO convertToDTO(EnvioEntity envioEntity) {

        EnvioDTO envioDTO = modelMapper.map(envioEntity, EnvioDTO.class);
        if (envioEntity.getSolicitud() != null) {
            List<Long> solicitudIds = envioEntity.getSolicitud()
                .stream()
                .map(solicitud -> solicitud.getId())
                .collect(Collectors.toList());
            envioDTO.setSolicitudIds(solicitudIds);
        }
        if (envioEntity.getAyuda_material() != null) {
            List<Long> ayudaMaterialIds = envioEntity.getAyuda_material()
                .stream()
                .map(ayudaMaterial -> ayudaMaterial.getId())
                .collect(Collectors.toList());
            envioDTO.setAyudaMaterialIds(ayudaMaterialIds);
        }
        if (envioEntity.getSedes() != null) { 
            List<Long> sedesIds = envioEntity.getSedes()
                .stream()
                .map(sede -> sede.getId())
                .collect(Collectors.toList());
            envioDTO.setSedesIds(sedesIds);
        }

        return envioDTO;
    }

    public EnvioEntity convertToEntity(EnvioDTO envioDTO) {
        if (envioDTO == null) {
            return null;
        }

        EnvioEntity envioEntity = modelMapper.map(envioDTO, EnvioEntity.class);

        return envioEntity;
    }
}
