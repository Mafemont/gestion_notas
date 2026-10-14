package com.example.gestion_notas.infraestructura.repositorio;

import com.example.gestion_notas.domain.model.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoRepository extends JpaRepository<Telefono, Integer> {
}
