package com.example.gestion_notas.application.service.impl;

import com.example.gestion_notas.application.service.DocenteService;
import com.example.gestion_notas.domain.model.Docente;
import com.example.gestion_notas.excepciones.DocenteEncontradoExcepcion;
import com.example.gestion_notas.excepciones.DocenteInvalidoExcepcion;
import com.example.gestion_notas.excepciones.DocenteNullExcepcion;
import com.example.gestion_notas.infraestructura.repositorio.DocenteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteServiceImpl(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @Override
    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    @Override
    public Optional<Docente> findByDocenteId(Long id) {
        Optional<Docente> docente = docenteRepository.findByDocenteId(id);
        if (docente != null) {
            return docente;
        }
        return null;
    }

    @Override
    @Transactional
    public Docente save(Docente docente) {
        if(docente==null) {
            throw new DocenteInvalidoExcepcion("Los datos del docente son obligatorios");
        }
        if (docente.getDocenteId() != null){
            throw new DocenteInvalidoExcepcion("El docente con ID " + docente.getDocenteId()+ "ya existe");
        }
        return docenteRepository.save(docente);
    }

    @Override
    @Transactional
    public void deleteByDocenteId (Docente docente) {
        if (docente == null){
            throw new DocenteNullExcepcion("Los datos del docente son obligatorios");
        }
        Docente docenteEncontrado = docenteRepository.findByDocenteId(docente.getDocenteId()).orElse(null);
        if (docenteEncontrado == null){
            throw new DocenteEncontradoExcepcion("El docente no se encontro");
        }
        docenteRepository.findByDocenteId(docente.getDocenteId());
    }

    @Override
    @Transactional
    public Docente update(Docente docente) {
        if(docente!=null){
            return docenteRepository.save(docente);
        }
        return null;
    }

    @Override
    @Transactional
    public Docente patch (Docente docente, Long docenteId) {
        Optional <Docente> updatedDocente = docenteRepository.findByDocenteId(docenteId);
        if(docente !=null){
            return docenteRepository.save(updatedDocente);
        }
        return null;
    }
}
