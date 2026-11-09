package com.example.gestion_notas.application.service.impl;

import com.example.gestion_notas.application.service.MatriculaService;
import com.example.gestion_notas.domain.model.Matricula;
import com.example.gestion_notas.excepciones.*;
import com.example.gestion_notas.infraestructura.repositorio.MatriculaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

   @Override
   public Optional findByMatriculaId(Long id){
        Optional<Matricula> matricula = matriculaRepository.findByMatriculaId(id);
        if (matricula !=null){
            return matricula;
        }
        return null;
   }

    @Override
    @Transactional
    public Matricula save(Matricula matricula) {
        if (matricula == null) {
            throw new MatriculaInvalidaExcepcion("Los datos de la matricula son Obligatorios");
        }
        if (matricula.getMatriculaId() == null) {
            throw new MatriculaEncontradaExcepcion("La matricula con ID " + matricula.getMatriculaId() + " ya existe");
        }
        return matriculaRepository.save(matricula);
    }

    @Override
    @Transactional
    public void deleteByMatriculaId(Matricula matricula) {
        if (matricula == null) {
            throw new MatriculaNullExcepcion("Los datos de la matricula son obligatorios");
        }
        Matricula matriculaEncontrada = matriculaRepository.findByMatriculaId(matricula.getMatriculaId()).orElse(null);
        if (matriculaEncontrada == null) {
            throw new MatriculaEncontradaExcepcion("La matricula no se encontro");
        }
        matriculaRepository.deleteByMatriculaId(matricula.getMatriculaId());
    }

    @Override
    @Transactional
    public Matricula update(Matricula matricula) {
        if (matricula != null) {
            return matriculaRepository.save(matricula);
        }
        return null;
    }

    @Override
    @Transactional
    public Matricula patch(Matricula matricula, Long matriculaId) {
        Matricula updatedMatricula = matriculaRepository.findByMatriculaId(matriculaId);
        if (matricula != null) {
            return matriculaRepository.save(updatedMatricula);
        }
        return null;
    }
}
