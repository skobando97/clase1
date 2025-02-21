package com.aulamatriz.hospital.hospital.service;


import com.aulamatriz.hospital.hospital.entities.MedicoEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MedicoService {
    ResponseEntity<?> agregarMedico (MedicoEntity medico);
    ResponseEntity<List<MedicoEntity>> listarMedicos ();
    ResponseEntity<MedicoEntity> encontrarMedico(int id_medico);
    ResponseEntity<?> actualizarMedico(int id_medico,MedicoEntity medico);

}
