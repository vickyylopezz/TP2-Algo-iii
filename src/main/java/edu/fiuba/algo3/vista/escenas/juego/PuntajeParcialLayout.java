package edu.fiuba.algo3.vista.escenas.juego;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.util.punto.Punto;
import edu.fiuba.algo3.vista.Resources;
import edu.fiuba.algo3.vista.componentes.contenedores.CajaVista;
import edu.fiuba.algo3.vista.escenas.BaseLayout;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PuntajeParcialLayout extends BaseLayout {

    private final Stage escenario;

    public PuntajeParcialLayout(Stage stage, ArrayList<Jugador> jugadores) {
        this.escenario = stage;
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);
        Node cuerpo = this.crearCuerpo(jugador1, jugador2);
        this.setCenter(cuerpo);
    }

    private Node crearCuerpo(Jugador jugador1, Jugador jugador2) {
        VBox vbox1 = new VBox(50);

        Group contenedorIcono1 = new Group();
        try {
            FileInputStream stream = new FileInputStream(Resources.IconoJugadorBlancoRuta());
            ImageView icono1 = new ImageView(new Image(stream));
            icono1.setFitHeight(150);

            icono1.setPreserveRatio(true);

            contenedorIcono1.getChildren().add(icono1);
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        Label jLabelNombreJugador1 = new Label(jugador1.nombre());
        jLabelNombreJugador1.setStyle("-fx-text-fill: #9A31E1; -fx-font-size: 30; -fx-font-weight: bold");
        jLabelNombreJugador1.setAlignment(Pos.CENTER);
        Punto puntaje1 = jugador1.puntajeTotal();
        Label jLabelPuntos1 = new Label(puntaje1.obtenerValor().toString());
        jLabelPuntos1.setStyle("-fx-text-fill: #9A31E1; -fx-font-size: 24; -fx-font-weight: bold");
        jLabelPuntos1.setAlignment(Pos.CENTER);
        vbox1.getChildren().addAll(contenedorIcono1, jLabelNombreJugador1, jLabelPuntos1);
        vbox1.setAlignment(Pos.CENTER);

        VBox vbox2 = new VBox(50);

        Group contenedorIcono2 = new Group();
        try {
            FileInputStream stream = new FileInputStream(Resources.IconoJugadorBlancoRuta());
            ImageView icono2 = new ImageView(new Image(stream));
            icono2.setFitHeight(150);

            icono2.setPreserveRatio(true);

            contenedorIcono2.getChildren().add(icono2);
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        Label jLabelNombreJugador2 = new Label(jugador2.nombre());
        jLabelNombreJugador2.setStyle("-fx-text-fill: #9A31E1; -fx-font-size: 30; -fx-font-weight: bold");
        jLabelNombreJugador2.setAlignment(Pos.CENTER);
        Punto puntaje2 = jugador2.puntajeTotal();
        Label jLabelPuntos2 = new Label(puntaje2.obtenerValor().toString());
        jLabelPuntos2.setStyle("-fx-text-fill: #9A31E1; -fx-font-size: 24; -fx-font-weight: bold");
        jLabelPuntos2.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(contenedorIcono2, jLabelNombreJugador2, jLabelPuntos2);
        vbox2.setAlignment(Pos.CENTER);

        CajaVista caja1 = new CajaVista();
        caja1.setCenter(vbox1);
        caja1.setPadding(new Insets(50));

        CajaVista caja2 = new CajaVista();
        caja2.setCenter(vbox2);
        caja2.setPadding(new Insets(50));

        HBox hbox = new HBox(200);
        hbox.getChildren().addAll(caja1, caja2);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(50));

        return hbox;
    }


}
