package com.example.insurance_api.mapper;

import com.example.insurance_api.dto.PolicyCreateDTO;
import com.example.insurance_api.dto.PolicyResponseDTO;
import com.example.insurance_api.dto.PolicyUpdateDto;
import com.example.insurance_api.entity.Policy;

public final class PolicyMapper {

    private PolicyMapper() {}

    public static Policy toEntity(PolicyCreateDTO dto) {
        if (dto == null) return null;
        return Policy.builder()
                .numeroApolice(dto.getNumeroApolice())
                .cpfSegurado(dto.getCpfSeguro())
                .dataInicioVigencia(dto.getDataInicioVigencia())
                .dataFimVigencia(dto.getDataFimVigencia())
                .placaVeiculo(dto.getPlacaVeiculo())
                .valorPremio(dto.getValorPremio())
                .build();
    }

    public static PolicyResponseDTO toDto(Policy p) {
        if (p == null) return null;
        PolicyResponseDTO dto = new PolicyResponseDTO();
        dto.setId(p.getId());
        dto.setNumeroApolice(p.getNumeroApolice());
        dto.setCpfSegurado(p.getCpfSegurado());
        dto.setDataInicioVigencia(p.getDataInicioVigencia());
        dto.setDataFimVigencia(p.getDataFimVigencia());
        dto.setPlacaVeiculo(p.getPlacaVeiculo());
        dto.setValorPremio(p.getValorPremio());
        return dto;
    }

    public static void updateEntityFromDto(Policy p, PolicyUpdateDto dto) {
        if (p == null || dto == null) return;
        if (dto.getNumeroApolice() != null) p.setNumeroApolice(dto.getNumeroApolice());
        if (dto.getCpfSegurado() != null) p.setCpfSegurado(dto.getCpfSegurado());
        if (dto.getDataInicioVigencia() != null) p.setDataInicioVigencia(dto.getDataInicioVigencia());
        if (dto.getDataFimVigencia() != null) p.setDataFimVigencia(dto.getDataFimVigencia());
        if (dto.getPlacaVeiculo() != null) p.setPlacaVeiculo(dto.getPlacaVeiculo());
        if (dto.getValorPremio() != null) p.setValorPremio(dto.getValorPremio());
    }
}
