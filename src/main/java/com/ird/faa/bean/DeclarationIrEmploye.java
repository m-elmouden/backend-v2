package com.ird.faa.bean;

import java.util.Objects;


import java.math.BigDecimal;
import javax.persistence.*;


@Entity
@Table(name = "declaration_ir_employe")
public class DeclarationIrEmploye {

    @Id
    @SequenceGenerator(name = "declaration_ir_employe_seq", sequenceName = "declaration_ir_employe_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "declaration_ir_employe_seq")
    private Long id;

    private BigDecimal salaireNet;
    private BigDecimal salaireBrut;
    private BigDecimal salaireNetImposable;
    private BigDecimal salaireBrutImposable;
    private BigDecimal salaireBase;
    private BigDecimal indemniteJustifie;
    private BigDecimal indemnite;
    private BigDecimal primes;
    private BigDecimal pourcentageAnciennete;
    private BigDecimal cotisation;
    private BigDecimal avantage;
    private BigDecimal heuresSupplementaires;

    public BigDecimal getIndemnite() {
        return indemnite;
    }

    public void setIndemnite(BigDecimal indemnite) {
        this.indemnite = indemnite;
    }

    public BigDecimal getAvantage() {
        return avantage;
    }

    public void setAvantage(BigDecimal avantage) {
        this.avantage = avantage;
    }

    public BigDecimal getheuresSupplementaires() {
        return heuresSupplementaires;
    }

    public void setheuresSupplementaires(BigDecimal heuresSupplementaires) {
        this.heuresSupplementaires = heuresSupplementaires;
    }

    @ManyToOne
    private DeclarationIr declarationIr;
    @ManyToOne
    private Employe employe;
    @ManyToOne
    private TauxIr tauxIr;


    public DeclarationIrEmploye() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeclarationIr getDeclarationIr() {
        return this.declarationIr;
    }

    public void setDeclarationIr(DeclarationIr declarationIr) {
        this.declarationIr = declarationIr;
    }

    public Employe getEmploye() {
        return this.employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public BigDecimal getSalaireNet() {
        return this.salaireNet;
    }

    public void setSalaireNet(BigDecimal salaireNet) {
        this.salaireNet = salaireNet;
    }

    public BigDecimal getSalaireBrut() {
        return this.salaireBrut;
    }

    public void setSalaireBrut(BigDecimal salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public BigDecimal getSalaireNetImposable() {
        return this.salaireNetImposable;
    }

    public void setSalaireNetImposable(BigDecimal salaireNetImposable) {
        this.salaireNetImposable = salaireNetImposable;
    }

    public BigDecimal getSalaireBrutImposable() {
        return this.salaireBrutImposable;
    }

    public void setSalaireBrutImposable(BigDecimal salaireBrutImposable) {
        this.salaireBrutImposable = salaireBrutImposable;
    }

    public BigDecimal getSalaireBase() {
        return this.salaireBase;
    }

    public void setSalaireBase(BigDecimal salaireBase) {
        this.salaireBase = salaireBase;
    }

    public BigDecimal getindemniteJustifie() {
        return this.indemniteJustifie;
    }

    public void setindemniteJustifie(BigDecimal indemniteJustifie) {
        this.indemniteJustifie = indemniteJustifie;
    }

    public BigDecimal getPrimes() {
        return this.primes;
    }

    public void setPrimes(BigDecimal primes) {
        this.primes = primes;
    }

    public BigDecimal getPourcentageAnciennete() {
        return this.pourcentageAnciennete;
    }

    public void setPourcentageAnciennete(BigDecimal pourcentageAnciennete) {
        this.pourcentageAnciennete = pourcentageAnciennete;
    }

    public TauxIr getTauxIr() {
        return this.tauxIr;
    }

    public void setTauxIr(TauxIr tauxIr) {
        this.tauxIr = tauxIr;
    }

    public BigDecimal getCotisation() {
        return this.cotisation;
    }

    public void setCotisation(BigDecimal cotisation) {
        this.cotisation = cotisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationIrEmploye declarationIrEmploye = (DeclarationIrEmploye) o;
        return id != null && id.equals(declarationIrEmploye.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

