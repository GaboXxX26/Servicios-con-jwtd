package com.test.ecuservicies.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.ecuservicies.system.model.EcuSystem;

public interface SystemRepository extends JpaRepository<EcuSystem, Long> {
    Optional<EcuSystem> findByName(String name);


}
