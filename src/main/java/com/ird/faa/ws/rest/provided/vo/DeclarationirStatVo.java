package com.ird.faa.ws.rest.provided.vo;

import com.ird.faa.bean.EtatDeclarationIr;

import java.math.BigDecimal;

public class DeclarationirStatVo {
    private EtatDeclarationIr etatDeclarationIr;
    private BigDecimal somme;



    public DeclarationirStatVo() {
    }

    public DeclarationirStatVo(EtatDeclarationIr etatDeclarationIr, BigDecimal somme) {
        this.etatDeclarationIr = etatDeclarationIr;
        this.somme = somme;
    }

    public EtatDeclarationIr getEtatDeclarationIr() {
        return etatDeclarationIr;
    }

    public void setEtatDeclarationIr(EtatDeclarationIr etatDeclarationIr) {
        this.etatDeclarationIr = etatDeclarationIr;
    }

    public BigDecimal getSomme() {
        return somme;
    }

    public void setSomme(BigDecimal somme) {
        this.somme = somme;
    }
}
