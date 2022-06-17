package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "paiement_declaration_is")
public class PaiementDeclarationIs {

    @Id
    @SequenceGenerator(name = "paiement_declaration_is_seq", sequenceName = "paiement_declaration_is_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paiement_declaration_is_seq")
    private Long id;

    @Column(length = 500)
    private String reference;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date datePaiement;
    private BigDecimal total;
    private BigDecimal montantCptTraiteur;
    private BigDecimal montantCptValidateur;
    private BigDecimal reste;

    @ManyToOne
    private DeclarationIs declarationIs;


    public PaiementDeclarationIs() {
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

    public Date getDatePaiement() {
        return this.datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getMontantCptTraiteur() {
        return this.montantCptTraiteur;
    }

    public void setMontantCptTraiteur(BigDecimal montantCptTraiteur) {
        this.montantCptTraiteur = montantCptTraiteur;
    }

    public BigDecimal getMontantCptValidateur() {
        return this.montantCptValidateur;
    }

    public void setMontantCptValidateur(BigDecimal montantCptValidateur) {
        this.montantCptValidateur = montantCptValidateur;
    }

    public BigDecimal getReste() {
        return this.reste;
    }

    public void setReste(BigDecimal reste) {
        this.reste = reste;
    }

    public DeclarationIs getDeclarationIs() {
        return this.declarationIs;
    }

    public void setDeclarationIs(DeclarationIs declarationIs) {
        this.declarationIs = declarationIs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaiementDeclarationIs paiementDeclarationIs = (PaiementDeclarationIs) o;
        return id != null && id.equals(paiementDeclarationIs.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

