package com.ird.faa.ws.rest.provided.vo;

public class AcompteVo {

    private String id;
    private String numero;
    private String annee;
    private String montant;
    private Boolean archive;
    private String dateArchivage;
    private String dateCreation;
    private Boolean admin;
    private Boolean visible;
    private String username;


    private String numeroMax;
    private String numeroMin;
    private String anneeMax;
    private String anneeMin;
    private String montantMax;
    private String montantMin;
    private String dateArchivageMax;
    private String dateArchivageMin;
    private String dateCreationMax;
    private String dateCreationMin;

    private SocieteVo societeVo;


    public AcompteVo() {
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

    public String getAnnee() {
        return this.annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getMontant() {
        return this.montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
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

    public String getAnneeMax() {
        return this.anneeMax;
    }

    public void setAnneeMax(String anneeMax) {
        this.anneeMax = anneeMax;
    }

    public String getAnneeMin() {
        return this.anneeMin;
    }

    public void setAnneeMin(String anneeMin) {
        this.anneeMin = anneeMin;
    }

    public String getMontantMax() {
        return this.montantMax;
    }

    public void setMontantMax(String montantMax) {
        this.montantMax = montantMax;
    }

    public String getMontantMin() {
        return this.montantMin;
    }

    public void setMontantMin(String montantMin) {
        this.montantMin = montantMin;
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


    public SocieteVo getSocieteVo() {
        return this.societeVo;
    }

    public void setSocieteVo(SocieteVo societeVo) {
        this.societeVo = societeVo;
    }


}
