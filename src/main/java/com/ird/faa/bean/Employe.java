package com.ird.faa.bean;

import java.util.Objects;


import java.math.BigDecimal;
import javax.persistence.*;


@Entity
@Table(name = "employe")
public class Employe {

    @Id
    @SequenceGenerator(name = "employe_seq", sequenceName = "employe_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employe_seq")
    private Long id;

    @Column(length = 500)
    private String cin;
    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;
    private BigDecimal totalSalaireNet;
    private BigDecimal nombreFamille;

    @ManyToOne
    private TypeEmploye typeEmploye;
    @ManyToOne
    private Societe societe;
    @ManyToOne
    private DeclarationCnss declarationCnss;


    public Employe() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public TypeEmploye getTypeEmploye() {
        return this.typeEmploye;
    }

    public void setTypeEmploye(TypeEmploye typeEmploye) {
        this.typeEmploye = typeEmploye;
    }

    public BigDecimal getTotalSalaireNet() {
        return this.totalSalaireNet;
    }

    public void setTotalSalaireNet(BigDecimal totalSalaireNet) {
        this.totalSalaireNet = totalSalaireNet;
    }

    public Societe getSociete() {
        return this.societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public BigDecimal getNombreFamille() {
        return this.nombreFamille;
    }

    public void setNombreFamille(BigDecimal nombreFamille) {
        this.nombreFamille = nombreFamille;
    }

    public DeclarationCnss getDeclarationCnss() {
        return this.declarationCnss;
    }

    public void setDeclarationCnss(DeclarationCnss declarationCnss) {
        this.declarationCnss = declarationCnss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return id != null && id.equals(employe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

