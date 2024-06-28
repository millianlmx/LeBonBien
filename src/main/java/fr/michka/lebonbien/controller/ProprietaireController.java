package fr.michka.lebonbien.controller;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.components.Tier;
import fr.michka.lebonbien.dao.TierDAO;
import fr.michka.lebonbien.model.TiersEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ProprietaireController extends TierController{
    @FXML
    private GridPane tiersGrid;
    @FXML
    private Button switch2Annonces;
    @FXML
    private Button switch2Agents;
    @FXML
    private Button switch2Proprietaires;
    @FXML
    private Button deconnexion;
    @FXML
    private Label agentNameLabel;
    @FXML
    private Label holderId;

    private Application application;

    @FXML
    @Override
    public void initialize() {
        TierDAO tierDAO = new TierDAO();
        TiersEntity[] tiersEntities = tierDAO.findallProprietaires();
        for (TiersEntity tiersEntity : tiersEntities) {
            tiersGrid.add(
                    new Tier(tiersEntity).getComponent(),
                    tiersGrid.getChildren().toArray().length % 3,
                    tiersGrid.getChildren().toArray().length / 3
            );
        }
    }
}
