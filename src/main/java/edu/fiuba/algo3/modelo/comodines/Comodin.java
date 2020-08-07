package edu.fiuba.algo3.modelo.comodines;

import edu.fiuba.algo3.modelo.excepciones.jugador.JugadorError;
import edu.fiuba.algo3.modelo.excepciones.comodin.ComodinError;
import edu.fiuba.algo3.modelo.excepciones.comodin.FactorComodinNegativoError;
import edu.fiuba.algo3.modelo.excepciones.comodin.FactorComodinNuloError;
import edu.fiuba.algo3.modelo.excepciones.comodin.JugadorInvalidoError;
import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Respuesta;
import edu.fiuba.algo3.modelo.util.punto.Punto;

import java.util.ArrayList;

public abstract class Comodin {
    protected int factor;
    protected Jugador jugador;

    public Comodin(int factor) throws ComodinError {
        if (factor == 0)  {
            throw new FactorComodinNuloError();
        }
        if (factor < 0) {
            throw new FactorComodinNegativoError();
        }
        this.factor = factor;
    }

    public int obtenerFactor() {
        return this.factor;
    }

    public Jugador obtenerJugador() {
        return this.jugador;
    }

    public abstract void validarPregunta(Jugada jugada) throws ComodinError, JugadorError;

    abstract void aplicarARespuestas(ArrayList<Respuesta> respuestas) throws ComodinError, JugadorError;

    public void definirJugador(Jugador jugador) throws ComodinError {
        if(jugador == null){
            throw new JugadorInvalidoError();
        }
        this.jugador = jugador;
    }

    public Punto aplicarComodinAPunto(Punto puntaje) {
        return puntaje.multiplicarPorFactor(this.factor);
    }
}
