package fr.michka.lebonbien.controller;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.components.Annonce;
import fr.michka.lebonbien.dao.AnnonceDAO;
import fr.michka.lebonbien.dao.BienDAO;
import fr.michka.lebonbien.dao.TierDAO;
import fr.michka.lebonbien.model.AnnonceEntity;
import fr.michka.lebonbien.model.TiersEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AnnonceController {
    @FXML
    private GridPane annonceGrid;
    @FXML
    private Button deconnexion;
    @FXML
    private Button switch2Proprietaires;
    @FXML
    private Button switch2AgentOnly;
    @FXML
    private Label agentNameLabel;

    private Boolean agentOnly = false;

    public void setAgentOnly(Boolean agentOnly) {
        this.agentOnly = agentOnly;
    }

    private Application application;

    public void initializeHandler(Application application) {
        this.application = application;
        switch2Proprietaires.setOnAction(this.application);
        switch2AgentOnly.setOnAction(this.application);
        deconnexion.setOnAction(this.application);
        TierDAO tierDAO = new TierDAO();
        TiersEntity currentAgent = tierDAO.findById(this.application.getAgentId());
        agentNameLabel.setText(currentAgent.getNomTiers() + " " + currentAgent.getPrenomTiers());
    }

    @FXML
    public void initialize() {
        AnnonceDAO annonceDAO = new AnnonceDAO();
        BienDAO bienDAO = new BienDAO();
        AnnonceEntity[] annonceEntities = this.agentOnly ? annonceDAO.findAllRelatedToAgent(this.application.getAgentId()) : annonceDAO.findAll();
        for (AnnonceEntity annonceEntity : annonceEntities) {
            annonceGrid.add(
                    new Annonce(annonceEntity, bienDAO.findById(annonceEntity.getIdBien())).getComponent(),
                    annonceGrid.getChildren().toArray().length % 2,
                    annonceGrid.getChildren().toArray().length / 2
            );
        }
    }
}
