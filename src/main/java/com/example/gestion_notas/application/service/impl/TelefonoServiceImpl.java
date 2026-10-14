package com.example.gestion_notas.application.service.impl;

import com.example.gestion_notas.application.service.TelefonoService;
import com.example.gestion_notas.domain.model.Telefono;
import com.example.gestion_notas.infraestructura.repositorio.TelefonoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefonoServiceImpl implements TelefonoService {

    private final TelefonoRepository telefonoRepository;

    public TelefonoServiceImpl(TelefonoRepository telefonoRepository) {
        this.telefonoRepository = telefonoRepository;
    }

    @Override
    public void save(Telefono telefono) {
        telefonoRepository.save(telefono);
    }

    @Override
    public List<Telefono> findAll() {
        return telefonoRepository.findAll();
    }

    @Override
    public Optional<Telefono> findById(Integer id) {
        return telefonoRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        telefonoRepository.deleteById(id);
    }

    @Override
    public void update(Telefono telefono) {
        telefonoRepository.save(telefono);
    }
}
