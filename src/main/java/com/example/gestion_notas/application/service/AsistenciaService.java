package com.example.gestion_notas.application.service;

import com.example.gestion_notas.domain.model.Asistencia;

import java.util.List;
import java.util.Optional;

public interface AsistenciaService {


    void save(Asistencia asistencia);
    List<Asistencia> findAll();
    Optional<Asistencia> findById(Integer id);
    void delete(Integer id);
    void update(Asistencia asistencia);

}
