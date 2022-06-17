package com.ird.faa.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "compte_comptable")
public class CompteComptable {

    @Id
    @SequenceGenerator(name = "compte_comptable_seq", sequenceName = "compte_comptable_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compte_comptable_seq")
    private Long id;

    @Column(length = 500)
    private String libelle;
    private BigDecimal numero;

    @ManyToOne
    private SousClasseComptable sousClasseComptable;


    public CompteComptable() {
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

    public BigDecimal getNumero() {
        return this.numero;
    }

    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }

    public SousClasseComptable getSousClasseComptable() {
        return this.sousClasseComptable;
    }

    public void setSousClasseComptable(SousClasseComptable sousClasseComptable) {
        this.sousClasseComptable = sousClasseComptable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompteComptable compteComptable = (CompteComptable) o;
        return id != null && id.equals(compteComptable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

