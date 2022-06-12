package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ird.faa.security.bean.User;
import com.ird.faa.upload.employe.model.Employe;


@Entity
@Table(name = "societe")
@XmlAccessorType(XmlAccessType.NONE)
public class Societe extends User {


    public Societe(String username) {
        super(username);
    }

    @Column(length = 500)
    @XmlElement(name = "ice")
    private String ice;
    @Column(length = 500)
    @XmlElement(name = "adresse")
    private String adresse;
    @Column(length = 500)
    @XmlElement(name = "fax")
    private String fax;
    @XmlElement(name = "telephone")
    private BigDecimal telephone;
    @Column(length = 500)
    @XmlElement(name = "raisonSociale")
    private String raisonSociale;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @XmlElement(name = "dateCreation")
    private Date dateCreation;
    @XmlElement(name = "anneeExploitation")
    private BigDecimal anneeExploitation;
    private Long capitalSocial;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    @XmlElement(name = "age")
    private BigDecimal age;
    @Column(columnDefinition = "boolean default false")
    private boolean credentialsNonExpired = false;
    @Column(columnDefinition = "boolean default false")
    private boolean enabled = false;
    @Column(columnDefinition = "boolean default false")
    private boolean accountNonExpired = false;
    @Column(columnDefinition = "boolean default false")
    private boolean accountNonLocked = false;
    @Column(columnDefinition = "boolean default false")
    private boolean passwordChanged = false;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)

    private Date updatedAt;
    @Column(length = 500)
    private String username;
    @Column(length = 500)

    private String password;
    @Column(length = 500)

    private String equivalenceAvecPanelErc;
    @Column(length = 500)

    private String baseHorizon;
    @Transient

    private String role;


    @ManyToOne
    private Comptable comptable;
    @ManyToOne
    private PresidentSociete presidentSociete;

    @ManyToOne
    private TypeSociete typeSociete;

    @OneToMany(mappedBy = "societe")
    private List<Demande> demandes;
    @OneToMany(mappedBy = "societe")
    @JsonManagedReference
    private List<DeclarationIr> declarationIrs;

    @OneToMany(mappedBy = "societe")
    private List<DeclarationIs> declarationIss;

    @OneToMany(mappedBy = "societe")
    private List<DeclarationTva> declarationTvas;
    @OneToMany(mappedBy = "societe")
    private List<DeclarationCnss> declarationCnsss;

    @OneToMany(mappedBy = "societe")
    private List<Acompte> acomptes;

    @OneToMany(mappedBy = "societe")
    private List<Employe> employes;

    @OneToMany(mappedBy = "societe")
    private List<Facture> factures;

    public Societe() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIce() {
        return this.ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public BigDecimal getTelephone() {
        return this.telephone;
    }

    public void setTelephone(BigDecimal telephone) {
        this.telephone = telephone;
    }

    public String getRaisonSociale() {
        return this.raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public BigDecimal getAnneeExploitation() {
        return this.anneeExploitation;
    }

    public void setAnneeExploitation(BigDecimal anneeExploitation) {
        this.anneeExploitation = anneeExploitation;
    }

    public Long getCapitalSocial() {
        return this.capitalSocial;
    }

    public void setCapitalSocial(Long capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAge() {
        return this.age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public Comptable getComptable() {
        return this.comptable;
    }

    public void setComptable(Comptable comptable) {
        this.comptable = comptable;
    }

    public PresidentSociete getPresidentSociete() {
        return this.presidentSociete;
    }

    public void setPresidentSociete(PresidentSociete presidentSociete) {
        this.presidentSociete = presidentSociete;
    }

    public List<Demande> getDemandes() {
        return this.demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }

    public List<DeclarationIr> getDeclarationIrs() {
        return this.declarationIrs;
    }

    public void setDeclarationIrs(List<DeclarationIr> declarationIrs) {
        this.declarationIrs = declarationIrs;
    }

    public List<DeclarationIs> getDeclarationIss() {
        return this.declarationIss;
    }

    public void setDeclarationIss(List<DeclarationIs> declarationIss) {
        this.declarationIss = declarationIss;
    }

    public List<DeclarationTva> getDeclarationTvas() {
        return this.declarationTvas;
    }

    public void setDeclarationTvas(List<DeclarationTva> declarationTvas) {
        this.declarationTvas = declarationTvas;
    }

    public List<DeclarationCnss> getDeclarationCnsss() {
        return this.declarationCnsss;
    }

    public void setDeclarationCnsss(List<DeclarationCnss> declarationCnsss) {
        this.declarationCnsss = declarationCnsss;
    }

    public List<Acompte> getAcomptes() {
        return this.acomptes;
    }

    public void setAcomptes(List<Acompte> acomptes) {
        this.acomptes = acomptes;
    }

    public List<Employe> getEmployes() {
        return this.employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public TypeSociete getTypeSociete() {
        return this.typeSociete;
    }

    public void setTypeSociete(TypeSociete typeSociete) {
        this.typeSociete = typeSociete;
    }

    public List<Facture> getFactures() {
        return this.factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public boolean getCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getAccountNonExpired() {
        return this.accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean getAccountNonLocked() {
        return this.accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean getPasswordChanged() {
        return this.passwordChanged;
    }

    public void setPasswordChanged(boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEquivalenceAvecPanelErc() {
        return this.equivalenceAvecPanelErc;
    }

    public void setEquivalenceAvecPanelErc(String equivalenceAvecPanelErc) {
        this.equivalenceAvecPanelErc = equivalenceAvecPanelErc;
    }

    public String getBaseHorizon() {
        return this.baseHorizon;
    }

    public void setBaseHorizon(String baseHorizon) {
        this.baseHorizon = baseHorizon;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Societe societe = (Societe) o;
        return id != null && id.equals(societe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

