package com.aulamatriz.hospital.hospital.service;

import com.aulamatriz.hospital.hospital.entities.PacienteEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PacienteService {
    ResponseEntity<?> crearPaciente (PacienteEntity paciente);
    ResponseEntity<List<PacienteEntity>> listarPacientes ();
    ResponseEntity<PacienteEntity> encontrarPaciente(int id);
    ResponseEntity<?> actualizarPaciente(int id_paciente,PacienteEntity paciente);

}
