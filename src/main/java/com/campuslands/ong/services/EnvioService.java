package com.campuslands.ong.services;

import java.util.List;

import com.campuslands.ong.dto.EnvioDTO;
import com.campuslands.ong.repositories.entities.EnvioEntity;

public interface EnvioService {
    
    List<EnvioDTO> findAll();

    List<EnvioEntity> informe();

    EnvioDTO findById(Long id);

    EnvioDTO save(EnvioDTO envio);

    EnvioDTO update(Long id, EnvioDTO envio);

    void delete(Long id);
}
