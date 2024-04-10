package com.campuslands.ong.services;

import java.util.List;

import com.campuslands.ong.dto.VoluntarioDTO;
import com.campuslands.ong.repositories.entities.VoluntarioEntity;

public interface VoluntarioService {
    
    List<VoluntarioDTO> findAll();

    List<VoluntarioEntity> informe();

    VoluntarioDTO findById(Long id);

    VoluntarioDTO save(VoluntarioDTO voluntario);

    void delete(Long id);
}
