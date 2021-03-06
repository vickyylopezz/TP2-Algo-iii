package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.comodines.Comodin;
import edu.fiuba.algo3.modelo.excepciones.comodin.ComodinError;
import edu.fiuba.algo3.modelo.excepciones.jugador.JugadorError;
import edu.fiuba.algo3.modelo.excepciones.jugador.JugadorNoTieneAlComodinError;
import edu.fiuba.algo3.modelo.util.punto.Punto;
import edu.fiuba.algo3.modelo.util.punto.PuntoExacto;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private final ArrayList<Respuesta> respuestas;
    private final ArrayList<Comodin> comodines;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.respuestas = new ArrayList<>();
        this.comodines = new ArrayList<>();
    }

    public String nombre() {
        return this.nombre;
    }

    public void cambiarNombre(String nombre) { this.nombre = nombre; }

    public ArrayList<Respuesta> obtenerRespuestas() { return new ArrayList<>(this.respuestas); }

    public ArrayList<Comodin> obtenerComodines() { return new ArrayList<>(this.comodines); }

    public void agregarRespuesta(Respuesta respuesta) {
        if (respuesta == null || this.respuestas.contains(respuesta)) return;
        this.respuestas.add(respuesta);
    }

    public void sacarRespuesta(Respuesta respuesta) {
        this.respuestas.remove(respuesta);
    }

    public void agregarComodin(Comodin comodin) throws ComodinError {
        if (comodin == null || this.comodines.contains(comodin)) return;
        this.comodines.add(comodin);
        comodin.definirJugador(this);
    }

    public void sacarComodin(Comodin comodin) { this.comodines.remove(comodin); }

    public Punto puntajeTotal() {
        PuntoExacto puntajeTotal = new PuntoExacto();
        for (Respuesta respuesta : this.respuestas){
            puntajeTotal.agregarValor(respuesta.puntaje());
        }
        return puntajeTotal;
    }

    public void validarComodin(Comodin comodin) throws JugadorError {
        if (!this.comodines.contains(comodin)) {
            throw new JugadorNoTieneAlComodinError();
        }
    }
}
