package com.aulamatriz.hospital.hospital.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="especialidades")
public class EspecialidadEntity {
    @Id
    private int id_especialidad;
    private String especialidad;
    private boolean estado;

    public EspecialidadEntity(int id_especialidad, String especialidad, boolean estado) {
        this.id_especialidad = id_especialidad;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public EspecialidadEntity() {
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
