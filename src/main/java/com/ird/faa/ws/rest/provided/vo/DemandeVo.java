package com.ird.faa.ws.rest.provided.vo;

import java.util.List;

public class DemandeVo {

    private String id;
    private String reference;
    private String operation;
    private String dateDemande;
    private String annee;
    private String mois;
    private String trimestre;
    private String demandePieceJointes;
    private Boolean archive;
    private String dateArchivage;
    private String dateCreation;
    private Boolean admin;
    private Boolean visible;
    private String username;


    private String dateDemandeMax;
    private String dateDemandeMin;
    private String anneeMax;
    private String anneeMin;
    private String moisMax;
    private String moisMin;
    private String trimestreMax;
    private String trimestreMin;
    private String demandePieceJointesMax;
    private String demandePieceJointesMin;
    private String dateArchivageMax;
    private String dateArchivageMin;
    private String dateCreationMax;
    private String dateCreationMin;

    private SocieteVo societeVo;
    private ComptableVo comptableVo;
    private EtatDemandeVo etatDemandeVo;

    private List<FactureVo> facturesVo;
    private List<DemandePieceJointeVo> demandePieceJointesVo;
    private List<DeclarationIrVo> declarationIrVos;
    private List<CommentaireVo> commentairesVo;

    public DemandeVo() {
        super();
    }

    public String getDemandePieceJointes() {
        return demandePieceJointes;
    }

    public void setDemandePieceJointes(String demandePieceJointes) {
        this.demandePieceJointes = demandePieceJointes;
    }

    public List<DeclarationIrVo> getDeclarationIrVos() {
        return declarationIrVos;
    }

    public void setDeclarationIrVos(List<DeclarationIrVo> declarationIrVos) {
        this.declarationIrVos = declarationIrVos;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getDateDemande() {
        return this.dateDemande;
    }

    public void setDateDemande(String dateDemande) {
        this.dateDemande = dateDemande;
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

    public String getTrimestre() {
        return this.trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
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


    public String getDateDemandeMax() {
        return this.dateDemandeMax;
    }

    public void setDateDemandeMax(String dateDemandeMax) {
        this.dateDemandeMax = dateDemandeMax;
    }

    public String getDateDemandeMin() {
        return this.dateDemandeMin;
    }

    public void setDateDemandeMin(String dateDemandeMin) {
        this.dateDemandeMin = dateDemandeMin;
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

    public String getTrimestreMax() {
        return this.trimestreMax;
    }

    public void setTrimestreMax(String trimestreMax) {
        this.trimestreMax = trimestreMax;
    }

    public String getTrimestreMin() {
        return this.trimestreMin;
    }

    public void setTrimestreMin(String trimestreMin) {
        this.trimestreMin = trimestreMin;
    }

    public String getDemandePieceJointesMax() {
        return this.demandePieceJointesMax;
    }

    public void setDemandePieceJointesMax(String demandePieceJointesMax) {
        this.demandePieceJointesMax = demandePieceJointesMax;
    }

    public String getDemandePieceJointesMin() {
        return this.demandePieceJointesMin;
    }

    public void setDemandePieceJointesMin(String demandePieceJointesMin) {
        this.demandePieceJointesMin = demandePieceJointesMin;
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

    public ComptableVo getComptableVo() {
        return this.comptableVo;
    }

    public void setComptableVo(ComptableVo comptableVo) {
        this.comptableVo = comptableVo;
    }

    public EtatDemandeVo getEtatDemandeVo() {
        return this.etatDemandeVo;
    }

    public void setEtatDemandeVo(EtatDemandeVo etatDemandeVo) {
        this.etatDemandeVo = etatDemandeVo;
    }


    public List<FactureVo> getFacturesVo() {
        return this.facturesVo;
    }

    public void setFacturesVo(List<FactureVo> facturesVo) {
        this.facturesVo = facturesVo;
    }

    public List<DemandePieceJointeVo> getDemandePieceJointesVo() {
        return this.demandePieceJointesVo;
    }

    public void setDemandePieceJointesVo(List<DemandePieceJointeVo> demandePieceJointesVo) {
        this.demandePieceJointesVo = demandePieceJointesVo;
    }

    public List<CommentaireVo> getCommentairesVo() {
        return this.commentairesVo;
    }

    public void setCommentairesVo(List<CommentaireVo> commentairesVo) {
        this.commentairesVo = commentairesVo;
    }

}
