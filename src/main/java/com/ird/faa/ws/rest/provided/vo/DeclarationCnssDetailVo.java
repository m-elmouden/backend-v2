package com.ird.faa.ws.rest.provided.vo;

public class DeclarationCnssDetailVo {

    private String id;
    private String ref;
    private String montantCalcule;
    private String montantTotal;
    private Boolean archive;
    private String dateArchivage;
    private String dateCreation;
    private Boolean admin;
    private Boolean visible;
    private String username;


    private String montantCalculeMax;
    private String montantCalculeMin;
    private String montantTotalMax;
    private String montantTotalMin;
    private String dateArchivageMax;
    private String dateArchivageMin;
    private String dateCreationMax;
    private String dateCreationMin;

    private TypeTauxCnssVo typeTauxCnssVo;
    private DeclarationCnssVo declarationCnssVo;


    public DeclarationCnssDetailVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getMontantCalcule() {
        return this.montantCalcule;
    }

    public void setMontantCalcule(String montantCalcule) {
        this.montantCalcule = montantCalcule;
    }

    public String getMontantTotal() {
        return this.montantTotal;
    }

    public void setMontantTotal(String montantTotal) {
        this.montantTotal = montantTotal;
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


    public String getMontantCalculeMax() {
        return this.montantCalculeMax;
    }

    public void setMontantCalculeMax(String montantCalculeMax) {
        this.montantCalculeMax = montantCalculeMax;
    }

    public String getMontantCalculeMin() {
        return this.montantCalculeMin;
    }

    public void setMontantCalculeMin(String montantCalculeMin) {
        this.montantCalculeMin = montantCalculeMin;
    }

    public String getMontantTotalMax() {
        return this.montantTotalMax;
    }

    public void setMontantTotalMax(String montantTotalMax) {
        this.montantTotalMax = montantTotalMax;
    }

    public String getMontantTotalMin() {
        return this.montantTotalMin;
    }

    public void setMontantTotalMin(String montantTotalMin) {
        this.montantTotalMin = montantTotalMin;
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


    public TypeTauxCnssVo getTypeTauxCnssVo() {
        return this.typeTauxCnssVo;
    }

    public void setTypeTauxCnssVo(TypeTauxCnssVo typeTauxCnssVo) {
        this.typeTauxCnssVo = typeTauxCnssVo;
    }

    public DeclarationCnssVo getDeclarationCnssVo() {
        return this.declarationCnssVo;
    }

    public void setDeclarationCnssVo(DeclarationCnssVo declarationCnssVo) {
        this.declarationCnssVo = declarationCnssVo;
    }


}
