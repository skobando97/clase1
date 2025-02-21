package com.aulamatriz.hospital.hospital.controller;

import com.aulamatriz.hospital.hospital.entities.PacienteEntity;
import com.aulamatriz.hospital.hospital.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PacienteEntity paciente){
        return this.pacienteService.crearPaciente(paciente);
    }
    @GetMapping("/")
    public ResponseEntity<?> select(){
        return this.pacienteService.listarPacientes();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable  int id){
        return this.pacienteService.encontrarPaciente(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable  int id,@RequestBody PacienteEntity paciente ){
        return this.pacienteService.actualizarPaciente(id,paciente);
    }
}
