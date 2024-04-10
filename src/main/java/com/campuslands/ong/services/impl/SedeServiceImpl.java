package com.campuslands.ong.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.ong.config.SedeDTOConverter;
import com.campuslands.ong.dto.SedeDTO;
import com.campuslands.ong.repositories.SedeRepository;
import com.campuslands.ong.repositories.entities.SedeEntity;
import com.campuslands.ong.services.SedeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SedeServiceImpl implements SedeService{

    private final SedeRepository sedeRepository;
    private final SedeDTOConverter sedeDTOConverter;

    @Override
    @Transactional(readOnly = true)
    public List<SedeDTO> findAll() {
        List<SedeEntity> sedes = (List<SedeEntity>) sedeRepository.findAll();
        return sedes.stream()
                    .map(sedeDTOConverter::convertToDTO)
                    .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public SedeDTO findById(Long id) {
        SedeEntity sedeEntity = sedeRepository.findById(id)
                                              .orElseThrow(() -> new RuntimeException("Sede not found with id: " + id));
        return sedeDTOConverter.convertToDTO(sedeEntity);
    }

    @Override
    public SedeDTO save(SedeDTO sedeDTO) {
        SedeEntity sedeEntity = sedeDTOConverter.convertToEntity(sedeDTO);
        SedeEntity savedSedeEntity = sedeRepository.save(sedeEntity);
        return sedeDTOConverter.convertToDTO(savedSedeEntity);
    }

    @Override
    public SedeDTO update(Long id, SedeDTO sedeDTO) {
        Optional<SedeEntity> existingSedeOptional = sedeRepository.findById(id);

        if (existingSedeOptional.isPresent()) {
            SedeEntity existingSedeEntity = existingSedeOptional.get();
            existingSedeEntity.setDireccion(sedeDTO.getDireccion());

            SedeEntity updatedSedeEntity = sedeRepository.save(existingSedeEntity);
            return sedeDTOConverter.convertToDTO(updatedSedeEntity);
        } else {
            throw new RuntimeException("Sede not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<SedeEntity> sedeOptional = sedeRepository.findById(id);
        sedeOptional.ifPresent(sedeRepository::delete);
    }
    
}
