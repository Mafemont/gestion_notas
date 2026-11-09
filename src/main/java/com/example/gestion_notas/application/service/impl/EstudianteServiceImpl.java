package com.example.gestion_notas.application.service.impl;

import com.example.gestion_notas.application.service.EstudianteService;
import com.example.gestion_notas.domain.model.Estudiante;
import com.example.gestion_notas.excepciones.EstudianteEncontradoExcepcion;
import com.example.gestion_notas.excepciones.EstudianteInvalidoExcepcion;
import com.example.gestion_notas.excepciones.EstudianteNullExcepcion;
import com.example.gestion_notas.infraestructura.repositorio.EstudianteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Optional findByEstudianteId(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findByEstudianteId(id);
        if (estudiante !=null){
            return estudiante;
        }
        return null;
    }

    @Override
    @Transactional
    public Estudiante save (Estudiante estudiante){
        if (estudiante==null){
            throw new EstudianteNullExcepcion("Los datos del estudiante son Obligatorios");
        }
        if (estudiante.getEstudianteId() == null || estudiante.getEmail() == null){
            throw new EstudianteInvalidoExcepcion("El estudiante no puede tener campos nulos");
        }
        return estudianteRepository.save(estudiante);
    }

    @Override
    @Transactional
    public void deleteByEstudianteId(Estudiante estudiante){
        if (estudiante==null){
            throw new EstudianteNullExcepcion("Los datos del estudiante son obligatorios");
        }
        Estudiante estudianteEncontrado = estudianteRepository.findByEstudianteId(estudiante.getEstudianteId()).orElse(null);
        if (estudianteEncontrado == null){
            throw new EstudianteEncontradoExcepcion("El estudiante no se encontro");
        }
        estudianteRepository.deleteByEstudianteId(estudiante.getEstudianteId());
    }

    @Override
    @Transactional
    public Estudiante update(Estudiante estudiante) {
        if(estudiante!=null){
            return estudianteRepository.save(estudiante);
        }
        return null;
    }

    @Override
    @Transactional
    public Estudiante patch(Estudiante estudiante, Long estudianteId) {
        Optional<Estudiante> updatedEstudiante = estudianteRepository.findByEstudianteId(estudianteId);
        if(estudiante!=null){
            return estudianteRepository.save(updatedEstudiante);
        }
        return null;
    }

}
