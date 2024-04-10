package com.campuslands.ong.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.ong.config.EnvioDTOConverter;
import com.campuslands.ong.dto.EnvioDTO;
import com.campuslands.ong.repositories.EnvioRepository;
import com.campuslands.ong.repositories.entities.EnvioEntity;
import com.campuslands.ong.services.EnvioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnvioServiceImpl implements EnvioService{

    private final EnvioRepository envioRepository;
    private final EnvioDTOConverter envioDTOConverter;

    @Override
    @Transactional(readOnly = true)
    public List<EnvioDTO> findAll() {
        List<EnvioEntity> envioEntities = (List<EnvioEntity>) envioRepository.findAll();
        return envioEntities.stream()
                .map(envioDTOConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public EnvioDTO findById(Long id) {
        EnvioEntity envioEntity = envioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Envio not found with id: " + id));
        return envioDTOConverter.convertToDTO(envioEntity);
    }

    @Override
    public EnvioDTO save(EnvioDTO envioDTO) {
        EnvioEntity envioEntity = envioDTOConverter.convertToEntity(envioDTO);
        EnvioEntity savedEnvioEntity = envioRepository.save(envioEntity);
        return envioDTOConverter.convertToDTO(savedEnvioEntity);
    }

    @Override
    public EnvioDTO update(Long id, EnvioDTO envioDTO) {
        Optional<EnvioEntity> existingEnvioOptional = envioRepository.findById(id);

        if (existingEnvioOptional.isPresent()) {
            EnvioEntity existingEnvioEntity = existingEnvioOptional.get();
            existingEnvioEntity.setFecha_inicio(envioDTO.getFechaInicio());
            EnvioEntity updatedEnvioEntity = envioRepository.save(existingEnvioEntity);
            return envioDTOConverter.convertToDTO(updatedEnvioEntity);
        } else {
            throw new RuntimeException("Envio not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<EnvioEntity> envioOptional = envioRepository.findById(id);
        envioOptional.ifPresent(envioRepository::delete);
    }
}
