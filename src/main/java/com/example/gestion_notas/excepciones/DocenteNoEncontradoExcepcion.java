package com.example.gestion_notas.excepciones;

public class DocenteNoEncontradoExcepcion extends RuntimeException {
  public DocenteNoEncontradoExcepcion(String message) {
    super(message);
  }
}
