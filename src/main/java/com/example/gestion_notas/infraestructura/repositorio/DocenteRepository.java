package com.example.gestion_notas.infraestructura.repositorio;

import com.example.gestion_notas.domain.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {
}
