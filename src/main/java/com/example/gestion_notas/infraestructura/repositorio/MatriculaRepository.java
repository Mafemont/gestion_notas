package com.example.gestion_notas.infraestructura.repositorio;

import com.example.gestion_notas.domain.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
}
