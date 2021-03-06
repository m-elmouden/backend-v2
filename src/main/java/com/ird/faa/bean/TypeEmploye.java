package com.ird.faa.bean;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "type_employe")
public class TypeEmploye {

    @Id
    @SequenceGenerator(name = "type_employe_seq", sequenceName = "type_employe_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_employe_seq")
    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;


    public TypeEmploye() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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
        TypeEmploye typeEmploye = (TypeEmploye) o;
        return id != null && id.equals(typeEmploye.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

