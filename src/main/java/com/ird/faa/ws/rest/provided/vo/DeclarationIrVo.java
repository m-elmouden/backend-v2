package com.ird.faa.ws.rest.provided.vo;

import java.util.List;

public class DeclarationIrVo {

    private String id;
    private String refrerence;
    private String annee;
    private String mois;
    private String montantIrCalcule;
    private String montantIrAPaye;
    private String totalAPaye;
    private String totalSalaireNet;
    private String totalSalaireBrut;
    private Boolean archive;
    private String dateArchivage;
    private String dateCreation;
    private Boolean admin;
    private Boolean visible;
    private String username;


    private String anneeMax;
    private String anneeMin;
    private String moisMax;
    private String moisMin;
    private String montantIrCalculeMax;
    private String montantIrCalculeMin;
    private String montantIrAPayeMax;
    private String montantIrAPayeMin;
    private String totalAPayeMax;
    private String totalAPayeMin;
    private String totalSalaireNetMax;
    private String totalSalaireNetMin;
    private String totalSalaireBrutMax;
    private String totalSalaireBrutMin;
    private String dateArchivageMax;
    private String dateArchivageMin;
    private String dateCreationMax;
    private String dateCreationMin;

    private SocieteVo societeVo;
    private EtatDeclarationIrVo etatDeclarationIrVo;
    private PaiementDeclarationIrVo paiementDeclarationIrVo;
    private ComptableVo comptableTraiteurVo;
    private ComptableVo comptableValidateurVo;
    private DemandeVo demandeVo;
    private List<DeclarationIrEmployeVo> declarationIrEmployesVo;
    private List<PrelevementSocialEmployeVo> prelevementSocialEmployesVo;

    public DeclarationIrVo() {
        super();
    }

    public ComptableVo getComptableTraiteurVo() {
        return comptableTraiteurVo;
    }

    public void setComptableTraiteurVo(ComptableVo comptableTraiteurVo) {
        this.comptableTraiteurVo = comptableTraiteurVo;
    }

    public ComptableVo getComptableValidateurVo() {
        return comptableValidateurVo;
    }

    public void setComptableValidateurVo(ComptableVo comptableValidateurVo) {
        this.comptableValidateurVo = comptableValidateurVo;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefrerence() {
        return this.refrerence;
    }

    public void setRefrerence(String refrerence) {
        this.refrerence = refrerence;
    }

    public String getAnnee() {
        return this.annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getMois() {
        return this.mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getMontantIrCalcule() {
        return this.montantIrCalcule;
    }

    public void setMontantIrCalcule(String montantIrCalcule) {
        this.montantIrCalcule = montantIrCalcule;
    }

    public String getMontantIrAPaye() {
        return this.montantIrAPaye;
    }

    public void setMontantIrAPaye(String montantIrAPaye) {
        this.montantIrAPaye = montantIrAPaye;
    }

    public String getTotalAPaye() {
        return this.totalAPaye;
    }

    public void setTotalAPaye(String totalAPaye) {
        this.totalAPaye = totalAPaye;
    }

    public String getTotalSalaireNet() {
        return this.totalSalaireNet;
    }

    public void setTotalSalaireNet(String totalSalaireNet) {
        this.totalSalaireNet = totalSalaireNet;
    }

    public String getTotalSalaireBrut() {
        return this.totalSalaireBrut;
    }

    public void setTotalSalaireBrut(String totalSalaireBrut) {
        this.totalSalaireBrut = totalSalaireBrut;
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

    public String getMoisMax() {
        return this.moisMax;
    }

    public void setMoisMax(String moisMax) {
        this.moisMax = moisMax;
    }

    public String getMoisMin() {
        return this.moisMin;
    }

    public void setMoisMin(String moisMin) {
        this.moisMin = moisMin;
    }

    public String getMontantIrCalculeMax() {
        return this.montantIrCalculeMax;
    }

    public void setMontantIrCalculeMax(String montantIrCalculeMax) {
        this.montantIrCalculeMax = montantIrCalculeMax;
    }

    public String getMontantIrCalculeMin() {
        return this.montantIrCalculeMin;
    }

    public void setMontantIrCalculeMin(String montantIrCalculeMin) {
        this.montantIrCalculeMin = montantIrCalculeMin;
    }

    public String getMontantIrAPayeMax() {
        return this.montantIrAPayeMax;
    }

    public void setMontantIrAPayeMax(String montantIrAPayeMax) {
        this.montantIrAPayeMax = montantIrAPayeMax;
    }

    public String getMontantIrAPayeMin() {
        return this.montantIrAPayeMin;
    }

    public void setMontantIrAPayeMin(String montantIrAPayeMin) {
        this.montantIrAPayeMin = montantIrAPayeMin;
    }

    public String getTotalAPayeMax() {
        return this.totalAPayeMax;
    }

    public void setTotalAPayeMax(String totalAPayeMax) {
        this.totalAPayeMax = totalAPayeMax;
    }

    public String getTotalAPayeMin() {
        return this.totalAPayeMin;
    }

    public void setTotalAPayeMin(String totalAPayeMin) {
        this.totalAPayeMin = totalAPayeMin;
    }

    public String getTotalSalaireNetMax() {
        return this.totalSalaireNetMax;
    }

    public void setTotalSalaireNetMax(String totalSalaireNetMax) {
        this.totalSalaireNetMax = totalSalaireNetMax;
    }

    public String getTotalSalaireNetMin() {
        return this.totalSalaireNetMin;
    }

    public void setTotalSalaireNetMin(String totalSalaireNetMin) {
        this.totalSalaireNetMin = totalSalaireNetMin;
    }

    public String getTotalSalaireBrutMax() {
        return this.totalSalaireBrutMax;
    }

    public void setTotalSalaireBrutMax(String totalSalaireBrutMax) {
        this.totalSalaireBrutMax = totalSalaireBrutMax;
    }

    public String getTotalSalaireBrutMin() {
        return this.totalSalaireBrutMin;
    }

    public void setTotalSalaireBrutMin(String totalSalaireBrutMin) {
        this.totalSalaireBrutMin = totalSalaireBrutMin;
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

    public EtatDeclarationIrVo getEtatDeclarationIrVo() {
        return this.etatDeclarationIrVo;
    }

    public void setEtatDeclarationIrVo(EtatDeclarationIrVo etatDeclarationIrVo) {
        this.etatDeclarationIrVo = etatDeclarationIrVo;
    }

    public PaiementDeclarationIrVo getPaiementDeclarationIrVo() {
        return this.paiementDeclarationIrVo;
    }

    public void setPaiementDeclarationIrVo(PaiementDeclarationIrVo paiementDeclarationIrVo) {
        this.paiementDeclarationIrVo = paiementDeclarationIrVo;
    }


    public List<DeclarationIrEmployeVo> getDeclarationIrEmployesVo() {
        return this.declarationIrEmployesVo;
    }

    public void setDeclarationIrEmployesVo(List<DeclarationIrEmployeVo> declarationIrEmployesVo) {
        this.declarationIrEmployesVo = declarationIrEmployesVo;
    }

    public List<PrelevementSocialEmployeVo> getPrelevementSocialEmployesVo() {
        return this.prelevementSocialEmployesVo;
    }

    public void setPrelevementSocialEmployesVo(List<PrelevementSocialEmployeVo> prelevementSocialEmployesVo) {
        this.prelevementSocialEmployesVo = prelevementSocialEmployesVo;
    }


    public DemandeVo getDemandeVo() {
        return demandeVo;
    }

    public void setDemandeVo(DemandeVo demandeVo) {
        this.demandeVo = demandeVo;
    }


}
