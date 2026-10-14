package com.example.gestion_notas.infraestructura.repositorio;

import com.example.gestion_notas.domain.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
}
