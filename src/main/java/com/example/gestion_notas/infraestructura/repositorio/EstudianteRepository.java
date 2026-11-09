package com.example.gestion_notas.infraestructura.repositorio;

import com.example.gestion_notas.domain.model.Estudiante;
import com.example.gestion_notas.domain.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Optional<Estudiante> findByEstudianteId(Long estudianteId);
    void deleteByEstudianteId(Long estudianteId);

}
