package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "paiement_declaration_tva")
public class PaiementDeclarationTva {

    @Id
    @SequenceGenerator(name = "paiement_declaration_tva_seq", sequenceName = "paiement_declaration_tva_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paiement_declaration_tva_seq")
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
    private DeclarationTva declarationTva;


    public PaiementDeclarationTva() {
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

    public DeclarationTva getDeclarationTva() {
        return this.declarationTva;
    }

    public void setDeclarationTva(DeclarationTva declarationTva) {
        this.declarationTva = declarationTva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaiementDeclarationTva paiementDeclarationTva = (PaiementDeclarationTva) o;
        return id != null && id.equals(paiementDeclarationTva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

