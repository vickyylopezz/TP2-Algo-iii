package edu.fiuba.algo3.vista.componentes.botones;

import edu.fiuba.algo3.vista.CargadorResources;
import edu.fiuba.algo3.vista.Resources;
import edu.fiuba.algo3.vista.Tema;
import edu.fiuba.algo3.vista.componentes.contenedores.EtiquetaVista;
import edu.fiuba.algo3.vista.componentes.textos.MiniTexto;
import edu.fiuba.algo3.vista.componentes.textos.Texto;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class BotonEtiquetaIzquierdaVista extends StackPane {

    private EtiquetaVista etiqueta;
    private BotonCircularVista boton;

    public BotonEtiquetaIzquierdaVista(String titulo) {
        this.etiqueta = new EtiquetaVista(Texto.Negrita(titulo));
        this.boton = new BotonCircularVista(new ImageView(
                CargadorResources.obtenerImagen(Resources.IconoFlechaDerechaRuta())
        ));
        this.cargarEstilo();

        this.getChildren().addAll(this.etiqueta, this.boton);
    }

    private void cargarEstilo() {
        this.setAlignment(Pos.CENTER_RIGHT);
        this.boton.setTextFill(Tema.ColorBotonPrincipalTexto);

        etiqueta.setTranslateX(-10);
        etiqueta.setAlignment(Pos.CENTER_LEFT);
    }

    public ObjectProperty<EventHandler<ActionEvent>> onActionProperty () { return this.boton.onActionProperty(); }

    public EventHandler<ActionEvent> getOnAction() { return this.boton.getOnAction(); }

    public void setOnAction(EventHandler<ActionEvent> evento) { this.boton.setOnAction(evento); }

    public void activar() {
        this.boton.activar();
        this.etiqueta.setVisible(true);
    }

    public void desactivar() {
        this.boton.desactivar();
        this.etiqueta.setVisible(false);
    }
}
