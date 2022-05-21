package com.ird.faa.bean;

import java.util.Objects;


import java.math.BigDecimal;
import javax.persistence.*;


@Entity
@Table(name = "declaration_ir_employe")
public class DeclarationIrEmploye {

    @Id
    @SequenceGenerator(name = "declaration_ir_employe_seq", sequenceName = "declaration_ir_employe_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "declaration_ir_employe_seq")
    private Long id;

    private BigDecimal salaireNet=BigDecimal.ZERO;
    private BigDecimal salaireBrut=BigDecimal.ZERO;
    private BigDecimal salaireNetImposable=BigDecimal.ZERO;
    private BigDecimal salaireBrutImposable=BigDecimal.ZERO;
    private BigDecimal salaireBase=BigDecimal.ZERO;
    private BigDecimal indemniteJustifie=BigDecimal.ZERO;
    private BigDecimal indemnite=BigDecimal.ZERO;
    private BigDecimal primes=BigDecimal.ZERO;
    private BigDecimal pourcentageAnciennete=BigDecimal.ZERO;
    private BigDecimal cotisation=BigDecimal.ZERO;
    private BigDecimal avantage=BigDecimal.ZERO;
    private BigDecimal heuresSupplementaires=BigDecimal.ZERO;

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
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSalaireNet() {
        return salaireNet;
    }

    public void setSalaireNet(BigDecimal salaireNet) {
        this.salaireNet = salaireNet;
    }

    public BigDecimal getSalaireBrut() {
        return salaireBrut;
    }

    public void setSalaireBrut(BigDecimal salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public BigDecimal getSalaireNetImposable() {
        return salaireNetImposable;
    }

    public void setSalaireNetImposable(BigDecimal salaireNetImposable) {
        this.salaireNetImposable = salaireNetImposable;
    }

    public BigDecimal getSalaireBrutImposable() {
        return salaireBrutImposable;
    }

    public void setSalaireBrutImposable(BigDecimal salaireBrutImposable) {
        this.salaireBrutImposable = salaireBrutImposable;
    }

    public BigDecimal getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(BigDecimal salaireBase) {
        this.salaireBase = salaireBase;
    }

    public BigDecimal getIndemniteJustifie() {
        return indemniteJustifie;
    }

    public void setIndemniteJustifie(BigDecimal indemniteJustifie) {
        this.indemniteJustifie = indemniteJustifie;
    }

    public BigDecimal getIndemnite() {
        return indemnite;
    }

    public void setIndemnite(BigDecimal indemnite) {
        this.indemnite = indemnite;
    }

    public BigDecimal getPrimes() {
        return primes;
    }

    public void setPrimes(BigDecimal primes) {
        this.primes = primes;
    }

    public BigDecimal getPourcentageAnciennete() {
        return pourcentageAnciennete;
    }

    public void setPourcentageAnciennete(BigDecimal pourcentageAnciennete) {
        this.pourcentageAnciennete = pourcentageAnciennete;
    }

    public BigDecimal getCotisation() {
        return cotisation;
    }

    public void setCotisation(BigDecimal cotisation) {
        this.cotisation = cotisation;
    }

    public BigDecimal getAvantage() {
        return avantage;
    }

    public void setAvantage(BigDecimal avantage) {
        this.avantage = avantage;
    }

    public BigDecimal getHeuresSupplementaires() {
        return heuresSupplementaires;
    }

    public void setHeuresSupplementaires(BigDecimal heuresSupplementaires) {
        this.heuresSupplementaires = heuresSupplementaires;
    }

    public DeclarationIr getDeclarationIr() {
        return declarationIr;
    }

    public void setDeclarationIr(DeclarationIr declarationIr) {
        this.declarationIr = declarationIr;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public TauxIr getTauxIr() {
        return tauxIr;
    }

    public void setTauxIr(TauxIr tauxIr) {
        this.tauxIr = tauxIr;
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

