package com.example.gestion_notas.infraestructura.repositorio;

import com.example.gestion_notas.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
