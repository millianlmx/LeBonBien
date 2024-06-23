package fr.michka.lebonbien.components;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.model.TiersEntity;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class Tier {
    private String name;
    private final AnchorPane component;

    public void setOnAction(EventHandler<ActionEvent> eventHandler) {
        ((Button) this.component.lookup("#agentButton")).setOnAction(eventHandler);
    }

    public Tier(String name) {
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

    public Tier(TiersEntity tiersEntity) {
        this.name = tiersEntity.getNomTiers() + " " + tiersEntity.getPrenomTiers();
        FXMLLoader tierFxmlLoader = new FXMLLoader(Application.class.getResource("tier.fxml"));
        AnchorPane tierPane = null;
        try {
            tierPane = tierFxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ((Label) tierPane.lookup("#holderName")).setText(name);
        this.component = tierPane;
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
