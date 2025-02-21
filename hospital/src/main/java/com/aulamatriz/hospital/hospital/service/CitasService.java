package com.aulamatriz.hospital.hospital.service;

import com.aulamatriz.hospital.hospital.entities.CitasEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CitasService {
    ResponseEntity<?> crearCita (CitasEntity cita);
    ResponseEntity<List<CitasEntity>> listarCitas ();
    ResponseEntity<CitasEntity> encontrarCita(int id_cita);
    ResponseEntity<?> actualizarCita(int id_cita,CitasEntity cita);
    ResponseEntity<?> eliminarCita(int id_cita);
}
