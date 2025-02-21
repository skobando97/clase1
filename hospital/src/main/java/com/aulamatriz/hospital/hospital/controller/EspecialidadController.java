package com.aulamatriz.hospital.hospital.controller;


import com.aulamatriz.hospital.hospital.entities.EspecialidadEntity;
import com.aulamatriz.hospital.hospital.service.EspecialidadesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {

    private final EspecialidadesService especialidadesService;

    public EspecialidadController(EspecialidadesService especialidadesService) {
        this.especialidadesService = especialidadesService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody EspecialidadEntity especialidad){
        return this.especialidadesService.crearEspecialidad(especialidad);
    }
    @GetMapping("/")
    public ResponseEntity<?> select(){
        return this.especialidadesService.listarEspecialidades();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return this.especialidadesService.encontrarEspecialidad(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable  int id,@RequestBody EspecialidadEntity especialidad ){
        return this.especialidadesService.actualizarEspecialidad(id,especialidad);
    }
}
