package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.math.BigDecimal;
import javax.persistence.*;


@Entity
@Table(name = "demande")
public class Demande implements Archivable {

    @Id
    @SequenceGenerator(name = "demande_seq", sequenceName = "demande_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demande_seq")
    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String operation;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateDemande;
    private BigDecimal annee;
    private BigDecimal mois;
    private BigDecimal trimestre;
    //private DemandePieceJointe demandePieceJointes ;
    @Column(columnDefinition = "boolean default false")
    private Boolean archive = false;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateArchivage;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(columnDefinition = "boolean default false")
    private Boolean admin = false;
    @Column(columnDefinition = "boolean default false")
    private Boolean visible = false;
    @Column(length = 500)
    private String username;
    @ManyToOne
    private Societe societe;
    @ManyToOne
    private Comptable comptable;
    @ManyToOne
    private EtatDemande etatDemande;

    @OneToMany(mappedBy = "demande")
    private List<Facture> factures;
    @OneToMany(mappedBy = "demande")
    private List<DeclarationIr> declarationIrs;
    @OneToMany(mappedBy = "demande")
    private List<DemandePieceJointe> demandePieceJointes;
    @OneToMany(mappedBy = "demande")
    private List<Commentaire> commentaires;

    public Demande() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public Date getDateDemande() {
        return this.dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public BigDecimal getAnnee() {
        return this.annee;
    }

    public void setAnnee(BigDecimal annee) {
        this.annee = annee;
    }

    public BigDecimal getMois() {
        return this.mois;
    }

    public void setMois(BigDecimal mois) {
        this.mois = mois;
    }

    public BigDecimal getTrimestre() {
        return this.trimestre;
    }

    public void setTrimestre(BigDecimal trimestre) {
        this.trimestre = trimestre;
    }

    public Societe getSociete() {
        return this.societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public Comptable getComptable() {
        return this.comptable;
    }

    public void setComptable(Comptable comptable) {
        this.comptable = comptable;
    }

    public EtatDemande getEtatDemande() {
        return this.etatDemande;
    }

    public void setEtatDemande(EtatDemande etatDemande) {
        this.etatDemande = etatDemande;
    }

    public List<Facture> getFactures() {
        return this.factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public List<DemandePieceJointe> getDemandePieceJointes() {
        return this.demandePieceJointes;
    }

    public void setDemandePieceJointes(List<DemandePieceJointe> demandePieceJointes) {
        this.demandePieceJointes = demandePieceJointes;
    }

    public List<Commentaire> getCommentaires() {
        return this.commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public Boolean getArchive() {
        return this.archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Date getDateArchivage() {
        return this.dateArchivage;
    }

    public void setDateArchivage(Date dateArchivage) {
        this.dateArchivage = dateArchivage;
    }

    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
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

    public List<DeclarationIr> getDeclarationIrs() {
        return declarationIrs;
    }

    public void setDeclarationIrs(List<DeclarationIr> declarationIrs) {
        this.declarationIrs = declarationIrs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demande demande = (Demande) o;
        return id != null && id.equals(demande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

