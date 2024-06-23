package fr.michka.lebonbien.controller;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.components.Proprietaire;
import fr.michka.lebonbien.dao.TierDAO;
import fr.michka.lebonbien.model.TiersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProprietaireController extends TierController{
    @FXML
    private GridPane tiersGrid;
    @FXML
    private Button switch2Annonces;
    @FXML
    private Button switch2Agents;
    @FXML
    private Button switch2Proprietaires;

    private Application application;

    @FXML
    @Override
    public void initialize() {
        TierDAO tierDAO = new TierDAO();
        TiersEntity[] tiersEntities = tierDAO.findallProprietaires();
        for (TiersEntity tiersEntity : tiersEntities) {
            tiersGrid.add(
                    new Proprietaire(tiersEntity).getComponent(),
                    tiersGrid.getChildren().toArray().length % 3,
                    tiersGrid.getChildren().toArray().length / 3
            );
        }
    }
}
