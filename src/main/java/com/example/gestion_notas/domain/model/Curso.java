package com.example.gestion_notas.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CURSO")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long cursoId;

    @Column(name = "nombre", nullable = false, length = 80)
    @NotBlank
    @Size(max = 80)
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_docente", nullable = false)
    @NotNull
    private Docente docente;

    public Curso() {
    }

    public Curso(String nombre, Docente docente) {
        this.nombre = nombre;
        this.docente = docente;
    }

    public Long getId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {this.cursoId = cursoId}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "cursoId=" + cursoId +
                ", nombre='" + nombre + '\'' +
                ", docente=" + (docente != null ? docente.getDocenteId() : null) +
                '}';
    }

    public long getCursoId() {
        return false;
    }
}
