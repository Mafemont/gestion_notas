package com.example.gestion_notas.infraestructura.repositorio;

import com.example.gestion_notas.domain.model.Docente;
import com.example.gestion_notas.domain.model.Estudiante;
import com.example.gestion_notas.domain.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
    Optional<Docente> findByDocenteId(Long id);
}
