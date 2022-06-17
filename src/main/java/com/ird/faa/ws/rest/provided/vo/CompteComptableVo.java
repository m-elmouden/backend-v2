package com.ird.faa.ws.rest.provided.vo;

public class CompteComptableVo {

    private String id;
    private String libelle;
    private String numero;


    private String numeroMax;
    private String numeroMin;

    private SousClasseComptableVo sousClasseComptableVo;


    public CompteComptableVo() {
        super();
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

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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


    public SousClasseComptableVo getSousClasseComptableVo() {
        return this.sousClasseComptableVo;
    }

    public void setSousClasseComptableVo(SousClasseComptableVo sousClasseComptableVo) {
        this.sousClasseComptableVo = sousClasseComptableVo;
    }


}
