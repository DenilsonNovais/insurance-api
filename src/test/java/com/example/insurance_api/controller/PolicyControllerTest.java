package com.example.insurance_api.controller;

import com.example.insurance_api.dto.PolicyCreateDTO;
import com.example.insurance_api.dto.PolicyResponseDTO;
import com.example.insurance_api.service.PolicyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PolicyControllerTest.class)
class PolicyControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;
    @Autowired PolicyService service;

    @Test
    void create_shouldReturn201() throws Exception {
        PolicyCreateDTO in = new PolicyCreateDTO();
        in.setNumeroApolice("AP-001");
        in.setCpfSegurado("123.456.789-09");
        in.setDataInicioVigencia(LocalDate.of(2025, 10, 1));
        in.setDataFimVigencia(LocalDate.of(2026,10,1));
        in.setPlacaVeiculo("ABC-1234");
        in.setValorPremio(new BigDecimal("1000.00"));

        PolicyResponseDTO out = new PolicyResponseDTO();
        out.setId(1L); out.setNumeroApolice("AP-001");
        Mockito.when(service.create(Mockito.any())).thenReturn(out);

        mockMvc.perform(post("/api/policies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(in)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/api/policies/1"));
    }
}
