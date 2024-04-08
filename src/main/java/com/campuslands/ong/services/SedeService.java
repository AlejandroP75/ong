package com.campuslands.ong.services;

import java.util.List;

import com.campuslands.ong.repositories.entities.SedeEntity;

public interface SedeService {

    List<SedeEntity> findAll();

    SedeEntity findById(Long id);

    SedeEntity save(SedeEntity sede);

    SedeEntity update(Long id, SedeEntity sede);

    void delete(Long id);
}
