package com.example.gestion_notas.application.service;

import com.example.gestion_notas.domain.model.Estudiante;
import com.example.gestion_notas.excepciones.EstudianteInvalidoExcepcion;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    Estudiante save(Estudiante estudiante);
    List<Estudiante> findAll();
    Optional findByEstudianteId(Long estudianteId);
    void deleteByEstudianteId(Estudiante estudiante);
    Estudiante update(Estudiante estudiante);
    Estudiante patch (Estudiante estudiante, Long estudianteId);

}
