package fr.michka.lebonbien.controller;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.model.AnnonceEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Date;

public class AjouterController {
    @FXML
    private TextField titreAnnonce;
    @FXML
    private TextField loyer;
    @FXML
    private TextField superficie;
    @FXML
    private TextArea description;
    @FXML
    private TextField proprietaireId;
    @FXML
    private TextField bienId;
    @FXML
    private Button publier;
    @FXML
    private Button switch2Annonces;

    public void initializeHandler(Application application) {
        switch2Annonces.setOnAction(application);
        publier.setOnAction(actionEvent -> {
            //AnnonceEntity annonce = new AnnonceEntity(99, , String.valueOf(bienId.getText()), String.valueOf(application.getAgentId()), String.valueOf(proprietaireId.getText()), titreAnnonce.getText(), description.getText());
        });
    }

    @FXML
    public void initialize() {

    }


}
