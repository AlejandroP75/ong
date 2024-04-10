package com.campuslands.ong.services;

import java.util.List;

import com.campuslands.ong.dto.VoluntarioDTO;

public interface VoluntarioService {
    
    List<VoluntarioDTO> findAll();

    VoluntarioDTO findById(Long id);

    VoluntarioDTO save(VoluntarioDTO voluntario);

    void delete(Long id);
}
