package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "declaration_is")
public class DeclarationIs implements Archivable {

    @Id
    @SequenceGenerator(name = "declaration_is_seq", sequenceName = "declaration_is_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "declaration_is_seq")
    private Long id;

    @Column(length = 500)
    private String reference;
    private BigDecimal annee;
    private BigDecimal totalHtProduit;
    private BigDecimal totalHtCharge;
    private BigDecimal totalHtDifference;
    private BigDecimal montantIsCalcule;
    private BigDecimal montantIsAPaye;
    private BigDecimal totalAPaye;
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
    private TauxIs tauxIs;
    @ManyToOne
    private TauxIsConfig tauxIsConfig;
    @ManyToOne
    private EtatDeclarationIs etatDeclarationIs;
    @ManyToOne
    private PaiementDeclarationIs paiementDeclarationIs;


    public DeclarationIs() {
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

    public BigDecimal getAnnee() {
        return this.annee;
    }

    public void setAnnee(BigDecimal annee) {
        this.annee = annee;
    }

    public BigDecimal getTotalHtProduit() {
        return this.totalHtProduit;
    }

    public void setTotalHtProduit(BigDecimal totalHtProduit) {
        this.totalHtProduit = totalHtProduit;
    }

    public BigDecimal getTotalHtCharge() {
        return this.totalHtCharge;
    }

    public void setTotalHtCharge(BigDecimal totalHtCharge) {
        this.totalHtCharge = totalHtCharge;
    }

    public BigDecimal getTotalHtDifference() {
        return this.totalHtDifference;
    }

    public void setTotalHtDifference(BigDecimal totalHtDifference) {
        this.totalHtDifference = totalHtDifference;
    }

    public BigDecimal getMontantIsCalcule() {
        return this.montantIsCalcule;
    }

    public void setMontantIsCalcule(BigDecimal montantIsCalcule) {
        this.montantIsCalcule = montantIsCalcule;
    }

    public BigDecimal getMontantIsAPaye() {
        return this.montantIsAPaye;
    }

    public void setMontantIsAPaye(BigDecimal montantIsAPaye) {
        this.montantIsAPaye = montantIsAPaye;
    }

    public BigDecimal getTotalAPaye() {
        return this.totalAPaye;
    }

    public void setTotalAPaye(BigDecimal totalAPaye) {
        this.totalAPaye = totalAPaye;
    }

    public Societe getSociete() {
        return this.societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public TauxIs getTauxIs() {
        return this.tauxIs;
    }

    public void setTauxIs(TauxIs tauxIs) {
        this.tauxIs = tauxIs;
    }

    public TauxIsConfig getTauxIsConfig() {
        return this.tauxIsConfig;
    }

    public void setTauxIsConfig(TauxIsConfig tauxIsConfig) {
        this.tauxIsConfig = tauxIsConfig;
    }

    public EtatDeclarationIs getEtatDeclarationIs() {
        return this.etatDeclarationIs;
    }

    public void setEtatDeclarationIs(EtatDeclarationIs etatDeclarationIs) {
        this.etatDeclarationIs = etatDeclarationIs;
    }

    public PaiementDeclarationIs getPaiementDeclarationIs() {
        return this.paiementDeclarationIs;
    }

    public void setPaiementDeclarationIs(PaiementDeclarationIs paiementDeclarationIs) {
        this.paiementDeclarationIs = paiementDeclarationIs;
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
        DeclarationIs declarationIs = (DeclarationIs) o;
        return id != null && id.equals(declarationIs.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

