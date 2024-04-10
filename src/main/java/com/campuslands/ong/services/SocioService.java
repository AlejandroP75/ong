package com.campuslands.ong.services;

import java.util.List;

import com.campuslands.ong.dto.SocioDTO;
import com.campuslands.ong.repositories.entities.SocioEntity;

public interface SocioService {

    List<SocioDTO> findAll();

    List<SocioEntity> informe();

    SocioDTO findById(Long id);

    SocioDTO save(SocioDTO socio);

    SocioDTO update(Long id, SocioDTO socio);

    void delete(Long id);
}
