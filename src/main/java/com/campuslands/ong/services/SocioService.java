package com.campuslands.ong.services;

import java.util.List;

import com.campuslands.ong.dto.SocioDTO;

public interface SocioService {

    List<SocioDTO> findAll();

    SocioDTO findById(Long id);

    SocioDTO save(SocioDTO socio);

    SocioDTO update(Long id, SocioDTO socio);

    void delete(Long id);
}
