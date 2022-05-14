package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.math.BigDecimal;
import javax.persistence.*;


@Entity
@Table(name = "declaration_ir")
public class DeclarationIr implements Archivable {

    @Id
    @SequenceGenerator(name = "declaration_ir_seq", sequenceName = "declaration_ir_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "declaration_ir_seq")
    private Long id;

    @Column(length = 500)
    private String refrerence;
    private BigDecimal annee;
    private BigDecimal mois;
    private BigDecimal montantIrCalcule;
    private BigDecimal montantIrAPaye;
    private BigDecimal totalAPaye;
    private BigDecimal totalSalaireNet;
    private BigDecimal totalSalaireBrut;
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
    private EtatDeclarationIr etatDeclarationIr;
    @ManyToOne
    private PaiementDeclarationIr paiementDeclarationIr;

    @OneToMany(mappedBy = "declarationIr")
    private List<DeclarationIrEmploye> declarationIrEmployes;
    @OneToMany(mappedBy = "declarationIr")
    private List<PrelevementSocialEmploye> prelevementSocialEmployes;

    public DeclarationIr() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefrerence() {
        return this.refrerence;
    }

    public void setRefrerence(String refrerence) {
        this.refrerence = refrerence;
    }

    public Societe getSociete() {
        return this.societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
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

    public BigDecimal getMontantIrCalcule() {
        return this.montantIrCalcule;
    }

    public void setMontantIrCalcule(BigDecimal montantIrCalcule) {
        this.montantIrCalcule = montantIrCalcule;
    }

    public BigDecimal getMontantIrAPaye() {
        return this.montantIrAPaye;
    }

    public void setMontantIrAPaye(BigDecimal montantIrAPaye) {
        this.montantIrAPaye = montantIrAPaye;
    }

    public BigDecimal getTotalAPaye() {
        return this.totalAPaye;
    }

    public void setTotalAPaye(BigDecimal totalAPaye) {
        this.totalAPaye = totalAPaye;
    }

    public BigDecimal getTotalSalaireNet() {
        return this.totalSalaireNet;
    }

    public void setTotalSalaireNet(BigDecimal totalSalaireNet) {
        this.totalSalaireNet = totalSalaireNet;
    }

    public BigDecimal getTotalSalaireBrut() {
        return this.totalSalaireBrut;
    }

    public void setTotalSalaireBrut(BigDecimal totalSalaireBrut) {
        this.totalSalaireBrut = totalSalaireBrut;
    }

    public List<DeclarationIrEmploye> getDeclarationIrEmployes() {
        return this.declarationIrEmployes;
    }

    public void setDeclarationIrEmployes(List<DeclarationIrEmploye> declarationIrEmployes) {
        this.declarationIrEmployes = declarationIrEmployes;
    }

    public List<PrelevementSocialEmploye> getPrelevementSocialEmployes() {
        return this.prelevementSocialEmployes;
    }

    public void setPrelevementSocialEmployes(List<PrelevementSocialEmploye> prelevementSocialEmployes) {
        this.prelevementSocialEmployes = prelevementSocialEmployes;
    }

    public EtatDeclarationIr getEtatDeclarationIr() {
        return this.etatDeclarationIr;
    }

    public void setEtatDeclarationIr(EtatDeclarationIr etatDeclarationIr) {
        this.etatDeclarationIr = etatDeclarationIr;
    }

    public PaiementDeclarationIr getPaiementDeclarationIr() {
        return this.paiementDeclarationIr;
    }

    public void setPaiementDeclarationIr(PaiementDeclarationIr paiementDeclarationIr) {
        this.paiementDeclarationIr = paiementDeclarationIr;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationIr declarationIr = (DeclarationIr) o;
        return id != null && id.equals(declarationIr.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

