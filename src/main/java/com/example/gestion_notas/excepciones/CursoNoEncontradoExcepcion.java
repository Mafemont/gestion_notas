package com.example.gestion_notas.excepciones;

public class CursoNoEncontradoExcepcion extends RuntimeException {
  public CursoNoEncontradoExcepcion(String message) {
    super(message);
  }
}
