package com.campuslands.ong.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.ong.repositories.VoluntarioRepository;
import com.campuslands.ong.repositories.entities.VoluntarioEntity;
import com.campuslands.ong.services.VoluntarioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoluntarioServiceImpl implements VoluntarioService {
    
    private VoluntarioRepository voluntarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<VoluntarioEntity> findAll() {
        return (List<VoluntarioEntity>) voluntarioRepository.findAll();
    }

    @Override
    public VoluntarioEntity findById(Long id) {
        return voluntarioRepository.findById(id).orElse(null);
    }

    @Override
    public VoluntarioEntity save(VoluntarioEntity voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    @Override
    public void delete(Long id) {
        Optional<VoluntarioEntity> voluntarioOptinal=voluntarioRepository.findById(id);
        if(voluntarioOptinal.isPresent()){
            voluntarioRepository.delete(voluntarioOptinal.get());
        }   
    }
    
}
