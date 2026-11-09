package com.example.gestion_notas.excepciones;

public class CursoInvalidoExcepcion extends RuntimeException {
  public CursoInvalidoExcepcion(String message) {
    super(message);
  }
}
