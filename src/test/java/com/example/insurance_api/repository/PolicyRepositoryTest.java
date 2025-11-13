package com.example.insurance_api.repository;

import com.example.insurance_api.entity.Policy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PolicyRepositoryTest {

    @Autowired
    PolicyRepository repo;

    @BeforeEach
    void clean() {
        repo.deleteAll();
    }

    @Test
    void existsByNumeroApoliceShouldBeTrueAfterSave() {
        String unique = UUID.randomUUID().toString().substring(0, 8);
        Policy p = Policy.builder()
                .numeroApolice("AP-" + unique)
                .cpfSegurado("123.456.789-" + unique)
                .dataInicioVigencia(LocalDate.now())
                .dataFimVigencia(LocalDate.now().plusDays(1))
                .placaVeiculo("ABC-1234")
                .valorPremio(new BigDecimal("100"))
                .build();
        repo.save(p);
        assertThat(repo.existsByNumeroApolice("AP-" + unique)).isTrue();
    }
}


