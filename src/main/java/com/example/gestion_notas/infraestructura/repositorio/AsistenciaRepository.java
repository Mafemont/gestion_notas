package com.example.gestion_notas.infraestructura.repositorio;

import com.example.gestion_notas.domain.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
}
