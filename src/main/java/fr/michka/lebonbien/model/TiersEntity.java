package fr.michka.lebonbien.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TIERS", schema = "michkaDB", catalog = "")
public class TiersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TIERS", nullable = false)
    private int idTiers;
    @Basic
    @Column(name = "NOM_TIERS", nullable = false, length = 100)
    private String nomTiers;
    @Basic
    @Column(name = "PRENOM_TIERS", nullable = true, length = 100)
    private String prenomTiers;
    @Basic
    @Column(name = "TEL_TIERS", nullable = false, length = 10)
    private String telTiers;
    @Basic
    @Column(name = "MAIL_TIERS", nullable = true, length = 100)
    private String mailTiers;
    @Basic
    @Column(name = "TYPE_TIERS", nullable = false)
    private int typeTiers;

    public int getIdTiers() {
        return idTiers;
    }

    public void setIdTiers(int idTiers) {
        this.idTiers = idTiers;
    }

    public String getNomTiers() {
        return nomTiers;
    }

    public void setNomTiers(String nomTiers) {
        this.nomTiers = nomTiers;
    }

    public String getPrenomTiers() {
        return prenomTiers;
    }

    public void setPrenomTiers(String prenomTiers) {
        this.prenomTiers = prenomTiers;
    }

    public String getTelTiers() {
        return telTiers;
    }

    public void setTelTiers(String telTiers) {
        this.telTiers = telTiers;
    }

    public String getMailTiers() {
        return mailTiers;
    }

    public void setMailTiers(String mailTiers) {
        this.mailTiers = mailTiers;
    }

    public int getTypeTiers() {
        return typeTiers;
    }

    public void setTypeTiers(int typeTiers) {
        this.typeTiers = typeTiers;
    }
}
