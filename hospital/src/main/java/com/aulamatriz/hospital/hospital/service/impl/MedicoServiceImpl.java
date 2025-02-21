package com.aulamatriz.hospital.hospital.service.impl;

import com.aulamatriz.hospital.hospital.entities.EspecialidadEntity;
import com.aulamatriz.hospital.hospital.entities.MedicoEntity;
import com.aulamatriz.hospital.hospital.repository.EspecialidadesRepository;
import com.aulamatriz.hospital.hospital.repository.MedicoRepository;
import com.aulamatriz.hospital.hospital.service.MedicoService;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MedicoServiceImpl  implements MedicoService {

    private final MedicoRepository medicoRepository;
    private final EspecialidadesRepository especialidadesRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository, EspecialidadesRepository especialidadesRepository) {
        this.medicoRepository = medicoRepository;
        this.especialidadesRepository = especialidadesRepository;
    }

    @Override
    public ResponseEntity<?> agregarMedico(MedicoEntity medico) {
        MedicoEntity nuevoMedico=this.medicoRepository.save(medico);
        //SimpleJpaRepository<Object, Object> especialidadRepository;
        //EspecialidadEntity especialidad = especialidadesRepository.findById(medico.getId_especialidad())
          //      .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));
        return ResponseEntity
                .ok(nuevoMedico);
    }

    @Override
    public ResponseEntity<List<MedicoEntity>> listarMedicos() {

        return ResponseEntity
                .ok(this.medicoRepository.findAll());
    }

    @Override
    public ResponseEntity<MedicoEntity> encontrarMedico(int id_medico) {
        Optional<MedicoEntity> medico=this.medicoRepository.findById(id_medico);
        if(medico.isPresent()){
            return ResponseEntity.ok(medico.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @Override
    public ResponseEntity<?> actualizarMedico(int id_medico, MedicoEntity medico) {
        Optional <MedicoEntity> medico_encontrado =this.medicoRepository.findById(id_medico);
        if(medico_encontrado.isPresent()){
            MedicoEntity medicoEntity  = medico_encontrado.get();
            medicoEntity.setCedula(medico.getCedula());
            medicoEntity.setNombres(medico.getNombres());
            medicoEntity.setApellidos(medico.getApellidos());
            medicoEntity.setEdad(medico.getEdad());
            medicoEntity.setEstado(medico.isEstado());
            medicoEntity.setId_especialidad(medico.getId_especialidad());

            MedicoEntity nuevomedico =this.medicoRepository.save(medicoEntity);
            return ResponseEntity.ok(nuevomedico);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
