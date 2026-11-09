package com.example.gestion_notas.excepciones;

public class DocenteInvalidoExcepcion extends RuntimeException {
  public DocenteInvalidoExcepcion(String message) {
    super(message);
  }
}
