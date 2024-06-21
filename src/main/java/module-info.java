module fr.michka.lebonbien {
    requires java.naming;
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens fr.michka.lebonbien to javafx.fxml;
    opens fr.michka.lebonbien.model to org.hibernate.orm.core;
    exports fr.michka.lebonbien;
}