package fr.michka.lebonbien.controller;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.components.Annonce;
import fr.michka.lebonbien.components.Proprietaire;
import fr.michka.lebonbien.dao.AnnonceDAO;
import fr.michka.lebonbien.dao.BienDAO;
import fr.michka.lebonbien.dao.TierDAO;
import fr.michka.lebonbien.model.AnnonceEntity;
import fr.michka.lebonbien.model.TiersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AnnonceController {
    @FXML
    private GridPane annonceGrid;

    private Application application;

    public void initializeHandler(Application application) {
        this.application = application;
        switch2Proprietaires.setOnAction(this.application);
    }
    @FXML
    private Button switch2Proprietaires;
    @FXML
    public void initialize() {
        System.out.println("Adding annonce data !");

        switch2Proprietaires.setOnAction(this.application);

        AnnonceDAO annonceDAO = new AnnonceDAO();
        BienDAO bienDAO = new BienDAO();
        AnnonceEntity[] annonceEntities = annonceDAO.findAll();
        System.out.println("All annonce finded !");
        for (AnnonceEntity annonceEntity : annonceEntities) {
            annonceGrid.add(
                    new Annonce(annonceEntity, bienDAO.findById(annonceEntity.getIdBien())).getComponent(),
                    annonceGrid.getChildren().toArray().length % 2,
                    annonceGrid.getChildren().toArray().length / 2
            );
        }
    }
}
