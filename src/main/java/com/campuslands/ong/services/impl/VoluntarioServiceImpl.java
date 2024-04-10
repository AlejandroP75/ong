package com.campuslands.ong.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.ong.config.VoluntarioDTOConverter;
import com.campuslands.ong.dto.VoluntarioDTO;
import com.campuslands.ong.repositories.VoluntarioRepository;
import com.campuslands.ong.repositories.entities.VoluntarioEntity;
import com.campuslands.ong.services.VoluntarioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoluntarioServiceImpl implements VoluntarioService {
    
    @Autowired
    private final VoluntarioRepository voluntarioRepository;
    private final VoluntarioDTOConverter voluntarioDTOConverter;

    @Override
    @Transactional(readOnly = true)
    public List<VoluntarioDTO> findAll() {
        List<VoluntarioEntity> voluntarioEntities = (List<VoluntarioEntity>) voluntarioRepository.findAll();
        List<VoluntarioDTO> voluntarioDTOs = voluntarioEntities.stream()
                .map(voluntarioEntity -> voluntarioDTOConverter.convertToDTO(voluntarioEntity))
                .collect(Collectors.toList());
    
        return voluntarioDTOs;
    }

    @Override
    @Transactional(readOnly = true)
    public VoluntarioDTO findById(Long id) {
        VoluntarioEntity voluntarioEntity = voluntarioRepository.findById(id)
                                                                .orElseThrow(() -> new RuntimeException("Voluntario not found with id: " + id));
        return voluntarioDTOConverter.convertToDTO(voluntarioEntity);
    }

    @Override
    public VoluntarioDTO save(VoluntarioDTO voluntarioDTO) {
        VoluntarioEntity voluntarioEntity = voluntarioDTOConverter.convertToEntity(voluntarioDTO);
        VoluntarioEntity savedVoluntarioEntity = voluntarioRepository.save(voluntarioEntity);
        return voluntarioDTOConverter.convertToDTO(savedVoluntarioEntity);
    }

    @Override
    public void delete(Long id) {
        Optional<VoluntarioEntity> voluntarioOptional = voluntarioRepository.findById(id);
        voluntarioOptional.ifPresent(voluntarioRepository::delete);
    }
    
}
