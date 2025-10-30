package com.example.insurance_api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PolicyResponseDTO {
    private Long id;
    private String numeroApolice;
    private String cpfSegurado;
    private LocalDate dataInicioVigencia;
    private LocalDate dataFimVigencia;
    private String placaVeiculo;
    private BigDecimal valorPremio;

    public String getNumeroApolice() {
        return numeroApolice;
    }

    public void setNumeroApolice(String numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfSegurado() {
        return cpfSegurado;
    }

    public void setCpfSegurado(String cpfSegurado) {
        this.cpfSegurado = cpfSegurado;
    }

    public LocalDate getDataInicioVigencia() {
        return dataInicioVigencia;
    }

    public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
        this.dataInicioVigencia = dataInicioVigencia;
    }

    public LocalDate getDataFimVigencia() {
        return dataFimVigencia;
    }

    public void setDataFimVigencia(LocalDate dataFimVigencia) {
        this.dataFimVigencia = dataFimVigencia;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public BigDecimal getValorPremio() {
        return valorPremio;
    }

    public void setValorPremio(BigDecimal valorPremio) {
        this.valorPremio = valorPremio;
    }
}
