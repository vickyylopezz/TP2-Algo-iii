package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.excepciones.ComodinError;
import edu.fiuba.algo3.modelo.excepciones.RespuestaError;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.util.punto.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class MultiplicadorTest {
    @Test
    public void seCreaMultiplicadorConFactorNuloYSeLanzaExcepcion() {

        assertThrows(ComodinError.class, () -> new Multiplicador(0));
    }

    @Test
    public void seCreaMultiplicadorConFactorNegativoYSeLanzaExcepcion() {

        assertThrows(ComodinError.class, () -> new Multiplicador(-1));
    }

    @Test
    public void seCreaMultiplicadorConFactorPositivoYDevuelveElFactor() throws ComodinError {
        Multiplicador multiplicador = new Multiplicador(2);

        assertEquals(2,multiplicador.factor());
    }

    /*@Test
    public void seAplicaSobrePreguntaConPenalidadYComodinSeGuardaEnRespuesta() throws ComodinError, RespuestaError {
        Pregunta pregunta = mock(Pregunta.class);
        Multiplicador multiplicador = new Multiplicador(2);
        Jugador jugador = new Jugador("JUan");
        Respuesta respuesta = new Respuesta(pregunta,jugador);
        Opcion opcionCorrecta = new Opcion("Bien",new PuntoPositivo());
        respuesta.agregarOpcion(opcionCorrecta);

        multiplicador.asignarA(respuesta);

        assertEquals(1,respuesta.comodines().size());
    }

    @Test
    public void seAplicaSobrePreguntaSinPenalidadYSeLanzaExcepcion() throws ComodinError, RespuestaError {
        Pregunta pregunta = mock(Pregunta.class);
        Multiplicador multiplicador = new Multiplicador(2);
        Jugador jugador = new Jugador("JUan");
        Respuesta respuesta = new Respuesta(pregunta,jugador);
        Opcion opcionCorrecta = new Opcion("Bien",new PuntoPositivo());
        respuesta.agregarOpcion(opcionCorrecta);

        assertThrows(ComodinError.class, () ->  multiplicador.asignarA(respuesta));
    }*/
}
