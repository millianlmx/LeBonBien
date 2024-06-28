package fr.michka.lebonbien;

import fr.michka.lebonbien.controller.*;
import fr.michka.lebonbien.dao.AnnonceDAO;
import fr.michka.lebonbien.dao.BienDAO;
import fr.michka.lebonbien.dao.TierDAO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Application extends javafx.application.Application implements EventHandler<ActionEvent> {
    private static final String PERSISTENCE_UNIT_NAME = "MichkaDB";
    private static EntityManagerFactory emf;
    private Stage stage;

    private int agentId;

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getAgentId() {
        return agentId;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        AnnonceDAO.initialize(emf.createEntityManager());
        BienDAO.initialize(emf.createEntityManager());
        TierDAO.initialize(emf.createEntityManager());

        String menuButtonCSS = this.getClass().getResource("material-menu-button.css").toExternalForm();
        FXMLLoader connexionFxmlLoader = new FXMLLoader(Application.class.getResource("connexion.fxml"));
        connexionFxmlLoader.setController(new ConnexionController());
        ((ConnexionController) connexionFxmlLoader.getController()).initializeHandler(this);
        Scene connexionScene = new Scene(connexionFxmlLoader.load());
        connexionScene.getStylesheets().add(menuButtonCSS);
        stage.setScene(connexionScene);
        stage.setTitle("LeBonBien");
        stage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Button clicked");
        if ("switch2Annonces".equals(((Button) actionEvent.getSource()).getId()) || "supprimerAnnonce".equals(((Button) actionEvent.getSource()).getId())) {
            FXMLLoader annonceFxmlLoader = new FXMLLoader(Application.class.getResource("annonces.fxml"));
            AnnonceController controller = new AnnonceController();
            annonceFxmlLoader.setController(controller);
            String menuButtonCSS = Objects.requireNonNull(this.getClass().getResource("material-menu-button.css")).toExternalForm();
            try {
                Scene annonceScene = new Scene(annonceFxmlLoader.load());
                ((AnnonceController) annonceFxmlLoader.getController()).initializeHandler(this);
                annonceScene.getStylesheets().add(menuButtonCSS);
                this.stage.setScene(annonceScene);
                this.stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if ("switch2AgentOnly".equals(((Button) actionEvent.getSource()).getId())) {
            FXMLLoader agentOnlyFxmlLoader = new FXMLLoader(Application.class.getResource("annonces.fxml"));
            AnnonceController controller = new AnnonceController();
            agentOnlyFxmlLoader.setController(controller);
            String menuButtonCSS = Objects.requireNonNull(this.getClass().getResource("material-menu-button.css")).toExternalForm();
            try {
                Scene annonceScene = new Scene(agentOnlyFxmlLoader.load());
                ((Button) annonceScene.lookup("#ajouterAnnonce")).setText("Ajouter un bien");
                ((AnnonceController) agentOnlyFxmlLoader.getController()).setAgentOnly(true, this.getAgentId());
                ((AnnonceController) agentOnlyFxmlLoader.getController()).initializeHandler(this);
                annonceScene.getStylesheets().add(menuButtonCSS);
                this.stage.setScene(annonceScene);
                this.stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if ("switch2Proprietaires".equals(((Button) actionEvent.getSource()).getId())) {
            FXMLLoader proprietairesFxmlLoader = new FXMLLoader(Application.class.getResource("tiers.fxml"));
            proprietairesFxmlLoader.setController(new ProprietaireController());
            String menuButtonCSS = Objects.requireNonNull(this.getClass().getResource("material-menu-button.css")).toExternalForm();
            try {
                Scene proprietaireScene = new Scene(proprietairesFxmlLoader.load());
                ((ProprietaireController) proprietairesFxmlLoader.getController()).initializeHandler(this);
                proprietaireScene.getStylesheets().add(menuButtonCSS);
                this.stage.setScene(proprietaireScene);
                this.stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if ("switch2Agents".equals(((Button) actionEvent.getSource()).getId())) {
            FXMLLoader agentsFxmlLoader = new FXMLLoader(Application.class.getResource("tiers.fxml"));
            agentsFxmlLoader.setController(new AgentController());
            String menuButtonCSS = Objects.requireNonNull(this.getClass().getResource("material-menu-button.css")).toExternalForm();
            try {
                Scene agentScene = new Scene(agentsFxmlLoader.load());
                ((AgentController) agentsFxmlLoader.getController()).initializeHandler(this);
                agentScene.getStylesheets().add(menuButtonCSS);
                this.stage.setScene(agentScene);
                this.stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if ("agentButton".equals(((Button) actionEvent.getSource()).getId())) {
            System.out.println(this.agentId);
            FXMLLoader annonceFxmlLoader = new FXMLLoader(Application.class.getResource("annonces.fxml"));
            AnnonceController controller = new AnnonceController();
            annonceFxmlLoader.setController(controller);
            String menuButtonCSS = Objects.requireNonNull(this.getClass().getResource("material-menu-button.css")).toExternalForm();
            try {
                Scene annonceScene = new Scene(annonceFxmlLoader.load());
                ((AnnonceController) annonceFxmlLoader.getController()).initializeHandler(this);
                annonceScene.getStylesheets().add(menuButtonCSS);
                this.stage.setScene(annonceScene);
                this.stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if ("deconnexion".equals(((Button) actionEvent.getSource()).getId())) {
            String menuButtonCSS = this.getClass().getResource("material-menu-button.css").toExternalForm();
            FXMLLoader connexionFxmlLoader = new FXMLLoader(Application.class.getResource("connexion.fxml"));
            connexionFxmlLoader.setController(new ConnexionController());
            ((ConnexionController) connexionFxmlLoader.getController()).initializeHandler(this);
            try {
                Scene connexionScene = new Scene(connexionFxmlLoader.load());
                connexionScene.getStylesheets().add(menuButtonCSS);
                stage.setScene(connexionScene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if ("ajouterAnnonce".equals(((Button) actionEvent.getSource()).getId())) {
            String menuButtonCSS = this.getClass().getResource("material-menu-button.css").toExternalForm();
            FXMLLoader ajouterFxmlLoader = new FXMLLoader(Application.class.getResource("ajouter-annonce.fxml"));
            ajouterFxmlLoader.setController(new AjouterController());
            ((ConnexionController) ajouterFxmlLoader.getController()).initializeHandler(this);
            try {
                Scene ajouterScene = new Scene(ajouterFxmlLoader.load());
                ajouterScene.getStylesheets().add(menuButtonCSS);
                stage.setScene(ajouterScene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}