package com.aulamatriz.hospital.hospital.controller;

import com.aulamatriz.hospital.hospital.entities.MedicoEntity;
import com.aulamatriz.hospital.hospital.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/medicos")
public class MedicosController {
    private final MedicoService medicoService;

    public MedicosController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody MedicoEntity medico){
        return this.medicoService.agregarMedico(medico);
    }
    @GetMapping("/")
    public ResponseEntity<?> select(){
        return this.medicoService.listarMedicos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return this.medicoService.encontrarMedico(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable  int id,@RequestBody MedicoEntity medico ){
        return this.medicoService.actualizarMedico(id,medico);
    }
}
