package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.preguntas.PreguntaError;
import edu.fiuba.algo3.modelo.preguntas.opcion.Grupo;
import edu.fiuba.algo3.modelo.preguntas.opcion.Opcion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GroupChoiceTest {

    @Test
    public void GroupChoiceAsignaPuntosAJugador() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");

        pregunta.definirGrupo("Nombres");
        pregunta.definirGrupo("Numeros");

        ArrayList<Grupo> grupos = pregunta.obtenerGrupos();
        pregunta.agregarOpcion(grupos.get(0),"Carlos");
        pregunta.agregarOpcion(grupos.get(0),"Marta");
        pregunta.agregarOpcion(grupos.get(0),"Paula");

        pregunta.agregarOpcion(grupos.get(1),"Uno");
        pregunta.agregarOpcion(grupos.get(1),"Dos");

        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();

        ArrayList<Opcion> opcionesElegidas = new ArrayList<>();
        opcionesElegidas.add(opciones.get(1));
        opcionesElegidas.add(opciones.get(2));
        opcionesElegidas.add(opciones.get(4));
        opcionesElegidas.add(opciones.get(6));
        opcionesElegidas.add(opciones.get(9));

        assertEquals(pregunta.puntajeConOpciones(opcionesElegidas).obtenerValor(),3);

    }

    @Test
    public void GroupChoicePuedeCrearseConMaximoDeSeisOpciones() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");
        pregunta.definirGrupo("Nombres");
        pregunta.definirGrupo("Numeros");
        ArrayList<Grupo> grupos = pregunta.obtenerGrupos();

        pregunta.agregarOpcion(grupos.get(0),"Carlos");
        pregunta.agregarOpcion(grupos.get(0),"Marta");
        pregunta.agregarOpcion(grupos.get(0),"Paula");
        pregunta.agregarOpcion(grupos.get(1),"Uno");
        pregunta.agregarOpcion(grupos.get(1),"Dos");
        pregunta.agregarOpcion(grupos.get(1),"Tres");

        assertThrows(PreguntaError.class, ()-> pregunta.agregarOpcion(grupos.get(1),"Frula"));
    }

    @Test
    public void GroupChoicePuedeCrearseIndicandoleLosGruposYOpciones() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");
        pregunta.definirGrupo("Nombres");
        pregunta.definirGrupo("Numeros");
        ArrayList<Grupo> grupos = pregunta.obtenerGrupos();

        pregunta.agregarOpcion(grupos.get(0),"Carlos");
        pregunta.agregarOpcion(grupos.get(0),"Marta");
        pregunta.agregarOpcion(grupos.get(0),"Paula");
        pregunta.agregarOpcion(grupos.get(1),"Uno");
        pregunta.agregarOpcion(grupos.get(1),"Dos");

        assertEquals(pregunta.obtenerOpciones().size(),10);

    }

    @Test
    public void GroupChoicePuedeCrearseConMaximoDosGrupos() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");
        pregunta.definirGrupo("Nombres");
        pregunta.definirGrupo("Numeros");

        assertThrows(PreguntaError.class, ()-> pregunta.definirGrupo("Otro Grupo"));
    }

    @Test
    public void GroupChoicePuedeCrearseIndicandoleLosGrupos() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");
        pregunta.definirGrupo("Nombres");
        pregunta.definirGrupo("Numeros");

        assertEquals(pregunta.obtenerGrupos().size(),2);

    }

    @Test
    public void GroupChoiceAsignaPuntosAJugadores() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");

        pregunta.definirGrupo("Colores");
        pregunta.definirGrupo("Animales");

        ArrayList<Grupo> grupos = pregunta.obtenerGrupos();
        pregunta.agregarOpcion(grupos.get(0),"Azul");
        pregunta.agregarOpcion(grupos.get(0),"Rojo");

        pregunta.agregarOpcion(grupos.get(1),"Perro");
        pregunta.agregarOpcion(grupos.get(1),"Gato");
        pregunta.agregarOpcion(grupos.get(1),"Conejo");

        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<>();
        opcionesJugador1.add(opciones.get(0)); // correcta
        opcionesJugador1.add(opciones.get(2)); // correcta
        opcionesJugador1.add(opciones.get(4)); // incorrecta
        opcionesJugador1.add(opciones.get(7)); // correcta
        opcionesJugador1.add(opciones.get(8)); // incorrecta

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<>();
        opcionesJugador2.add(opciones.get(1)); // incorrecta
        opcionesJugador2.add(opciones.get(3)); // incorrecta
        opcionesJugador2.add(opciones.get(5)); // correcta
        opcionesJugador2.add(opciones.get(6)); // incorrecta
        opcionesJugador2.add(opciones.get(9)); // correcta

        assertEquals(pregunta.puntajeConOpciones(opcionesJugador1).obtenerValor(),3);
        assertEquals(pregunta.puntajeConOpciones(opcionesJugador2).obtenerValor(),2);

    }

    @Test
    public void GroupChoiceNoSeAsignanPuntosAJugadorQueRespondeTodasMal() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");

        pregunta.definirGrupo("Flores");
        pregunta.definirGrupo("Animales");

        ArrayList<Grupo> grupos = pregunta.obtenerGrupos();
        pregunta.agregarOpcion(grupos.get(0),"Margarita");
        pregunta.agregarOpcion(grupos.get(0),"Rosa");

        pregunta.agregarOpcion(grupos.get(1),"Perro");
        pregunta.agregarOpcion(grupos.get(1),"Gato");
        pregunta.agregarOpcion(grupos.get(1),"Conejo");

        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();

        ArrayList<Opcion> opcionesElegidas = new ArrayList<>();
        opcionesElegidas.add(opciones.get(1)); // incorrecta
        opcionesElegidas.add(opciones.get(3)); // incorrecta
        opcionesElegidas.add(opciones.get(4)); // incorrecta
        opcionesElegidas.add(opciones.get(6)); // incorrecta
        opcionesElegidas.add(opciones.get(8)); // incorrecta

        assertEquals(pregunta.puntajeConOpciones(opcionesElegidas).obtenerValor(),0);

    }

    @Test
    public void GroupChoiceAsignanTodosLosPuntosAJugadorQueRespondeTodasBien() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");

        pregunta.definirGrupo("Flores");
        pregunta.definirGrupo("Animales");

        ArrayList<Grupo> grupos = pregunta.obtenerGrupos();
        pregunta.agregarOpcion(grupos.get(0),"Margarita");
        pregunta.agregarOpcion(grupos.get(0),"Rosa");
        pregunta.agregarOpcion(grupos.get(0),"Jazmin");

        pregunta.agregarOpcion(grupos.get(1),"Perro");
        pregunta.agregarOpcion(grupos.get(1),"Gato");
        pregunta.agregarOpcion(grupos.get(1),"Conejo");

        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();

        ArrayList<Opcion> opcionesElegidas = new ArrayList<>();
        opcionesElegidas.add(opciones.get(0)); // correcta
        opcionesElegidas.add(opciones.get(2)); // correcta
        opcionesElegidas.add(opciones.get(4)); // correcta
        opcionesElegidas.add(opciones.get(7)); // correcta
        opcionesElegidas.add(opciones.get(9)); // correcta

        assertEquals(pregunta.puntajeConOpciones(opcionesElegidas).obtenerValor(),5);

    }

    @Test
    public void GroupChoiceSinPenalidadDevuelveFalseEnPenalidad(){
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");

        assertFalse(pregunta.conPenalidad());
    }

    @Test
    public void GroupChoiceOpcionesCorrectasSonLasAgregadas() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");

        pregunta.definirGrupo("Flores");
        pregunta.definirGrupo("Animales");

        ArrayList<Grupo> grupos = pregunta.obtenerGrupos();
        pregunta.agregarOpcion(grupos.get(0),"Margarita");
        pregunta.agregarOpcion(grupos.get(0),"Rosa");
        pregunta.agregarOpcion(grupos.get(0),"Jazmin");

        pregunta.agregarOpcion(grupos.get(1),"Perro");
        pregunta.agregarOpcion(grupos.get(1),"Gato");
        pregunta.agregarOpcion(grupos.get(1),"Conejo");
        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opciones.get(0)); // correcta
        opcionesCorrectas.add(opciones.get(2)); // correcta
        opcionesCorrectas.add(opciones.get(4)); // correcta
        opcionesCorrectas.add(opciones.get(7)); // correcta
        opcionesCorrectas.add(opciones.get(9)); // correcta
        opcionesCorrectas.add(opciones.get(11)); // correcta

        assertTrue(pregunta.opcionesCorrectas(opcionesCorrectas));

    }

    @Test
    public void opcionesSeleccionablesSinSeleccionarNingunaDevuelveTodasLasOpciones() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");

        pregunta.definirGrupo("Flores");
        pregunta.definirGrupo("Animales");

        ArrayList<Grupo> grupos = pregunta.obtenerGrupos();

        pregunta.agregarOpcion(grupos.get(0),"Margarita");
        pregunta.agregarOpcion(grupos.get(0),"Rosa");
        pregunta.agregarOpcion(grupos.get(0),"Jazmin");

        pregunta.agregarOpcion(grupos.get(1),"Perro");
        pregunta.agregarOpcion(grupos.get(1),"Gato");
        pregunta.agregarOpcion(grupos.get(1),"Conejo");

        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();

        assertEquals(opciones, pregunta.opcionesSeleccionables(new ArrayList<>()));
    }

    @Test
    public void opcionesSeleccionablesSeleccionandoUnaDevuelveTodasLasOpcionesMenosDos() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");

        pregunta.definirGrupo("Flores");
        pregunta.definirGrupo("Animales");

        ArrayList<Grupo> grupos = pregunta.obtenerGrupos();

        pregunta.agregarOpcion(grupos.get(0),"Margarita");
        pregunta.agregarOpcion(grupos.get(0),"Rosa");
        pregunta.agregarOpcion(grupos.get(0),"Jazmin");

        pregunta.agregarOpcion(grupos.get(1),"Perro");
        pregunta.agregarOpcion(grupos.get(1),"Gato");
        pregunta.agregarOpcion(grupos.get(1),"Conejo");

        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();

        ArrayList<Opcion> seleccionadas = new ArrayList<>();
        seleccionadas.add(opciones.get(0));

        ArrayList<Opcion> opcionesValidas = pregunta.opcionesSeleccionables(seleccionadas);

        // 10 = (6 opciones - 1 seleccionada) * 2 grupos
        assertEquals(10, opcionesValidas.size());
        assertFalse(opcionesValidas.contains(opciones.get(0)));
        assertFalse(opcionesValidas.contains(opciones.get(1)));
    }

    @Test
    public void opcionesSeleccionablesSeleccionandoTodasDevuelveArrayVacio() throws PreguntaError {
        GroupChoice pregunta = new GroupChoice("Seleecione la opcion correcta de cada grupo");

        pregunta.definirGrupo("Flores");
        pregunta.definirGrupo("Animales");

        ArrayList<Grupo> grupos = pregunta.obtenerGrupos();

        pregunta.agregarOpcion(grupos.get(0),"Margarita");
        pregunta.agregarOpcion(grupos.get(0),"Rosa");
        pregunta.agregarOpcion(grupos.get(0),"Jazmin");

        pregunta.agregarOpcion(grupos.get(1),"Perro");
        pregunta.agregarOpcion(grupos.get(1),"Gato");
        pregunta.agregarOpcion(grupos.get(1),"Conejo");

        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();

        ArrayList<Opcion> seleccionadas = new ArrayList<>();
        seleccionadas.add(opciones.get(0));
        seleccionadas.add(opciones.get(3));
        seleccionadas.add(opciones.get(4));
        seleccionadas.add(opciones.get(6));
        seleccionadas.add(opciones.get(9));
        seleccionadas.add(opciones.get(10));

        ArrayList<Opcion> opcionesValidas = pregunta.opcionesSeleccionables(seleccionadas);

        assertEquals(0, opcionesValidas.size());
    }

}
