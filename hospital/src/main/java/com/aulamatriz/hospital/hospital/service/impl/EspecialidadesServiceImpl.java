package com.aulamatriz.hospital.hospital.service.impl;

import com.aulamatriz.hospital.hospital.entities.EspecialidadEntity;
import com.aulamatriz.hospital.hospital.repository.EspecialidadesRepository;
import com.aulamatriz.hospital.hospital.service.EspecialidadesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EspecialidadesServiceImpl implements EspecialidadesService {

    private final EspecialidadesRepository especialidadesRepository;

    public EspecialidadesServiceImpl(EspecialidadesRepository especialidadesRepository) {
        this.especialidadesRepository = especialidadesRepository;
    }

    @Override
    public ResponseEntity<?> crearEspecialidad(EspecialidadEntity especialidad) {
        EspecialidadEntity nuevaEspecialidad=this.especialidadesRepository.save(especialidad);

        return ResponseEntity
                .ok(nuevaEspecialidad);
    }

    @Override
    public ResponseEntity<List<EspecialidadEntity>> listarEspecialidades() {
        return ResponseEntity
                .ok(this.especialidadesRepository.findAll());
    }

    @Override
    public ResponseEntity<EspecialidadEntity> encontrarEspecialidad(int id_especialidad) {
        Optional<EspecialidadEntity> especialidad=this.especialidadesRepository.findById(id_especialidad);
        if(especialidad.isPresent()){
            return ResponseEntity.ok(especialidad.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @Override
    public ResponseEntity<?> actualizarEspecialidad(int id_especialidad, EspecialidadEntity especialidad) {
        Optional <EspecialidadEntity> especialidad_encontrado =this.especialidadesRepository.findById(id_especialidad);
        if(especialidad_encontrado.isPresent()){
            EspecialidadEntity especialidadEntity=especialidad_encontrado.get();
            especialidadEntity.setEspecialidad(especialidad.getEspecialidad());
            especialidadEntity.setEstado(especialidad.isEstado());

            EspecialidadEntity nueva_especialidad =this.especialidadesRepository.save(especialidadEntity);
            return ResponseEntity.ok(nueva_especialidad);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
}
