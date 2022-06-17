package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "declaration_cnss_detail")
public class DeclarationCnssDetail implements Archivable {

    @Id
    @SequenceGenerator(name = "declaration_cnss_detail_seq", sequenceName = "declaration_cnss_detail_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "declaration_cnss_detail_seq")
    private Long id;

    @Column(length = 500)
    private String ref;
    private BigDecimal montantCalcule;
    private BigDecimal montantTotal;
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
    private TypeTauxCnss typeTauxCnss;
    @ManyToOne
    private DeclarationCnss declarationCnss;


    public DeclarationCnssDetail() {
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

    public TypeTauxCnss getTypeTauxCnss() {
        return this.typeTauxCnss;
    }

    public void setTypeTauxCnss(TypeTauxCnss typeTauxCnss) {
        this.typeTauxCnss = typeTauxCnss;
    }

    public BigDecimal getMontantCalcule() {
        return this.montantCalcule;
    }

    public void setMontantCalcule(BigDecimal montantCalcule) {
        this.montantCalcule = montantCalcule;
    }

    public BigDecimal getMontantTotal() {
        return this.montantTotal;
    }

    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }

    public DeclarationCnss getDeclarationCnss() {
        return this.declarationCnss;
    }

    public void setDeclarationCnss(DeclarationCnss declarationCnss) {
        this.declarationCnss = declarationCnss;
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
        DeclarationCnssDetail declarationCnssDetail = (DeclarationCnssDetail) o;
        return id != null && id.equals(declarationCnssDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

