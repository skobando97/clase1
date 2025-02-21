package com.aulamatriz.hospital.hospital.service.impl;

import com.aulamatriz.hospital.hospital.entities.PacienteEntity;
import com.aulamatriz.hospital.hospital.repository.PacienteRepository;
import com.aulamatriz.hospital.hospital.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PacienteServiceImpl implements PacienteService {

    private  final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public ResponseEntity<?> crearPaciente(PacienteEntity paciente) {
        PacienteEntity nuevoPaciente=this.pacienteRepository.save(paciente);
        return ResponseEntity
                .ok(nuevoPaciente);
    }

    @Override
    public ResponseEntity<List<PacienteEntity>> listarPacientes() {
        return ResponseEntity.ok(this.pacienteRepository.findAll());
    }

    @Override
    public ResponseEntity<PacienteEntity> encontrarPaciente(int id) {
        Optional<PacienteEntity> paciente=this.pacienteRepository.findById(id);
        if(paciente.isPresent()){
            return ResponseEntity.ok(paciente.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @Override
    public ResponseEntity<?> actualizarPaciente(int id_paciente, PacienteEntity paciente) {
        Optional <PacienteEntity> paciente_encontrado =this.pacienteRepository.findById(id_paciente);
        if(paciente_encontrado.isPresent()){
            PacienteEntity pacienteEntity  = paciente_encontrado.get();
            pacienteEntity.setCedula(paciente.getCedula());
            pacienteEntity.setNombres(paciente.getNombres());
            pacienteEntity.setApellidos(paciente.getApellidos());
            pacienteEntity.setEdad(paciente.getEdad());
            pacienteEntity.setFecha_nacimiento(paciente.getFecha_nacimiento());
            pacienteEntity.setEstado(paciente.isEstado());

            PacienteEntity nuevoPaciente =this.pacienteRepository.save(pacienteEntity);
            return ResponseEntity.ok(nuevoPaciente);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
}
