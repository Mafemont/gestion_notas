package com.example.gestion_notas.application.service;

import com.example.gestion_notas.domain.model.Nota;

import java.util.List;
import java.util.Optional;

public interface NotaService {
    void save(Nota nota);
    List<Nota> findAll();
    Optional<Nota> findById(Integer id);
    void delete(Integer id);
    void update(Nota nota);

}
