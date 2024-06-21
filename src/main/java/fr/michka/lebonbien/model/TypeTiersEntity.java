package fr.michka.lebonbien.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TYPE_TIERS", schema = "michkaDB", catalog = "")
public class TypeTiersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TYPE_TIERS", nullable = false)
    private int idTypeTiers;
    @Basic
    @Column(name = "LIB_TYPE_TIERS", nullable = false, length = 100)
    private String libTypeTiers;

    public int getIdTypeTiers() {
        return idTypeTiers;
    }

    public void setIdTypeTiers(int idTypeTiers) {
        this.idTypeTiers = idTypeTiers;
    }

    public String getLibTypeTiers() {
        return libTypeTiers;
    }

    public void setLibTypeTiers(String libTypeTiers) {
        this.libTypeTiers = libTypeTiers;
    }
}
