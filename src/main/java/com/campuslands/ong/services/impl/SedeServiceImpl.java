package com.campuslands.ong.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.ong.repositories.SedeRepository;
import com.campuslands.ong.repositories.entities.SedeEntity;
import com.campuslands.ong.services.SedeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SedeServiceImpl implements SedeService{

    private SedeRepository sedeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SedeEntity> findAll() {
        return (List<SedeEntity>) sedeRepository.findAll();
    }

    @Override
    public SedeEntity findById(Long id) {
        return sedeRepository.findById(id).orElse(null);
    }

    @Override
    public SedeEntity save(SedeEntity sede) {
        return sedeRepository.save(sede);
    }

    @Override
    public SedeEntity update(Long id, SedeEntity sede) {
        Optional<SedeEntity> sedeCurrentOptional=sedeRepository.findById(id);

        if(sedeCurrentOptional.isPresent()){
            SedeEntity sedeCurrent=sedeCurrentOptional.get();
            sedeCurrent.setDireccion(sede.getDireccion());
            sedeRepository.save(sedeCurrent);
            return sedeCurrent;         
        }
 
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<SedeEntity> sedeOptinal=sedeRepository.findById(id);
        if(sedeOptinal.isPresent()){
            sedeRepository.delete(sedeOptinal.get());
        }   
    }
    
}
