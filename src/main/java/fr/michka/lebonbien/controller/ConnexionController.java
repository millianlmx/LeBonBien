package fr.michka.lebonbien.controller;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.components.Tier;
import fr.michka.lebonbien.dao.TierDAO;
import fr.michka.lebonbien.model.TiersEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ConnexionController {
    @FXML
    private GridPane agentsGrid;

    private Application application;

    public void initializeHandler(Application application) {
        this.application = application;
        System.out.println("Action set !");
    }

    @FXML
    public void initialize() {
        TierDAO tierDAO = new TierDAO();
        TiersEntity[] tiersEntities = tierDAO.findallAgents();
        for (TiersEntity tiersEntity : tiersEntities) {
            Tier tier = new Tier(tiersEntity);

            tier.setOnAction(actionEvent -> {
                System.out.println("Conncecting to " + tier.getName());
                this.application.setAgentId(tiersEntity.getIdTiers());
                this.application.handle(actionEvent);
            });

            this.agentsGrid.add(
                    tier.getComponent(),
                    this.agentsGrid.getChildren().toArray().length % 3,
                    this.agentsGrid.getChildren().toArray().length / 3
            );
        }
    }
}
