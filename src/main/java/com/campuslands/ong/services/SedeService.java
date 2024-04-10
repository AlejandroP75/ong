package com.campuslands.ong.services;

import java.util.List;

import com.campuslands.ong.dto.SedeDTO;

public interface SedeService {

    List<SedeDTO> findAll();

    SedeDTO findById(Long id);

    SedeDTO save(SedeDTO sede);

    SedeDTO update(Long id, SedeDTO sede);

    void delete(Long id);
}
