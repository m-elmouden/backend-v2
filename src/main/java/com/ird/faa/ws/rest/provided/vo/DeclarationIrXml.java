package com.ird.faa.ws.rest.provided.vo;

import com.ird.faa.bean.DeclarationIrEmploye;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@XmlRootElement(name = "DeclarationIr")
public class DeclarationIrXml {
    private Long id;

    private String refrerence;

    private String annee;

    private String mois;

    private BigDecimal montantIrCalcule = BigDecimal.ZERO;

    private BigDecimal montantIrAPaye = BigDecimal.ZERO;

    private BigDecimal totalAPaye = BigDecimal.ZERO;

    private BigDecimal totalSalaireNet = BigDecimal.ZERO;

    private BigDecimal totalSalaireBrut = BigDecimal.ZERO;

    private Date dateCreation;

    private SocieteXml societeXml;

    private List<DeclarationIrEmployeXml> declarationIrEmployes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefrerence() {
        return refrerence;
    }

    public void setRefrerence(String refrerence) {
        this.refrerence = refrerence;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public BigDecimal getMontantIrCalcule() {
        return montantIrCalcule;
    }

    public void setMontantIrCalcule(BigDecimal montantIrCalcule) {
        this.montantIrCalcule = montantIrCalcule;
    }

    public BigDecimal getMontantIrAPaye() {
        return montantIrAPaye;
    }

    public void setMontantIrAPaye(BigDecimal montantIrAPaye) {
        this.montantIrAPaye = montantIrAPaye;
    }

    public BigDecimal getTotalAPaye() {
        return totalAPaye;
    }

    public void setTotalAPaye(BigDecimal totalAPaye) {
        this.totalAPaye = totalAPaye;
    }

    public BigDecimal getTotalSalaireNet() {
        return totalSalaireNet;
    }

    public void setTotalSalaireNet(BigDecimal totalSalaireNet) {
        this.totalSalaireNet = totalSalaireNet;
    }

    public BigDecimal getTotalSalaireBrut() {
        return totalSalaireBrut;
    }

    public void setTotalSalaireBrut(BigDecimal totalSalaireBrut) {
        this.totalSalaireBrut = totalSalaireBrut;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public SocieteXml getSocieteXml() {
        return societeXml;
    }

    public void setSocieteXml(SocieteXml societeXml) {
        this.societeXml = societeXml;
    }


    public List<DeclarationIrEmployeXml> getDeclarationIrEmployes() {
        return declarationIrEmployes;
    }

    public void setDeclarationIrEmployes(List<DeclarationIrEmployeXml> declarationIrEmployes) {
        this.declarationIrEmployes = declarationIrEmployes;
    }

    @Override
    public String toString() {
        return "DeclarationIrXml{" +
                "id=" + id +
                ", ref='" + refrerence + '\'' +
                ", annee=" + annee +
                ", mois=" + mois +
                ", dateCreation=" + dateCreation +
                ", montantIrCalcule=" + montantIrCalcule +
                ", montantIrAPaye=" + montantIrAPaye +
                ", totalAPaye=" + totalAPaye +
                ", totalSalaireNet=" + totalSalaireNet +
                ", totalSalaireBrut=" + totalSalaireBrut +
                ", societe=" + societeXml +
                ", declarationIrEmployes=" + declarationIrEmployes + '}';
    }
}
