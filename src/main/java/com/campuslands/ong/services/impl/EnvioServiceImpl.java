package com.campuslands.ong.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.ong.repositories.EnvioRepository;
import com.campuslands.ong.repositories.entities.EnvioEntity;
import com.campuslands.ong.services.EnvioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnvioServiceImpl implements EnvioService{

    private EnvioRepository envioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EnvioEntity> findAll() {
        return (List<EnvioEntity>) envioRepository.findAll();
    }

    @Override
    public EnvioEntity findById(Long id) {
        return envioRepository.findById(id).orElse(null);
    }

    @Override
    public EnvioEntity save(EnvioEntity envio) {
        return envioRepository.save(envio);
    }

    @Override
    public EnvioEntity update(Long id, EnvioEntity envio) {
        Optional<EnvioEntity> envioCurrentOptional=envioRepository.findById(id);

        if(envioCurrentOptional.isPresent()){
            EnvioEntity envioCurrent=envioCurrentOptional.get();
            envioCurrent.setFecha_inicio(envio.getFecha_inicio());
            envioRepository.save(envioCurrent);
            return envioCurrent;         
        }
 
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<EnvioEntity> socioOptinal=envioRepository.findById(id);
        if(socioOptinal.isPresent()){
            envioRepository.delete(socioOptinal.get());
        }   
    }
}
