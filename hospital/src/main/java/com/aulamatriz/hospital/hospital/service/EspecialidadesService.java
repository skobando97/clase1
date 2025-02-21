package com.aulamatriz.hospital.hospital.service;

import com.aulamatriz.hospital.hospital.entities.EspecialidadEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EspecialidadesService {
    ResponseEntity<?> crearEspecialidad (EspecialidadEntity especialidad);
    ResponseEntity<List<EspecialidadEntity>> listarEspecialidades ();
    ResponseEntity<EspecialidadEntity> encontrarEspecialidad(int id_especialidad);
    ResponseEntity<?> actualizarEspecialidad(int id_especialidad,EspecialidadEntity especialidad);

}
