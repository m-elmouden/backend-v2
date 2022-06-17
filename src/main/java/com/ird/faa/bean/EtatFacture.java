package com.ird.faa.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "etat_facture")
public class EtatFacture {

    @Id
    @SequenceGenerator(name = "etat_facture_seq", sequenceName = "etat_facture_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etat_facture_seq")
    private Long id;

    @Column(length = 500)
    private String libelle;
    private BigDecimal code;


    public EtatFacture() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getCode() {
        return this.code;
    }

    public void setCode(BigDecimal code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtatFacture etatFacture = (EtatFacture) o;
        return id != null && id.equals(etatFacture.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

