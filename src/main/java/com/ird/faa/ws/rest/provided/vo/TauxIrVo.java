package com.ird.faa.ws.rest.provided.vo;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;

public class TauxIrVo {

    private String id;

    private String intervalle;
    private String dateMin;
    private String dateMax;
    private String salaireImpoMin;
    private String salaireImpoMax;
    private String forfaitDeduit;
    private String pourcentage;


    private String dateMinMax;
    private String dateMinMin;
    private String dateMaxMax;
    private String dateMaxMin;
    private String salaireImpoMinMax;
    private String salaireImpoMinMin;
    private String salaireImpoMaxMax;
    private String salaireImpoMaxMin;
    private String forfaitDeduitMax;
    private String forfaitDeduitMin;
    private String pourcentageMax;
    private String pourcentageMin;


    public TauxIrVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntervalle() {
        return intervalle;
    }

    public void setIntervalle(String intervalle) {
        this.intervalle = intervalle;
    }

    public String getDateMin() {
        return this.dateMin;
    }

    public void setDateMin(String dateMin) {
        this.dateMin = dateMin;
    }

    public String getDateMax() {
        return this.dateMax;
    }

    public void setDateMax(String dateMax) {
        this.dateMax = dateMax;
    }

    public String getSalaireImpoMin() {
        return this.salaireImpoMin;
    }

    public void setSalaireImpoMin(String salaireImpoMin) {
        this.salaireImpoMin = salaireImpoMin;
    }

    public String getSalaireImpoMax() {
        return this.salaireImpoMax;
    }

    public void setSalaireImpoMax(String salaireImpoMax) {
        this.salaireImpoMax = salaireImpoMax;
    }

    public String getForfaitDeduit() {
        return this.forfaitDeduit;
    }

    public void setForfaitDeduit(String forfaitDeduit) {
        this.forfaitDeduit = forfaitDeduit;
    }

    public String getPourcentage() {
        return this.pourcentage;
    }

    public void setPourcentage(String pourcentage) {
        this.pourcentage = pourcentage;
    }


    public String getDateMinMax() {
        return this.dateMinMax;
    }

    public String getDateMinMin() {
        return this.dateMinMin;
    }

    public void setDateMinMax(String dateMinMax) {
        this.dateMinMax = dateMinMax;
    }

    public void setDateMinMin(String dateMinMin) {
        this.dateMinMin = dateMinMin;
    }

    public String getDateMaxMax() {
        return this.dateMaxMax;
    }

    public String getDateMaxMin() {
        return this.dateMaxMin;
    }

    public void setDateMaxMax(String dateMaxMax) {
        this.dateMaxMax = dateMaxMax;
    }

    public void setDateMaxMin(String dateMaxMin) {
        this.dateMaxMin = dateMaxMin;
    }

    public String getSalaireImpoMinMax() {
        return this.salaireImpoMinMax;
    }

    public String getSalaireImpoMinMin() {
        return this.salaireImpoMinMin;
    }

    public void setSalaireImpoMinMax(String salaireImpoMinMax) {
        this.salaireImpoMinMax = salaireImpoMinMax;
    }

    public void setSalaireImpoMinMin(String salaireImpoMinMin) {
        this.salaireImpoMinMin = salaireImpoMinMin;
    }

    public String getSalaireImpoMaxMax() {
        return this.salaireImpoMaxMax;
    }

    public String getSalaireImpoMaxMin() {
        return this.salaireImpoMaxMin;
    }

    public void setSalaireImpoMaxMax(String salaireImpoMaxMax) {
        this.salaireImpoMaxMax = salaireImpoMaxMax;
    }

    public void setSalaireImpoMaxMin(String salaireImpoMaxMin) {
        this.salaireImpoMaxMin = salaireImpoMaxMin;
    }

    public String getForfaitDeduitMax() {
        return this.forfaitDeduitMax;
    }

    public String getForfaitDeduitMin() {
        return this.forfaitDeduitMin;
    }

    public void setForfaitDeduitMax(String forfaitDeduitMax) {
        this.forfaitDeduitMax = forfaitDeduitMax;
    }

    public void setForfaitDeduitMin(String forfaitDeduitMin) {
        this.forfaitDeduitMin = forfaitDeduitMin;
    }

    public String getPourcentageMax() {
        return this.pourcentageMax;
    }

    public String getPourcentageMin() {
        return this.pourcentageMin;
    }

    public void setPourcentageMax(String pourcentageMax) {
        this.pourcentageMax = pourcentageMax;
    }

    public void setPourcentageMin(String pourcentageMin) {
        this.pourcentageMin = pourcentageMin;
    }


}
