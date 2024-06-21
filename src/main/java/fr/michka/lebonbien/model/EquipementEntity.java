package fr.michka.lebonbien.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EQUIPEMENT", schema = "michkaDB", catalog = "")
public class EquipementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPEMENT", nullable = false)
    private int idEquipement;
    @Basic
    @Column(name = "LIB_EQUIPEMENT", nullable = false, length = 50)
    private String libEquipement;
    @Basic
    @Column(name = "VALEUR", nullable = false, length = 50)
    private String valeur;
    @Basic
    @Column(name = "ID_BIEN", nullable = false)
    private int idBien;

    public int getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }

    public String getLibEquipement() {
        return libEquipement;
    }

    public void setLibEquipement(String libEquipement) {
        this.libEquipement = libEquipement;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public int getIdBien() {
        return idBien;
    }

    public void setIdBien(int idBien) {
        this.idBien = idBien;
    }
}
