package com.aulamatriz.hospital.hospital.controller;

import com.aulamatriz.hospital.hospital.entities.CitasEntity;
import com.aulamatriz.hospital.hospital.entities.EspecialidadEntity;
import com.aulamatriz.hospital.hospital.service.CitasService;
import com.aulamatriz.hospital.hospital.service.EspecialidadesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/citas")
public class CitasController {
    private final CitasService citasService;

    public CitasController(CitasService citasService) {
        this.citasService = citasService;
    }
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody CitasEntity cita){
        return this.citasService.crearCita(cita);
    }
    @GetMapping("/")
    public ResponseEntity<?> select(){
        return this.citasService.listarCitas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return this.citasService.encontrarCita(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable  int id,@RequestBody CitasEntity cita ){
        return this.citasService.actualizarCita(id,cita);
    }
}
