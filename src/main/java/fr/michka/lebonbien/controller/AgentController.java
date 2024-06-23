package fr.michka.lebonbien.controller;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.components.Proprietaire;
import fr.michka.lebonbien.dao.TierDAO;
import fr.michka.lebonbien.model.TiersEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    private Application application;

    @FXML
    @Override
    public void initialize() {
        TierDAO tierDAO = new TierDAO();
        TiersEntity[] tiersEntities = tierDAO.findallAgents();
        for (TiersEntity tiersEntity : tiersEntities) {
            tiersGrid.add(
                    new Proprietaire(tiersEntity).getComponent(),
                    tiersGrid.getChildren().toArray().length % 3,
                    tiersGrid.getChildren().toArray().length / 3
            );
        }
    }
}
