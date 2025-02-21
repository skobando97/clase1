package com.aulamatriz.hospital.hospital.repository;

import com.aulamatriz.hospital.hospital.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity,Integer> {
}
