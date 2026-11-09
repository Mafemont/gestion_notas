package com.example.gestion_notas.excepciones;

public class MatriculaNullExcepcion extends RuntimeException {
    public MatriculaNullExcepcion(String message) {
        super(message);
    }
}
