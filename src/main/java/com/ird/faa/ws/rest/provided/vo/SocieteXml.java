package com.ird.faa.ws.rest.provided.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.bean.Societe;

import java.math.BigDecimal;
import java.util.Date;

public class SocieteXml {
    private String ice;
    private String adresse;
    private String fax;
    private BigDecimal telephone;
    private String raisonSociale;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateCreation;
    private BigDecimal anneeExploitation;
    private BigDecimal age;


    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public BigDecimal getTelephone() {
        return telephone;
    }

    public void setTelephone(BigDecimal telephone) {
        this.telephone = telephone;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public BigDecimal getAnneeExploitation() {
        return anneeExploitation;
    }

    public void setAnneeExploitation(BigDecimal anneeExploitation) {
        this.anneeExploitation = anneeExploitation;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }


    public SocieteXml convertToSteXml(Societe societe) {
        SocieteXml societeXml = new SocieteXml();
        societeXml.setIce(societe.getIce());
        societeXml.setAdresse(societe.getAdresse());
        societeXml.setFax(societe.getFax());
        societeXml.setTelephone(societe.getTelephone());
        societeXml.setRaisonSociale(societe.getRaisonSociale());
        societeXml.setDateCreation(societe.getDateCreation());
        societeXml.setAnneeExploitation(societe.getAnneeExploitation());
        societeXml.setAge(societe.getAge());
        return societeXml;
    }

}
