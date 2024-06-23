package fr.michka.lebonbien.controller;

import fr.michka.lebonbien.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public abstract class TierController {
    @FXML
    private GridPane tiersGrid;
    @FXML
    private Button switch2Annonces;
    @FXML
    private Button switch2Agents;
    @FXML
    private Button switch2Proprietaires;

    private Application application;

    public void initializeHandler(Application application) {
        this.application = application;
        this.switch2Annonces.setOnAction(this.application);
        this.switch2Agents.setOnAction(this.application);
        this.switch2Proprietaires.setOnAction(this.application);
        System.out.println("Action set !");
    }

    @FXML
    public abstract void initialize();
}
