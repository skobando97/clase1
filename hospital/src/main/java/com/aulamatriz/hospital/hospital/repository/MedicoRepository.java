package com.aulamatriz.hospital.hospital.repository;

import com.aulamatriz.hospital.hospital.entities.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoEntity,Integer> {
}
