package fr.michka.lebonbien.controller;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.dao.TierDAO;
import fr.michka.lebonbien.model.TiersEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private Button deconnexion;
    @FXML
    private Label agentNameLabel;

    private Application application;

    public void initializeHandler(Application application) {
        this.application = application;
        this.switch2Annonces.setOnAction(this.application);
        this.switch2Agents.setOnAction(this.application);
        this.switch2Proprietaires.setOnAction(this.application);
        this.deconnexion.setOnAction(this.application);
        TierDAO tierDAO = new TierDAO();
        TiersEntity currentAgent = tierDAO.findById(this.application.getAgentId());
        agentNameLabel.setText(currentAgent.getNomTiers() + " " + currentAgent.getPrenomTiers());
        System.out.println("Action set !");
    }

    @FXML
    public abstract void initialize();
}
