package fr.michka.lebonbien.controller;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.components.Tier;
import fr.michka.lebonbien.dao.TierDAO;
import fr.michka.lebonbien.model.TiersEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
public class AgentController extends TierController {
    @FXML
    private GridPane tiersGrid;
    @FXML
    private Button switch2Annonces;
    @FXML
    private Button switch2Proprietaires;
    @FXML
    private Button switch2Agents;
    @FXML
    private Button deconnexion;
    @FXML
    private Label listOf;
    @FXML
    private Button ajouterTierButton;
    @FXML
    private Label agentNameLabel;

    private Application application;

    @FXML
    @Override
    public void initialize() {
        listOf.setText("Liste des agents :");
        ajouterTierButton.setText("Ajouter un agent");
        TierDAO tierDAO = new TierDAO();
        TiersEntity[] tiersEntities = tierDAO.findallAgents();
        for (TiersEntity tiersEntity : tiersEntities) {
            tiersGrid.add(
                    new Tier(tiersEntity).getComponent(),
                    tiersGrid.getChildren().toArray().length % 3,
                    tiersGrid.getChildren().toArray().length / 3
            );
        }
    }
}
