package com.example.gestion_notas.infraestructura.repositorio;

import com.example.gestion_notas.domain.model.Curso;
import com.example.gestion_notas.domain.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByCursoId(Long id);

    void deleteByCursoId(long cursoId);
}
