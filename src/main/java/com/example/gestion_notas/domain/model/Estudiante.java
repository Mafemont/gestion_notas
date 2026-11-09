package com.example.gestion_notas.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ESTUDIANTE")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long estudianteId;

    @Column(name = "nombre", nullable = false, length = 100)
    @NotNull
    @Size(max=100)
    @NotEmpty
    private String nombre;

    @Column(name = "correo", nullable = false, length = 100)
    @NotNull
    @Size(max=100)
    @NotEmpty
    @Email
    private String email;

    @Column(name = "activo", nullable = false)
    @NotNull
    private EstatusEstudiante activo;

    public Estudiante() {
    }

    public Estudiante(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.activo = EstatusEstudiante.ACTIVO;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {this.estudianteId = estudianteId}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() { return email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public EstatusEstudiante getActivo() {
        return activo;
    }

    public void setActivo(EstatusEstudiante activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "estudianteId=" + estudianteId +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", email=" + activo +
                '}';
    }
}
