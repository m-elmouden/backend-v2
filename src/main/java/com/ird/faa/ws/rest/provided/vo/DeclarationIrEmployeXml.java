package com.ird.faa.ws.rest.provided.vo;

import com.ird.faa.bean.DeclarationIr;
import com.ird.faa.bean.DeclarationIrEmploye;
import com.ird.faa.bean.TauxIr;
import com.ird.faa.upload.employe.model.Employe;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

public class DeclarationIrEmployeXml {
    private Long id;

    private BigDecimal salaireNet = BigDecimal.ZERO;
    private BigDecimal salaireBrut = BigDecimal.ZERO;
    private BigDecimal salaireNetImposable = BigDecimal.ZERO;
    private BigDecimal salaireBrutImposable = BigDecimal.ZERO;
    private BigDecimal salaireBase = BigDecimal.ZERO;
    private BigDecimal indemniteJustifie = BigDecimal.ZERO;
    private BigDecimal indemnite = BigDecimal.ZERO;
    private BigDecimal primes = BigDecimal.ZERO;
    private BigDecimal pourcentageAnciennete = BigDecimal.ZERO;
    private BigDecimal cotisation = BigDecimal.ZERO;
    private BigDecimal avantage = BigDecimal.ZERO;
    private BigDecimal heuresSupplementaires = BigDecimal.ZERO;
    private Employe employe;
    private TauxIr tauxIr;

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

    public DeclarationIrEmployeXml convertToDeclartionEmlpXml(DeclarationIrEmploye declarationIrEmploye) {
        DeclarationIrEmployeXml declarationIrEmployeXml = new DeclarationIrEmployeXml();
        declarationIrEmployeXml.setId(declarationIrEmploye.getId());
        declarationIrEmployeXml.setEmploye(declarationIrEmploye.getEmploye());
        declarationIrEmployeXml.setSalaireBase(declarationIrEmploye.getSalaireBase());
        declarationIrEmployeXml.setSalaireBrut(declarationIrEmploye.getSalaireBrut());
        declarationIrEmployeXml.setSalaireBrutImposable(declarationIrEmploye.getSalaireBrutImposable());
        declarationIrEmployeXml.setSalaireNet(declarationIrEmploye.getSalaireNet());
        declarationIrEmployeXml.setSalaireNetImposable(declarationIrEmploye.getSalaireNetImposable());
        declarationIrEmployeXml.setIndemnite(declarationIrEmploye.getIndemnite());
        declarationIrEmployeXml.setIndemniteJustifie(declarationIrEmploye.getIndemniteJustifie());
        declarationIrEmployeXml.setTauxIr(declarationIrEmploye.getTauxIr());
        declarationIrEmployeXml.setAvantage(declarationIrEmploye.getAvantage());
        declarationIrEmployeXml.setPrimes(declarationIrEmploye.getPrimes());
        declarationIrEmployeXml.setPourcentageAnciennete(declarationIrEmploye.getPourcentageAnciennete());
        declarationIrEmployeXml.setHeuresSupplementaires(declarationIrEmploye.getHeuresSupplementaires());
        declarationIrEmployeXml.setCotisation(declarationIrEmploye.getCotisation());
        return declarationIrEmployeXml;
    }
}
