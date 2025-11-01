package com.example.insurance_api.controller;

import com.example.insurance_api.dto.PolicyCreateDTO;
import com.example.insurance_api.dto.PolicyResponseDTO;
import com.example.insurance_api.dto.PolicyUpdateDto;
import com.example.insurance_api.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PolicyResponseDTO> create(@RequestBody @Valid PolicyCreateDTO dto) {
        PolicyResponseDTO created = service.create(dto);
        // presumimos que created.getId() existe — se não existir, adapte para usar numeroApolice
        return ResponseEntity.created(URI.create("/api/policies/" + created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<List<PolicyResponseDTO>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/by-number/{numero}")
    public ResponseEntity<PolicyResponseDTO> getByNumero(@PathVariable("numero") String numero) {
        return ResponseEntity.ok(service.findByNumero(numero));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> update(@PathVariable Long id,
                                                    @RequestBody @Valid PolicyUpdateDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
