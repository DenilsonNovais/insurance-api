package com.example.insurance_api.service;

import com.example.insurance_api.dto.PolicyCreateDTO;
import com.example.insurance_api.dto.PolicyResponseDTO;
import com.example.insurance_api.dto.PolicyUpdateDto;
import com.example.insurance_api.entity.Policy;
import com.example.insurance_api.mapper.PolicyMapper;
import com.example.insurance_api.repository.PolicyRepository;
import com.example.insurance_api.exception.BadRequestException;
import com.example.insurance_api.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    private final PolicyRepository repository;

    public PolicyService(PolicyRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public PolicyResponseDTO create(PolicyCreateDTO dto) {
        // unicidade do número da apólice
        if (repository.existsByNumeroApolice(dto.getNumeroApolice())) {
            throw new BadRequestException("Número de apólice já existe");
        }

        // validade das datas
        if (dto.getDataFimVigencia().isBefore(dto.getDataInicioVigencia())
                || dto.getDataFimVigencia().isEqual(dto.getDataInicioVigencia())) {
            throw new BadRequestException("Data de fim deve ser posterior à data de início");
        }

        Policy entity = PolicyMapper.toEntity(dto);
        Policy saved = repository.save(entity);
        return PolicyMapper.toDto(saved);
    }

    @Transactional(readOnly = true)
    public PolicyResponseDTO findByNumero(String numeroApolice) {
        Policy p = repository.findByNumeroApolice(numeroApolice)
                .orElseThrow(() -> new ResourceNotFoundException("Apólice não encontrada"));
        return PolicyMapper.toDto(p);
    }

    @Transactional(readOnly = true)
    public List<PolicyResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(PolicyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Apólice não encontrada");
        }
        repository.deleteById(id);
    }

    @Transactional
    public PolicyResponseDTO update(Long id, PolicyUpdateDto dto) {
        Policy p = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Apólice não encontrada"));

        // se mudou numeroApolice, verifica unicidade
        if (dto.getNumeroApolice() != null && !dto.getNumeroApolice().equals(p.getNumeroApolice())) {
            if (repository.existsByNumeroApolice(dto.getNumeroApolice())) {
                throw new BadRequestException("Número de apólice novo já existe");
            }
        }

        // atualiza campos
        PolicyMapper.updateEntityFromDto(p, dto);

        // valida vigência após atualização parcial
        if (p.getDataFimVigencia().isBefore(p.getDataInicioVigencia())
                || p.getDataFimVigencia().isEqual(p.getDataInicioVigencia())) {
            throw new BadRequestException("Data de fim deve ser posterior à data de início");
        }

        Policy saved = repository.save(p);
        return PolicyMapper.toDto(saved);
    }
}
