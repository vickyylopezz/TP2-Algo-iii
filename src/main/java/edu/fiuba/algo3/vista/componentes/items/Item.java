package edu.fiuba.algo3.vista.componentes.items;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class Item extends HBox {

    public Item() {
        this.cargarEstilo();
    }

    private void cargarEstilo() {
        String estilo = "-fx-border-width: 0 0 1 0;";
        estilo += "-fx-border-color: grey;";
        estilo += "-fx-border-style: solid;";
        this.setStyle(estilo);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);
    }

}
