package com.ird.faa.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "sous_classe_comptable")
public class SousClasseComptable {

    @Id
    @SequenceGenerator(name = "sous_classe_comptable_seq", sequenceName = "sous_classe_comptable_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sous_classe_comptable_seq")
    private Long id;

    private BigDecimal numero;
    @Column(length = 500)
    private String libelle;

    @ManyToOne
    private ClasseComptable classeComptable;

    @OneToMany(mappedBy = "sousClasseComptable")
    private List<CompteComptable> compteComptables;

    public SousClasseComptable() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getNumero() {
        return this.numero;
    }

    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ClasseComptable getClasseComptable() {
        return this.classeComptable;
    }

    public void setClasseComptable(ClasseComptable classeComptable) {
        this.classeComptable = classeComptable;
    }

    public List<CompteComptable> getCompteComptables() {
        return this.compteComptables;
    }

    public void setCompteComptables(List<CompteComptable> compteComptables) {
        this.compteComptables = compteComptables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SousClasseComptable sousClasseComptable = (SousClasseComptable) o;
        return id != null && id.equals(sousClasseComptable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

