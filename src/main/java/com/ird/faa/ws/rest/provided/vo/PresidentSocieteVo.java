package com.ird.faa.ws.rest.provided.vo;


public class PresidentSocieteVo {

    private String id;
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;


    private SocieteVo societeVo;


    public PresidentSocieteVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public SocieteVo getSocieteVo() {
        return this.societeVo;
    }

    public void setSocieteVo(SocieteVo societeVo) {
        this.societeVo = societeVo;
    }


}
