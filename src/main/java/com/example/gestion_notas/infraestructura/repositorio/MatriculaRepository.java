package com.example.gestion_notas.infraestructura.repositorio;

import com.example.gestion_notas.domain.model.Estudiante;
import com.example.gestion_notas.domain.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    void deleteByMatriculaId(Long matriculaId);
    Optional<Estudiante> findByMatriculaId(Long id);
}
