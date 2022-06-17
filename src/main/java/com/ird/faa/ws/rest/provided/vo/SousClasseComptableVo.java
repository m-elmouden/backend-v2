package com.ird.faa.ws.rest.provided.vo;

import java.util.List;

public class SousClasseComptableVo {

    private String id;
    private String numero;
    private String libelle;


    private String numeroMax;
    private String numeroMin;

    private ClasseComptableVo classeComptableVo;

    private List<CompteComptableVo> compteComptablesVo;

    public SousClasseComptableVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public String getNumeroMax() {
        return this.numeroMax;
    }

    public void setNumeroMax(String numeroMax) {
        this.numeroMax = numeroMax;
    }

    public String getNumeroMin() {
        return this.numeroMin;
    }

    public void setNumeroMin(String numeroMin) {
        this.numeroMin = numeroMin;
    }


    public ClasseComptableVo getClasseComptableVo() {
        return this.classeComptableVo;
    }

    public void setClasseComptableVo(ClasseComptableVo classeComptableVo) {
        this.classeComptableVo = classeComptableVo;
    }


    public List<CompteComptableVo> getCompteComptablesVo() {
        return this.compteComptablesVo;
    }

    public void setCompteComptablesVo(List<CompteComptableVo> compteComptablesVo) {
        this.compteComptablesVo = compteComptablesVo;
    }

}
