package com.campuslands.ong.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.ong.repositories.SocioRepository;
import com.campuslands.ong.repositories.entities.SocioEntity;
import com.campuslands.ong.services.SocioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SocioServiceImpl implements SocioService{

    private SocioRepository socioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SocioEntity> findAll() {
        return (List<SocioEntity>) socioRepository.findAll();
    }

    @Override
    public SocioEntity findById(Long id) {
        return socioRepository.findById(id).orElse(null);
    }

    @Override
    public SocioEntity save(SocioEntity socio) {
        return socioRepository.save(socio);
    }

    @Override
    public SocioEntity update(Long id, SocioEntity socio) {
        Optional<SocioEntity> socioCurrentOptional=socioRepository.findById(id);

        if(socioCurrentOptional.isPresent()){
            SocioEntity socioCurrent=socioCurrentOptional.get();
            socioCurrent.setFecha_pago(socio.getFecha_pago());
            socioCurrent.setNumero_cuenta(socio.getNumero_cuenta());
            socioRepository.save(socioCurrent);
            return socioCurrent;         
        }
 
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<SocioEntity> socioOptinal=socioRepository.findById(id);
        if(socioOptinal.isPresent()){
            socioRepository.delete(socioOptinal.get());
        }   
    }
    
}
