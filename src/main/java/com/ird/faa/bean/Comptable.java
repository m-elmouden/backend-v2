package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.security.bean.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "comptable")
public class Comptable extends User {


    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String telephone;
    @Column(length = 500)
    private String prenom;
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
    private TypeComptable typeComptable;
    @OneToMany(mappedBy = "comptable")
    private List<Societe> societes;
    @OneToMany(mappedBy = "comptable")
    private List<Demande> demandes;
    public Comptable(String username) {
        super(username);
    }

    public Comptable() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public TypeComptable getTypeComptable() {
        return this.typeComptable;
    }

    public void setTypeComptable(TypeComptable typeComptable) {
        this.typeComptable = typeComptable;
    }

    public List<Societe> getSocietes() {
        return this.societes;
    }

    public void setSocietes(List<Societe> societes) {
        this.societes = societes;
    }

    public List<Demande> getDemandes() {
        return this.demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
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
        Comptable comptable = (Comptable) o;
        return id != null && id.equals(comptable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

