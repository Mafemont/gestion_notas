package com.example.gestion_notas.infraestructura.repositorio;

import com.example.gestion_notas.domain.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
