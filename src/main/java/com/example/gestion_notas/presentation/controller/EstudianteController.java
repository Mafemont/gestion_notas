package com.example.gestion_notas.presentation.controller;


import com.example.gestion_notas.excepciones.EstudianteEncontradoExcepcion;
import com.example.gestion_notas.excepciones.EstudianteInvalidoExcepcion;
import com.example.gestion_notas.excepciones.EstudianteNullExcepcion;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import com.example.gestion_notas.application.service.EstudianteService;
import com.example.gestion_notas.domain.model.Estudiante;
import com.example.gestion_notas.excepciones.EstudianteNoEncontradoExcepcion;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> findAll() {
        return estudianteService.findAll();
    }

    @GetMapping("/{estudianteId}")
    public Optional findByEstudianteId(@PathVariable Long id) {
        return estudianteService.findByEstudianteId(id);
                //.orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + estudianteId));//
    }

    @PostMapping
    public Estudiante save(@Valid @RequestBody Estudiante estudiante) {
        try {
            return estudianteService.save(estudiante);
        } catch (EstudianteNullExcepcion e) {
            System.out.println(e.getMessage());
            return null;
        } catch (EstudianteEncontradoExcepcion e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PutMapping
    public Estudiante update(@RequestBody Estudiante estudiante) {
        return estudianteService.update(estudiante);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long estudianteId) {
        try {
            estudianteService.deleteByEstudianteId(Long estudianteId);
        }catch (EstudianteNullExcepcion excepcion){
            System.out.println(excepcion.getMessage());
        }catch (EstudianteNoEncontradoExcepcion exception){
            System.out.println(exception.getMessage());
    }

    @PatchMapping("/{estudianteId}")
    public Estudiante partialUpdate(@PathVariable Long estudianteId, @RequestBody Estudiante){
        return estudianteService.patch(Estudiante, estudianteId);
    }
}
