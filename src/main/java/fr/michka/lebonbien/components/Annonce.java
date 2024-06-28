package fr.michka.lebonbien.components;

import fr.michka.lebonbien.Application;
import fr.michka.lebonbien.model.AnnonceEntity;
import fr.michka.lebonbien.model.BienEntity;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Annonce {
    private String title;
    private double price;
    private double area;

    private final AnchorPane component;

    public void setOnAction(EventHandler<ActionEvent> eventHandler, String id) {
        if (id != null) {
            ((Button) this.component.lookup("#"+ id)).setOnAction(eventHandler);
        } else {
            ((Button) this.component.lookup("#supprimerAnnonce")).setOnAction(eventHandler);
        }

    }

    public Annonce(String title, int price, int area) {
        this.title = title;
        this.price = price;
        this.area = area;
        FXMLLoader annonceFxmlLoader = new FXMLLoader(Application.class.getResource("annonce.fxml"));
        AnchorPane annoncePane = null;
        try {
            annoncePane = annonceFxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ((Label) annoncePane.lookup("#title")).setText(title);
        ((Label) annoncePane.lookup("#area")).setText(String.valueOf(area));
        ((Label) annoncePane.lookup("#price")).setText(String.valueOf(price) + "€");
        this.component = annoncePane;
    }

    public Annonce(AnnonceEntity annonceEntity, BienEntity bienEntity, Boolean agentOnly) {
        FXMLLoader annonceFxmlLoader = new FXMLLoader(Application.class.getResource("annonce.fxml"));
        AnchorPane annoncePane = null;
        try {
            annoncePane = annonceFxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!agentOnly) {
            this.title = annonceEntity.getTitre();
            this.price = annonceEntity.getPrix().doubleValue();
            this.area = bienEntity.getSurface().doubleValue();
        } else {
            this.title = "ID : " + bienEntity.getIdBien();
            this.area = bienEntity.getSurface().doubleValue();
            this.price = 0;
            annoncePane.lookup("#supprimerAnnonce").setId("switch2AgentOnly");
        }

        ((Label) annoncePane.lookup("#title")).setText(title);
        ((Label) annoncePane.lookup("#area")).setText(area + "m²");
        ((Label) annoncePane.lookup("#price")).setText("N/A €");
        this.component = annoncePane;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public AnchorPane getComponent() {
        return component;
    }
}
