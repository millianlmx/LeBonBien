package fr.michka.lebonbien;

import fr.michka.lebonbien.dao.AnnonceDAO;
import fr.michka.lebonbien.model.AnnonceEntity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        // Créer une annonce
        AnnonceDAO annonceDAO = new AnnonceDAO();
        annonceDAO.create(new AnnonceEntity(0, new Date(System.currentTimeMillis()), 7, 12, 6, "Test", "Description", new BigDecimal(590)));

    }

    public static void main(String[] args) {
        launch();
    }
}