package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "paiement_declaration_ir")
public class PaiementDeclarationIr   {

@Id
    @SequenceGenerator(name="paiement_declaration_ir_seq",sequenceName="paiement_declaration_ir_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_declaration_ir_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date datePaiement ;
            private BigDecimal total ;
            private BigDecimal montantCptTraiteur ;
            private BigDecimal montantCptValidateur ;
            private BigDecimal reste ;

    @ManyToOne
    private DeclarationIr declarationIr ;


public PaiementDeclarationIr(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getReference(){
            return this.reference;
            }
            public void setReference(String reference){
            this.reference = reference;
            }
            public Date getDatePaiement(){
            return this.datePaiement;
            }
            public void setDatePaiement(Date datePaiement){
            this.datePaiement = datePaiement;
            }
            public BigDecimal getTotal(){
            return this.total;
            }
            public void setTotal(BigDecimal total){
            this.total = total;
            }
            public BigDecimal getMontantCptTraiteur(){
            return this.montantCptTraiteur;
            }
            public void setMontantCptTraiteur(BigDecimal montantCptTraiteur){
            this.montantCptTraiteur = montantCptTraiteur;
            }
            public BigDecimal getMontantCptValidateur(){
            return this.montantCptValidateur;
            }
            public void setMontantCptValidateur(BigDecimal montantCptValidateur){
            this.montantCptValidateur = montantCptValidateur;
            }
            public BigDecimal getReste(){
            return this.reste;
            }
            public void setReste(BigDecimal reste){
            this.reste = reste;
            }
            public DeclarationIr getDeclarationIr(){
            return this.declarationIr;
            }
            public void setDeclarationIr(DeclarationIr declarationIr){
            this.declarationIr = declarationIr;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaiementDeclarationIr paiementDeclarationIr = (PaiementDeclarationIr) o;
        return id != null && id.equals(paiementDeclarationIr.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

