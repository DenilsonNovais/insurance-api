package com.example.insurance_api.dto;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PolicyCreateDTO {

    @NotBlank(message = "numeroApolice é obrigatório")
    @Size(max = 50)
    private String numeroApolice;

    @NotBlank(message = "cpfSegurado é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 000.000.000-00")
    private String cpfSegurado;

    @NotNull(message = "dataInicioVigencia é obrigatória")
    private LocalDate dataInicioVigencia;

    @NotNull(message = "dataFimVigencia é obrigatória")
    private LocalDate dataFimVigencia;

    @NotBlank(message = "placaVeiculo é obrigatória")
    @Size(max = 20)
    private String placaVeiculo;

    @NotNull(message = "valorPremio é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "valorPremio deve ser maior que zero")
    private BigDecimal valorPremio;

    public String getNumeroApolice() {
        return numeroApolice;
    }

    public void setNumeroApolice(String numeroApolice) {
        this.numeroApolice = numeroApolice;
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
