package fr.michka.lebonbien.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.math.BigDecimal;

@Entity
@Table(name = "BIEN", schema = "michkaDB", catalog = "")
@FilterDef(
        name="byIdAgent",
        parameters = @ParamDef(
                name="ID_AGENT",
                type=int.class
        )
)
@Filter(
        name="byIdAgent",
        condition="ID_AGENT = :ID_AGENT"
)
public class BienEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_BIEN", nullable = false)
    private int idBien;
    @Basic
    @Column(name = "LIB_BIEN", nullable = false, length = 50)
    private String libBien;
    @Basic
    @Column(name = "ADR_NO_VOIE", nullable = true, length = 7)
    private String adrNoVoie;
    @Basic
    @Column(name = "NOM_VOIE", nullable = true, length = 100)
    private String nomVoie;
    @Basic
    @Column(name = "CODE_POSTAL", nullable = false, length = 5)
    private String codePostal;
    @Basic
    @Column(name = "COMMUNE", nullable = false, length = 100)
    private String commune;
    @Basic
    @Column(name = "COMPLEMENT_ADRESSE", nullable = true, length = 5)
    private String complementAdresse;
    @Basic
    @Column(name = "ID_PROPRIETAIRE", nullable = false)
    private int idProprietaire;
    @Basic
    @Column(name = "ID_AGENT", nullable = false)
    private int idAgent;
    @Basic
    @Column(name = "SURFACE", nullable = false, precision = 2)
    private BigDecimal surface;
    @Basic
    @Column(name = "NB_PIECES", nullable = false)
    private int nbPieces;
    @Basic
    @Column(name = "NB_CHAMBRES", nullable = false)
    private int nbChambres;
    @Basic
    @Column(name = "NB_SDB", nullable = false)
    private int nbSdb;
    @Basic
    @Column(name = "TYPE", nullable = false, length = 50)
    private String type;

    public int getIdBien() {
        return idBien;
    }

    public void setIdBien(int idBien) {
        this.idBien = idBien;
    }

    public String getLibBien() {
        return libBien;
    }

    public void setLibBien(String libBien) {
        this.libBien = libBien;
    }

    public String getAdrNoVoie() {
        return adrNoVoie;
    }

    public void setAdrNoVoie(String adrNoVoie) {
        this.adrNoVoie = adrNoVoie;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public BigDecimal getSurface() {
        return surface;
    }

    public void setSurface(BigDecimal surface) {
        this.surface = surface;
    }

    public int getNbPieces() {
        return nbPieces;
    }

    public void setNbPieces(int nbPieces) {
        this.nbPieces = nbPieces;
    }

    public int getNbChambres() {
        return nbChambres;
    }

    public void setNbChambres(int nbChambres) {
        this.nbChambres = nbChambres;
    }

    public int getNbSdb() {
        return nbSdb;
    }

    public void setNbSdb(int nbSdb) {
        this.nbSdb = nbSdb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }
}
