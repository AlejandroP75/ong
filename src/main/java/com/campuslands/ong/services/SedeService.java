package com.campuslands.ong.services;

import java.util.List;

import com.campuslands.ong.dto.SedeDTO;
import com.campuslands.ong.repositories.entities.SedeEntity;

public interface SedeService {

    List<SedeDTO> findAll();

    List<SedeEntity> informe();

    SedeDTO findById(Long id);

    SedeDTO save(SedeDTO sede);

    SedeDTO update(Long id, SedeDTO sede);

    void delete(Long id);
}
