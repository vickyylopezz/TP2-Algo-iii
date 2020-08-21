package edu.fiuba.algo3;

import edu.fiuba.algo3.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.excepciones.punto.PuntoError;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws PuntoError {
        stage.setMinHeight(800);
        stage.setMinWidth(1280);

        Kahoot app = new Kahoot(stage);
        app.iniciar();
    }

    public static void main(String[] args) {
        launch();
    }
}