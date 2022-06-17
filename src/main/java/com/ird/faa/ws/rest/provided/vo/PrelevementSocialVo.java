package com.ird.faa.ws.rest.provided.vo;

public class PrelevementSocialVo {

    private String id;
    private String libelle;
    private String pourcentage;
    private String dateMax;
    private String dateMin;
    private String reference;

    private String pourcentageMax;
    private String pourcentageMin;
    private String dateMaxMax;
    private String dateMaxMin;
    private String dateMinMax;
    private String dateMinMin;

    public PrelevementSocialVo() {
        super();
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getPourcentage() {
        return this.pourcentage;
    }

    public void setPourcentage(String pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getDateMax() {
        return this.dateMax;
    }

    public void setDateMax(String dateMax) {
        this.dateMax = dateMax;
    }

    public String getDateMin() {
        return this.dateMin;
    }

    public void setDateMin(String dateMin) {
        this.dateMin = dateMin;
    }


    public String getPourcentageMax() {
        return this.pourcentageMax;
    }

    public void setPourcentageMax(String pourcentageMax) {
        this.pourcentageMax = pourcentageMax;
    }

    public String getPourcentageMin() {
        return this.pourcentageMin;
    }

    public void setPourcentageMin(String pourcentageMin) {
        this.pourcentageMin = pourcentageMin;
    }

    public String getDateMaxMax() {
        return this.dateMaxMax;
    }

    public void setDateMaxMax(String dateMaxMax) {
        this.dateMaxMax = dateMaxMax;
    }

    public String getDateMaxMin() {
        return this.dateMaxMin;
    }

    public void setDateMaxMin(String dateMaxMin) {
        this.dateMaxMin = dateMaxMin;
    }

    public String getDateMinMax() {
        return this.dateMinMax;
    }

    public void setDateMinMax(String dateMinMax) {
        this.dateMinMax = dateMinMax;
    }

    public String getDateMinMin() {
        return this.dateMinMin;
    }

    public void setDateMinMin(String dateMinMin) {
        this.dateMinMin = dateMinMin;
    }


}
