package com.ird.faa.ws.rest.provided.vo;

import java.util.List;

public class ClasseComptableVo {

    private String id;
    private String libelle;
    private String numero;
    private Boolean archive;
    private String dateArchivage;
    private String dateCreation;
    private Boolean admin;
    private Boolean visible;
    private String username;


    private String numeroMax;
    private String numeroMin;
    private String dateArchivageMax;
    private String dateArchivageMin;
    private String dateCreationMax;
    private String dateCreationMin;


    private List<SousClasseComptableVo> sousClasseComptablesVo;

    public ClasseComptableVo() {
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

    public Boolean getArchive() {
        return this.archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getDateArchivage() {
        return this.dateArchivage;
    }

    public void setDateArchivage(String dateArchivage) {
        this.dateArchivage = dateArchivage;
    }

    public String getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getVisible() {
        return this.visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getDateArchivageMax() {
        return this.dateArchivageMax;
    }

    public void setDateArchivageMax(String dateArchivageMax) {
        this.dateArchivageMax = dateArchivageMax;
    }

    public String getDateArchivageMin() {
        return this.dateArchivageMin;
    }

    public void setDateArchivageMin(String dateArchivageMin) {
        this.dateArchivageMin = dateArchivageMin;
    }

    public String getDateCreationMax() {
        return this.dateCreationMax;
    }

    public void setDateCreationMax(String dateCreationMax) {
        this.dateCreationMax = dateCreationMax;
    }

    public String getDateCreationMin() {
        return this.dateCreationMin;
    }

    public void setDateCreationMin(String dateCreationMin) {
        this.dateCreationMin = dateCreationMin;
    }


    public List<SousClasseComptableVo> getSousClasseComptablesVo() {
        return this.sousClasseComptablesVo;
    }

    public void setSousClasseComptablesVo(List<SousClasseComptableVo> sousClasseComptablesVo) {
        this.sousClasseComptablesVo = sousClasseComptablesVo;
    }

}
