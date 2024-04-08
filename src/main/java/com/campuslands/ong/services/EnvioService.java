package com.campuslands.ong.services;

import java.util.List;

import com.campuslands.ong.repositories.entities.EnvioEntity;

public interface EnvioService {
    
    List<EnvioEntity> findAll();

    EnvioEntity findById(Long id);

    EnvioEntity save(EnvioEntity envio);

    EnvioEntity update(Long id, EnvioEntity envio);

    void delete(Long id);
}
