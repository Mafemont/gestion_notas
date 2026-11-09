package com.example.gestion_notas.excepciones;

public class MatriculaInvalidaExcepcion extends RuntimeException {
    public MatriculaInvalidaExcepcion(String message) {
        super(message);
    }
}
