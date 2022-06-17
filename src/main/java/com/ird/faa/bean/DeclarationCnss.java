package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.upload.employe.model.Employe;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "declaration_cnss")
public class DeclarationCnss implements Archivable {

    @Id
    @SequenceGenerator(name = "declaration_cnss_seq", sequenceName = "declaration_cnss_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "declaration_cnss_seq")
    private Long id;

    @Column(length = 500)
    private String ref;
    private BigDecimal salaireNet;
    private BigDecimal salaireBrut;
    private BigDecimal salaireImposable;
    private BigDecimal montantTotal;
    private BigDecimal mois;
    private BigDecimal annee;
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
    private Employe employe;
    @ManyToOne
    private Societe societe;

    @OneToMany(mappedBy = "declarationCnss")
    private List<DeclarationCnssDetail> declarationCnssDetails;

    public DeclarationCnss() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Employe getEmploye() {
        return this.employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public BigDecimal getSalaireNet() {
        return this.salaireNet;
    }

    public void setSalaireNet(BigDecimal salaireNet) {
        this.salaireNet = salaireNet;
    }

    public BigDecimal getSalaireBrut() {
        return this.salaireBrut;
    }

    public void setSalaireBrut(BigDecimal salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public BigDecimal getSalaireImposable() {
        return this.salaireImposable;
    }

    public void setSalaireImposable(BigDecimal salaireImposable) {
        this.salaireImposable = salaireImposable;
    }

    public BigDecimal getMontantTotal() {
        return this.montantTotal;
    }

    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }

    public List<DeclarationCnssDetail> getDeclarationCnssDetails() {
        return this.declarationCnssDetails;
    }

    public void setDeclarationCnssDetails(List<DeclarationCnssDetail> declarationCnssDetails) {
        this.declarationCnssDetails = declarationCnssDetails;
    }

    public BigDecimal getMois() {
        return this.mois;
    }

    public void setMois(BigDecimal mois) {
        this.mois = mois;
    }

    public BigDecimal getAnnee() {
        return this.annee;
    }

    public void setAnnee(BigDecimal annee) {
        this.annee = annee;
    }

    public Societe getSociete() {
        return this.societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
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
        DeclarationCnss declarationCnss = (DeclarationCnss) o;
        return id != null && id.equals(declarationCnss.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

