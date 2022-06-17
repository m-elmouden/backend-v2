package com.ird.faa.ws.rest.provided.vo;

import java.util.List;

public class SocieteVo {

    private String id;
    private String ice;
    private String adresse;
    private String fax;
    private String telephone;
    private String raisonSociale;
    private String dateCreation;
    private String anneeExploitation;
    private String capitalSocial;
    private String description;
    private String age;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean passwordChanged;
    private String createdAt;
    private String updatedAt;
    private String username;
    private String password;
    private String equivalenceAvecPanelErc;
    private String baseHorizon;
    private String role;


    private String telephoneMax;
    private String telephoneMin;
    private String dateCreationMax;
    private String dateCreationMin;
    private String anneeExploitationMax;
    private String anneeExploitationMin;
    private String capitalSocialMax;
    private String capitalSocialMin;
    private String ageMax;
    private String ageMin;
    private String createdAtMax;
    private String createdAtMin;
    private String updatedAtMax;
    private String updatedAtMin;

    private ComptableVo comptableVo;
    private PresidentSocieteVo presidentSocieteVo;
    private TypeSocieteVo typeSocieteVo;

    private List<DemandeVo> demandesVo;
    private List<DeclarationIrVo> declarationIrsVo;
    private List<DeclarationIsVo> declarationIssVo;
    private List<DeclarationTvaVo> declarationTvasVo;
    private List<DeclarationCnssVo> declarationCnsssVo;
    private List<AcompteVo> acomptesVo;
    private List<EmployeVo> employesVo;
    private List<FactureVo> facturesVo;

    public SocieteVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
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

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRaisonSociale() {
        return this.raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAnneeExploitation() {
        return this.anneeExploitation;
    }

    public void setAnneeExploitation(String anneeExploitation) {
        this.anneeExploitation = anneeExploitation;
    }

    public String getCapitalSocial() {
        return this.capitalSocial;
    }

    public void setCapitalSocial(String capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getAccountNonExpired() {
        return this.accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return this.accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getPasswordChanged() {
        return this.passwordChanged;
    }

    public void setPasswordChanged(Boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
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


    public String getTelephoneMax() {
        return this.telephoneMax;
    }

    public void setTelephoneMax(String telephoneMax) {
        this.telephoneMax = telephoneMax;
    }

    public String getTelephoneMin() {
        return this.telephoneMin;
    }

    public void setTelephoneMin(String telephoneMin) {
        this.telephoneMin = telephoneMin;
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

    public String getAnneeExploitationMax() {
        return this.anneeExploitationMax;
    }

    public void setAnneeExploitationMax(String anneeExploitationMax) {
        this.anneeExploitationMax = anneeExploitationMax;
    }

    public String getAnneeExploitationMin() {
        return this.anneeExploitationMin;
    }

    public void setAnneeExploitationMin(String anneeExploitationMin) {
        this.anneeExploitationMin = anneeExploitationMin;
    }

    public String getCapitalSocialMax() {
        return this.capitalSocialMax;
    }

    public void setCapitalSocialMax(String capitalSocialMax) {
        this.capitalSocialMax = capitalSocialMax;
    }

    public String getCapitalSocialMin() {
        return this.capitalSocialMin;
    }

    public void setCapitalSocialMin(String capitalSocialMin) {
        this.capitalSocialMin = capitalSocialMin;
    }

    public String getAgeMax() {
        return this.ageMax;
    }

    public void setAgeMax(String ageMax) {
        this.ageMax = ageMax;
    }

    public String getAgeMin() {
        return this.ageMin;
    }

    public void setAgeMin(String ageMin) {
        this.ageMin = ageMin;
    }

    public String getCreatedAtMax() {
        return this.createdAtMax;
    }

    public void setCreatedAtMax(String createdAtMax) {
        this.createdAtMax = createdAtMax;
    }

    public String getCreatedAtMin() {
        return this.createdAtMin;
    }

    public void setCreatedAtMin(String createdAtMin) {
        this.createdAtMin = createdAtMin;
    }

    public String getUpdatedAtMax() {
        return this.updatedAtMax;
    }

    public void setUpdatedAtMax(String updatedAtMax) {
        this.updatedAtMax = updatedAtMax;
    }

    public String getUpdatedAtMin() {
        return this.updatedAtMin;
    }

    public void setUpdatedAtMin(String updatedAtMin) {
        this.updatedAtMin = updatedAtMin;
    }


    public ComptableVo getComptableVo() {
        return this.comptableVo;
    }

    public void setComptableVo(ComptableVo comptableVo) {
        this.comptableVo = comptableVo;
    }

    public PresidentSocieteVo getPresidentSocieteVo() {
        return this.presidentSocieteVo;
    }

    public void setPresidentSocieteVo(PresidentSocieteVo presidentSocieteVo) {
        this.presidentSocieteVo = presidentSocieteVo;
    }

    public TypeSocieteVo getTypeSocieteVo() {
        return this.typeSocieteVo;
    }

    public void setTypeSocieteVo(TypeSocieteVo typeSocieteVo) {
        this.typeSocieteVo = typeSocieteVo;
    }


    public List<DemandeVo> getDemandesVo() {
        return this.demandesVo;
    }

    public void setDemandesVo(List<DemandeVo> demandesVo) {
        this.demandesVo = demandesVo;
    }

    public List<DeclarationIrVo> getDeclarationIrsVo() {
        return this.declarationIrsVo;
    }

    public void setDeclarationIrsVo(List<DeclarationIrVo> declarationIrsVo) {
        this.declarationIrsVo = declarationIrsVo;
    }

    public List<DeclarationIsVo> getDeclarationIssVo() {
        return this.declarationIssVo;
    }

    public void setDeclarationIssVo(List<DeclarationIsVo> declarationIssVo) {
        this.declarationIssVo = declarationIssVo;
    }

    public List<DeclarationTvaVo> getDeclarationTvasVo() {
        return this.declarationTvasVo;
    }

    public void setDeclarationTvasVo(List<DeclarationTvaVo> declarationTvasVo) {
        this.declarationTvasVo = declarationTvasVo;
    }

    public List<DeclarationCnssVo> getDeclarationCnsssVo() {
        return this.declarationCnsssVo;
    }

    public void setDeclarationCnsssVo(List<DeclarationCnssVo> declarationCnsssVo) {
        this.declarationCnsssVo = declarationCnsssVo;
    }

    public List<AcompteVo> getAcomptesVo() {
        return this.acomptesVo;
    }

    public void setAcomptesVo(List<AcompteVo> acomptesVo) {
        this.acomptesVo = acomptesVo;
    }

    public List<EmployeVo> getEmployesVo() {
        return this.employesVo;
    }

    public void setEmployesVo(List<EmployeVo> employesVo) {
        this.employesVo = employesVo;
    }

    public List<FactureVo> getFacturesVo() {
        return this.facturesVo;
    }

    public void setFacturesVo(List<FactureVo> facturesVo) {
        this.facturesVo = facturesVo;
    }

}
