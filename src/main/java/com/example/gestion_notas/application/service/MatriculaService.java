package com.example.gestion_notas.application.service;

import com.example.gestion_notas.domain.model.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    Matricula save(Matricula matricula);
    List<Matricula> findAll();
    Optional findByMatriculaId(Long matriculaId);
    void deleteByMatriculaId(Matricula matricula);
    Matricula update(Matricula matricula);
    Matricula patch(Matricula matricula, Long matriculaId);

}
