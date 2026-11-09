package com.example.gestion_notas.application.service;

import com.example.gestion_notas.domain.model.Docente;


import java.util.List;
import java.util.Optional;

public interface DocenteService {

    Docente save(Docente docente);
    List<Docente> findAll();
    Optional findByDocenteId (Long docenteId);
    void deleteByDocenteId (Docente docente);
    Docente update(Docente docente);
    Docente patch(Docente docente, Long docenteId);

}
