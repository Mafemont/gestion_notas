package com.example.gestion_notas.presentation.controller;

import com.example.gestion_notas.application.service.MatriculaService;
import com.example.gestion_notas.domain.model.Matricula;
import com.example.gestion_notas.excepciones.MatriculaNoEncontradaExcepcion;
import com.example.gestion_notas.excepciones.MatriculaNullExcepcion;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public List<Matricula> findAll() {
        return matriculaService.findAll();
    }

    @GetMapping("/{matriculaId}")
    public Optional findByMatriculaId(@PathVariable Long id) {
        return matriculaService.findByMatriculaId(id);
    }

    @PostMapping
    public Matricula save(@RequestBody Matricula matricula) {
        return matriculaService.save(matricula);
    }

    @PutMapping("/{matriculaId}")
    public Matricula update(@RequestBody Matricula matricula) {
       return matriculaService.update(matricula);
    }

    @DeleteMapping("/{matriculaId}")
    public void delete(@PathVariable Long matriculaId){
        try {
            matriculaService.deleteByMatriculaId(matriculaId);
        } catch (MatriculaNullExcepcion exception){
            System.out.println(exception.getMessage());
        } catch (MatriculaNoEncontradaExcepcion exception){
            System.out.println(exception.getMessage());
        }
    }

    @PatchMapping("/{matriculaId}")
    public Matricula partialUpdate(@PathVariable Long @RequestBody Matricula) {
        return matriculaService.patch(Matricula);
    }
}
