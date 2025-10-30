package com.example.insurance_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
        name = "policies",
        uniqueConstraints = @UniqueConstraint(name = "uk_policy_numero", columnNames = "numero_apolice")
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_apolice", nullable = false, unique = true, length = 50)
    private String numeroApolice;
    @Column(name = "cpf_segurado", nullable = false, unique = true, length = 20)
    private String cpfSegurado;
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicioVigencia;
    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFimVigencia;
    @Column(name = "placa_veiculo", length = 20)
    private String placaVeiculo;
    @Column(name = "valor_premio", precision = 15, scale = 2)
    private BigDecimal valorPremio;
}
