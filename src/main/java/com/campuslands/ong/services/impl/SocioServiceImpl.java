package com.campuslands.ong.services.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.ong.config.SocioDTOConverter;
import com.campuslands.ong.dto.SocioDTO;
import com.campuslands.ong.repositories.SocioRepository;
import com.campuslands.ong.repositories.entities.SocioEntity;
import com.campuslands.ong.services.SocioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SocioServiceImpl implements SocioService{

    private final SocioRepository socioRepository;
    private final SocioDTOConverter socioDTOConverter;

    @Override
    @Transactional(readOnly = true)
    public List<SocioDTO> findAll() {
        List<SocioEntity> socioEntities = (List<SocioEntity>) socioRepository.findAll();
        return socioEntities.stream()
                .sorted(Comparator.comparingLong(socio -> socio.getTipoCuota().getId()))
                .map(socioDTOConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SocioEntity> informe() {
        List<SocioEntity> socioEntities = (List<SocioEntity>) socioRepository.findAll();
        return socioEntities;
    }

    @Override
    @Transactional(readOnly = true)
    public SocioDTO findById(Long id) {
        SocioEntity socioEntity = socioRepository.findById(id)
                                                  .orElseThrow(() -> new RuntimeException("Socio not found with id: " + id));
        return socioDTOConverter.convertToDTO(socioEntity);
    }

    @Override
    public SocioDTO save(SocioDTO socioDTO) {
        SocioEntity socioEntity = socioDTOConverter.convertToEntity(socioDTO);
        SocioEntity savedSocioEntity = socioRepository.save(socioEntity);
        return socioDTOConverter.convertToDTO(savedSocioEntity);
    }

    @Override
    public SocioDTO update(Long id, SocioDTO socioDTO) {
        Optional<SocioEntity> existingSocioOptional = socioRepository.findById(id);
        
        if (existingSocioOptional.isPresent()) {
            SocioEntity existingSocioEntity = existingSocioOptional.get();
            existingSocioEntity.setFecha_pago(socioDTO.getFechaPago());
            existingSocioEntity.setNumero_cuenta(socioDTO.getNumeroCuenta());
            
            SocioEntity updatedSocioEntity = socioRepository.save(existingSocioEntity);
            return socioDTOConverter.convertToDTO(updatedSocioEntity);
        } else {
            throw new RuntimeException("Socio not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<SocioEntity> socioOptional = socioRepository.findById(id);
        socioOptional.ifPresent(socioRepository::delete);
    }
    
}
