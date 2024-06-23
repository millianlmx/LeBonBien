package fr.michka.lebonbien.components;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.model.TiersEntity;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class Proprietaire {
    private String name;
    private final AnchorPane component;

    public Proprietaire(String name) {
        this.name = name;
        FXMLLoader annonceFxmlLoader = new FXMLLoader(Application.class.getResource("tier.fxml"));
        AnchorPane annoncePane = null;
        try {
            annoncePane = annonceFxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ((Label) annoncePane.lookup("#holderName")).setText(name);
        this.component = annoncePane;
    }

    public Proprietaire(TiersEntity tiersEntity) {
        this.name = tiersEntity.getNomTiers() + " " + tiersEntity.getPrenomTiers();
        FXMLLoader annonceFxmlLoader = new FXMLLoader(Application.class.getResource("tier.fxml"));
        AnchorPane annoncePane = null;
        try {
            annoncePane = annonceFxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ((Label) annoncePane.lookup("#holderName")).setText(name);
        this.component = annoncePane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnchorPane getComponent() {
        return component;
    }
}
