package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "classe_comptable")
public class ClasseComptable implements Archivable {

    @Id
    @SequenceGenerator(name = "classe_comptable_seq", sequenceName = "classe_comptable_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classe_comptable_seq")
    private Long id;

    @Column(length = 500)
    private String libelle;
    private BigDecimal numero;
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


    @OneToMany(mappedBy = "classeComptable")
    private List<SousClasseComptable> sousClasseComptables;

    public ClasseComptable() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getNumero() {
        return this.numero;
    }

    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }

    public List<SousClasseComptable> getSousClasseComptables() {
        return this.sousClasseComptables;
    }

    public void setSousClasseComptables(List<SousClasseComptable> sousClasseComptables) {
        this.sousClasseComptables = sousClasseComptables;
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
        ClasseComptable classeComptable = (ClasseComptable) o;
        return id != null && id.equals(classeComptable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

