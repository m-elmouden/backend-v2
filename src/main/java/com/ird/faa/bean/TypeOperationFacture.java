package com.ird.faa.bean;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "type_operation_facture")
public class TypeOperationFacture {

    @Id
    @SequenceGenerator(name = "type_operation_facture_seq", sequenceName = "type_operation_facture_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_operation_facture_seq")
    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String typeOperationSociete;


    public TypeOperationFacture() {
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

    public String getTypeOperationSociete() {
        return this.typeOperationSociete;
    }

    public void setTypeOperationSociete(String typeOperationSociete) {
        this.typeOperationSociete = typeOperationSociete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOperationFacture typeOperationFacture = (TypeOperationFacture) o;
        return id != null && id.equals(typeOperationFacture.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

