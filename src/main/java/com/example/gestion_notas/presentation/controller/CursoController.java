package com.example.gestion_notas.presentation.controller;

import com.example.gestion_notas.application.service.CursoService;
import com.example.gestion_notas.domain.model.Curso;
import com.example.gestion_notas.domain.model.Estudiante;
import com.example.gestion_notas.excepciones.CursoNoEncontradoExcepcion;
import com.example.gestion_notas.excepciones.CursoNullExcepcion;
import com.example.gestion_notas.excepciones.EstudianteNoEncontradoExcepcion;
import com.example.gestion_notas.excepciones.EstudianteNullExcepcion;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    @GetMapping("/{cursoId}")
    public Optional findByCursoId(@PathVariable Long id) {
        return cursoService.findByCursoId(id);
    }

    @PostMapping
    public void save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @PutMapping
    public void update(@RequestBody Curso curso) {
        return cursoService.update(curso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long cursoId) {
        try {
            CursoService.deleteByCursoId(Long cursoId);
        }catch (CursoNullExcepcion excepcion){
            System.out.println(excepcion.getMessage());
        }catch (CursoNoEncontradoExcepcion exception){
            System.out.println(exception.getMessage());
        }

    @PatchMapping("/{cursoId}");
    public Curso partialUpdate(@PathVariable Long cursoId, @RequestBody Curso){
    return cursoService.patch(Curso, cursoId);
        }
    }


}
