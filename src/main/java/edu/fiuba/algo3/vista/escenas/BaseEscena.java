package edu.fiuba.algo3.vista.escenas;

import edu.fiuba.algo3.vista.CargadorResources;
import edu.fiuba.algo3.vista.Resources;
import edu.fiuba.algo3.vista.componentes.ContenedorSonido;
import edu.fiuba.algo3.vista.componentes.botones.BotonEtiquetaDerechaVista;
import edu.fiuba.algo3.vista.componentes.botones.BotonEtiquetaIzquierdaVista;
import edu.fiuba.algo3.vista.componentes.cabeceras.CabeceraKahootVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;

public abstract class BaseEscena extends Scene {

    protected final BorderPane raiz;
    protected final CabeceraKahootVista cabecera;
    protected BotonEtiquetaIzquierdaVista botonSigueinte;
    protected BotonEtiquetaDerechaVista botonAnterior;

    public BaseEscena(MediaPlayer reproductor) {
        super(new Label("Loading"), 1280, 720);

        this.raiz = new BorderPane();
        this.cabecera = new CabeceraKahootVista();

        this.raiz.setTop(this.cabecera);
        this.setRoot(this.raiz);
        ContenedorSonido botoneraSonido = new ContenedorSonido(reproductor);
        this.raiz.setBottom(botoneraSonido.obtenerNodo());

        Image fondo = CargadorResources.obtenerImagen(Resources.FondoPrincipalRuta());
        if (fondo != null) {
            this.raiz.setBackground(new Background(new BackgroundImage(
                    fondo,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(100, 100, true, true, true, true)
            )));
        }
    }

    public void eventoSiguiente(EventHandler<ActionEvent> evento) {
        this.eventoSiguiente(evento, null);
    }

    public void eventoAnterior(EventHandler<ActionEvent> evento) {
        this.eventoAnterior(evento, null);
    }

    public void eventoSiguiente(EventHandler<ActionEvent> evento, String titulo) {
        this.botonSigueinte = null;

        if (evento == null) this.cabecera.definirPanelDerecho(null);

        String tituloBoton = (titulo != null) ? titulo : "Siguiente";
        this.botonSigueinte = new BotonEtiquetaIzquierdaVista(tituloBoton);
        this.botonSigueinte.setOnAction(evento);
        this.cabecera.definirPanelDerecho(this.botonSigueinte);
        this.botonSigueinteDefinido();
    }

    public void eventoAnterior(EventHandler<ActionEvent> evento, String titulo) {
        this.botonAnterior = null;

        if (evento == null) this.cabecera.definirPanelIzquierdo(null);

        String tituloBoton = (titulo != null) ? titulo : "Volver";
        this.botonAnterior = new BotonEtiquetaDerechaVista(tituloBoton);
        this.botonAnterior.setOnAction(evento);
        this.cabecera.definirPanelIzquierdo(this.botonAnterior);
        this.botonAnteriorDefinido();
    }

    protected void botonSigueinteDefinido() { }

    protected void botonAnteriorDefinido() { }
}
