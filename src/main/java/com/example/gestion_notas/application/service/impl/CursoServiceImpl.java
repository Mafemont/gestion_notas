package com.example.gestion_notas.application.service.impl;

import com.example.gestion_notas.application.service.CursoService;
import com.example.gestion_notas.domain.model.Curso;
import com.example.gestion_notas.domain.model.Estudiante;
import com.example.gestion_notas.excepciones.*;
import com.example.gestion_notas.infraestructura.repositorio.CursoRepository;
import com.example.gestion_notas.infraestructura.repositorio.DocenteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional findByCursoId(Long id) {
        Optional<Curso> curso = cursoRepository.findByCursoId(id);
        if (curso !=null){
            return curso;
        }
        return null;
    }

    @Override
    @Transactional
    public Curso save (Curso curso){
        if (curso==null){
            throw new CursoNullExcepcion("Los datos del Curso son Obligatorios");
        }
        if (curso.getCursoId() === null){
            throw new CursoInvalidoExcepcion("El Curso no puede tener campos nulos");
        }
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void deleteByCursoId(Curso curso){
        if (curso==null){
            throw new CursoNullExcepcion("Los datos del Curso son obligatorios");
        }
        Curso cursoEncontrado = cursoRepository.findByCursoId(curso.getCursoId()).orElse(null);
        if (cursoEncontrado == null){
            throw new CursoEncontradoExcepcion("El Curso no se encontro");
        }
        cursoRepository.deleteByCursoId(curso.getCursoId());
    }

    @Override
    @Transactional
    public Curso update(Curso curso) {
        if(curso!=null){
            return cursoRepository.save(curso);
        }
        return null;
    }

    @Override
    @Transactional
    public Curso patch(Curso curso, Long cursoId) {
        Optional<Curso> updatedCurso = cursoRepository.findByCursoId(cursoId);
        if(curso!=null){
            return cursoRepository.save(updatedCurso);
        }
        return null;
    }
}
