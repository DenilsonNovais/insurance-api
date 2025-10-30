package com.example.insurance_api.repository;

import com.example.insurance_api.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    Optional<Policy> findByNumeroApolice(String numeroApolice);
    boolean existsByNumeroApolice(String numeroApolice);
}
