package com.ird.faa.bean;

import java.util.Objects;


import java.math.BigDecimal;
import javax.persistence.*;


@Entity
@Table(name = "prelevement_social_employe")
public class PrelevementSocialEmploye {

    @Id
    @SequenceGenerator(name = "prelevement_social_employe_seq", sequenceName = "prelevement_social_employe_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prelevement_social_employe_seq")
    private Long id;

    private BigDecimal salaireBrutImposable;
    private BigDecimal montantCalculer;

    @ManyToOne
    private PrelevementSocial prelevementSocial;
    @ManyToOne
    private Employe employe;
    @ManyToOne
    private DeclarationIr declarationIr;


    public PrelevementSocialEmploye() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PrelevementSocial getPrelevementSocial() {
        return this.prelevementSocial;
    }

    public void setPrelevementSocial(PrelevementSocial prelevementSocial) {
        this.prelevementSocial = prelevementSocial;
    }

    public Employe getEmploye() {
        return this.employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public BigDecimal getSalaireBrutImposable() {
        return this.salaireBrutImposable;
    }

    public void setSalaireBrutImposable(BigDecimal salaireBrutImposable) {
        this.salaireBrutImposable = salaireBrutImposable;
    }

    public BigDecimal getMontantCalculer() {
        return this.montantCalculer;
    }

    public void setMontantCalculer(BigDecimal montantCalculer) {
        this.montantCalculer = montantCalculer;
    }

    public DeclarationIr getDeclarationIr() {
        return this.declarationIr;
    }

    public void setDeclarationIr(DeclarationIr declarationIr) {
        this.declarationIr = declarationIr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrelevementSocialEmploye prelevementSocialEmploye = (PrelevementSocialEmploye) o;
        return id != null && id.equals(prelevementSocialEmploye.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

