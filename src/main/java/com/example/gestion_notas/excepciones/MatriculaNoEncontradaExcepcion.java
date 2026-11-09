package com.example.gestion_notas.excepciones;

public class MatriculaNoEncontradaExcepcion extends RuntimeException {
    public MatriculaNoEncontradaExcepcion(String message) {
        super(message);
    }
}
