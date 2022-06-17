package com.ird.faa.bean;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "type_comptable")
public class TypeComptable {

    @Id
    @SequenceGenerator(name = "type_comptable_seq", sequenceName = "type_comptable_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_comptable_seq")
    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String reference;


    public TypeComptable() {
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

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeComptable typeComptable = (TypeComptable) o;
        return id != null && id.equals(typeComptable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

