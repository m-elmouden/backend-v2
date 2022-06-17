package com.ird.faa.ws.rest.provided.vo;

public class PrelevementSocialEmployeVo {

    private String id;
    private String salaireBrutImposable;
    private String montantCalculer;


    private String salaireBrutImposableMax;
    private String salaireBrutImposableMin;
    private String montantCalculerMax;
    private String montantCalculerMin;

    private PrelevementSocialVo prelevementSocialVo;
    private EmployeVo employeVo;
    private DeclarationIrVo declarationIrVo;


    public PrelevementSocialEmployeVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalaireBrutImposable() {
        return this.salaireBrutImposable;
    }

    public void setSalaireBrutImposable(String salaireBrutImposable) {
        this.salaireBrutImposable = salaireBrutImposable;
    }

    public String getMontantCalculer() {
        return this.montantCalculer;
    }

    public void setMontantCalculer(String montantCalculer) {
        this.montantCalculer = montantCalculer;
    }


    public String getSalaireBrutImposableMax() {
        return this.salaireBrutImposableMax;
    }

    public void setSalaireBrutImposableMax(String salaireBrutImposableMax) {
        this.salaireBrutImposableMax = salaireBrutImposableMax;
    }

    public String getSalaireBrutImposableMin() {
        return this.salaireBrutImposableMin;
    }

    public void setSalaireBrutImposableMin(String salaireBrutImposableMin) {
        this.salaireBrutImposableMin = salaireBrutImposableMin;
    }

    public String getMontantCalculerMax() {
        return this.montantCalculerMax;
    }

    public void setMontantCalculerMax(String montantCalculerMax) {
        this.montantCalculerMax = montantCalculerMax;
    }

    public String getMontantCalculerMin() {
        return this.montantCalculerMin;
    }

    public void setMontantCalculerMin(String montantCalculerMin) {
        this.montantCalculerMin = montantCalculerMin;
    }


    public PrelevementSocialVo getPrelevementSocialVo() {
        return this.prelevementSocialVo;
    }

    public void setPrelevementSocialVo(PrelevementSocialVo prelevementSocialVo) {
        this.prelevementSocialVo = prelevementSocialVo;
    }

    public EmployeVo getEmployeVo() {
        return this.employeVo;
    }

    public void setEmployeVo(EmployeVo employeVo) {
        this.employeVo = employeVo;
    }

    public DeclarationIrVo getDeclarationIrVo() {
        return this.declarationIrVo;
    }

    public void setDeclarationIrVo(DeclarationIrVo declarationIrVo) {
        this.declarationIrVo = declarationIrVo;
    }


}
