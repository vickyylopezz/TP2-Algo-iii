package edu.fiuba.algo3.modelo.preguntas.estados;

import edu.fiuba.algo3.modelo.preguntas.calculadorPuntaje.CalculadorPuntaje;
import edu.fiuba.algo3.modelo.util.punto.Punto;
import edu.fiuba.algo3.modelo.util.punto.PuntoNegativo;

public class ConPenalidad extends EstadoPregunta {

    public ConPenalidad(CalculadorPuntaje calculadorPuntaje) {
        super(calculadorPuntaje);
    }

    @Override
    public Boolean conPenalidad() { return true; }

    @Override
    public Punto puntajeIncorrecto() { return new PuntoNegativo(); }
}
