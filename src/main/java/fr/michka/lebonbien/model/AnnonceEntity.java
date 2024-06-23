package fr.michka.lebonbien.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "ANNONCE", schema = "michkaDB")
@FilterDef(
        name="byAgent",
        parameters = @ParamDef(
                name="ID_AGENT",
                type=int.class
        )
)
@Filter(
        name="byAgent",
        condition="ID_AGENT = :ID_AGENT"
)
public class AnnonceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ANNONCE", nullable = false)
    private int idAnnonce;
    @Basic
    @Column(name = "DATE_ANNONCE", nullable = false)
    private Date dateAnnonce;
    @Basic
    @Column(name = "ID_BIEN", nullable = false)
    private int idBien;
    @Basic
    @Column(name = "ID_AGENT", nullable = false)
    private int idAgent;
    @Basic
    @Column(name = "ID_PROPRIETAIRE", nullable = false)
    private int idProprietaire;
    @Basic
    @Column(name = "TITRE", nullable = false, length = -1)
    private String titre;
    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "PRIX", nullable = false, precision = 2)
    private BigDecimal prix;

    public AnnonceEntity(int idAnnonce, Date dateAnnonce, int idBien, int idAgent, int idProprietaire, String titre, String description, BigDecimal prix) {
        this.idAnnonce = idAnnonce;
        this.dateAnnonce = dateAnnonce;
        this.idBien = idBien;
        this.idAgent = idAgent;
        this.idProprietaire = idProprietaire;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
    }

    public AnnonceEntity() {

    }

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public Date getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(Date dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }

    public int getIdBien() {
        return idBien;
    }

    public void setIdBien(int idBien) {
        this.idBien = idBien;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
}
