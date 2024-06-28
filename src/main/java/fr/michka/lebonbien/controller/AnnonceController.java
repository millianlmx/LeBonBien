package fr.michka.lebonbien.controller;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.components.Annonce;
import fr.michka.lebonbien.dao.AnnonceDAO;
import fr.michka.lebonbien.dao.BienDAO;
import fr.michka.lebonbien.dao.TierDAO;
import fr.michka.lebonbien.model.AnnonceEntity;
import fr.michka.lebonbien.model.BienEntity;
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
    @FXML
    private Button ajouterAnnonce;

    private Boolean agentOnly = false;
    private int agentId;

    public void setAgentOnly(Boolean agentOnly, int agentId) {
        this.agentOnly = agentOnly;
        this.agentId = agentId;
    }

    private Application application;

    public void initializeHandler(Application application) {
        this.application = application;
        switch2Proprietaires.setOnAction(this.application);
        switch2AgentOnly.setOnAction(this.application);
        deconnexion.setOnAction(this.application);
        ajouterAnnonce.setOnAction(this.application);
        TierDAO tierDAO = new TierDAO();
        TiersEntity currentAgent = tierDAO.findById(this.application.getAgentId());
        System.out.println("Init !");
        System.out.println(this.application.getAgentId());
        agentNameLabel.setText(currentAgent.getNomTiers() + " " + currentAgent.getPrenomTiers());

        AnnonceDAO annonceDAO = new AnnonceDAO();
        BienDAO bienDAO = new BienDAO();
        System.out.println(this.agentId);

        if(this.agentOnly) {
            BienEntity[] bienEntities = bienDAO.findAllRelatedToAgent(this.agentId);
            for(BienEntity bienEntity : bienEntities) {
                Annonce annonce = new Annonce(null, bienEntity, true);

                annonce.setOnAction(actionEvent -> {
                    System.out.println("Suppression du bien " + annonce.getTitle());
                    bienDAO.delete(bienEntity);
                    this.application.handle(actionEvent);
                }, "switch2AgentOnly");

                annonceGrid.add(
                        annonce.getComponent(),
                        annonceGrid.getChildren().toArray().length % 2,
                        annonceGrid.getChildren().toArray().length / 2
                );
            }
        } else {
            AnnonceEntity[] annonceEntities = annonceDAO.findAll();
            for (AnnonceEntity annonceEntity : annonceEntities) {
                Annonce annonce = new Annonce(annonceEntity, bienDAO.findById(annonceEntity.getIdBien()), false);

                annonce.setOnAction(actionEvent -> {
                    System.out.println("Suppression de l'annonce " + annonce.getTitle());
                    annonceDAO.delete(annonceEntity);
                    this.application.handle(actionEvent);
                }, null);

                annonceGrid.add(
                        annonce.getComponent(),
                        annonceGrid.getChildren().toArray().length % 2,
                        annonceGrid.getChildren().toArray().length / 2
                );
            }
        }
    }

    @FXML
    public void initialize() {

    }
}
