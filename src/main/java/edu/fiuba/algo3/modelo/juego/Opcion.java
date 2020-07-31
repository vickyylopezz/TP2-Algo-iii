package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.preguntas.Grupo;
import edu.fiuba.algo3.modelo.util.punto.Punto;

public abstract class Opcion {
    protected String titulo;
    protected Punto punto;

    public String obtenerTitulo(){ return this.titulo; }

    public Punto obtenerPunto(){ return this.punto; }
}
