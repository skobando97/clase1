package com.aulamatriz.hospital.hospital.entities;


import jakarta.persistence.*;

@Entity
@Table(name="citas")
public class CitasEntity {
    @Id
    private int id_cita;
    private int paciente;
    private int medico;
    private String fecha_cita_inicio;
    private String fecha_cita_fin;
    private String estado_cita;

    public CitasEntity() {
    }

    public CitasEntity(int id_cita, int paciente, int medico, String fecha_cita_inicio, String fecha_cita_fin, String estado_cita) {
        this.id_cita = id_cita;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha_cita_inicio = fecha_cita_inicio;
        this.fecha_cita_fin = fecha_cita_fin;
        this.estado_cita = estado_cita;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }


    public String getFecha_cita_inicio() {
        return fecha_cita_inicio;
    }

    public void setFecha_cita_inicio(String fecha_cita_inicio) {
        this.fecha_cita_inicio = fecha_cita_inicio;
    }

    public String getFecha_cita_fin() {
        return fecha_cita_fin;
    }

    public void setFecha_cita_fin(String fecha_cita_fin) {
        this.fecha_cita_fin = fecha_cita_fin;
    }

    public String getEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(String estado_cita) {
        this.estado_cita = estado_cita;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public int getMedico() {
        return medico;
    }

    public void setMedico(int medico) {
        this.medico = medico;
    }
}
