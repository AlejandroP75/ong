package com.campuslands.ong.services;

import java.util.List;

import com.campuslands.ong.repositories.entities.SocioEntity;

public interface SocioService {

    List<SocioEntity> findAll();

    SocioEntity findById(Long id);

    SocioEntity save(SocioEntity socio);

    SocioEntity update(Long id, SocioEntity socio);

    void delete(Long id);
}
