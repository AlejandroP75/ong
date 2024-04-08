package com.campuslands.ong.services;

import java.util.List;

import com.campuslands.ong.repositories.entities.VoluntarioEntity;

public interface VoluntarioService {
    
    List<VoluntarioEntity> findAll();

    VoluntarioEntity findById(Long id);

    VoluntarioEntity save(VoluntarioEntity voluntario);

    VoluntarioEntity update(Long id, VoluntarioEntity voluntario);

    void delete(Long id);
}
