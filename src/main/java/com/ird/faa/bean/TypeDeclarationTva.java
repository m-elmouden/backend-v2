package com.ird.faa.bean;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "type_declaration_tva")
public class TypeDeclarationTva {

    @Id
    @SequenceGenerator(name = "type_declaration_tva_seq", sequenceName = "type_declaration_tva_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_declaration_tva_seq")
    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String libelle;


    public TypeDeclarationTva() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDeclarationTva typeDeclarationTva = (TypeDeclarationTva) o;
        return id != null && id.equals(typeDeclarationTva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

