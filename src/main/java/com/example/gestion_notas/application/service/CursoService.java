package com.example.gestion_notas.application.service;

import com.example.gestion_notas.domain.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    Curso save(Curso curso);
    List<Curso> findAll();
    Optional findByCursoId(Long cursoId);
    void deleteByCursoId(Curso curso);
    Curso update(Curso curso);
    Curso patch(Curso curso, Long cursoId);

}
