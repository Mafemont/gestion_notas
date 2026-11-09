package com.example.gestion_notas.presentation.controller;

import com.example.gestion_notas.application.service.DocenteService;
import com.example.gestion_notas.domain.model.Docente;
import com.example.gestion_notas.excepciones.DocenteNoEncontradoExcepcion;
import com.example.gestion_notas.excepciones.DocenteNullExcepcion;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    private final DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @GetMapping
    public List<Docente> findAll() {
        return docenteService.findAll();
    }

    @GetMapping("/{docenteId}")
    public Optional findByDocenteId(@PathVariable Long id) {
        return docenteService.findByDocenteId(id);
    }

    @PostMapping
    public Docente save(@RequestBody Docente docente) {
       return docenteService.save(docente);
    }

    @PutMapping
    public Docente update(@RequestBody Docente docente) {
        return DocenteService.update(docente);
    }

    @DeleteMapping
    public Docente update(@RequestBody Docente docente) {
        return docenteService.update(docente);
        try {
            docenteService.deleteByDocenteId(Long docenteId);
        }catch (DocenteNullExcepcion exception){
            System.out.println(exception.getMessage());
        }catch (DocenteNoEncontradoExcepcion exception){
            System.out.println(exception.getMessage());
        }

    @PatchMapping("/{docenteId}")
    public Docente partialUpdate(@PathVariable Long docenteId, @RequestBody Docente){
        return docenteService.patch(Docente, docenteId);
        }

}
