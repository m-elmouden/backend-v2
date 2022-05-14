package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "declaration_tva")
public class DeclarationTva    implements Archivable  {

@Id
    @SequenceGenerator(name="declaration_tva_seq",sequenceName="declaration_tva_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="declaration_tva_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            private BigDecimal tvacollecter ;
            private BigDecimal tvaperdue ;
            private BigDecimal differenceTva ;
            private BigDecimal montantTvaCalcule ;
            private BigDecimal montantTvaAPaye ;
            private BigDecimal annee ;
            private BigDecimal mois ;
            private BigDecimal trimestre ;
            @Column(columnDefinition = "boolean default false")
                 private Boolean archive = false;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateArchivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;
            @Column(columnDefinition = "boolean default false")
                 private Boolean admin = false;
            @Column(columnDefinition = "boolean default false")
                 private Boolean visible = false;
            @Column(length = 500)
            private String username;

    @ManyToOne
    private Societe societe ;
    @ManyToOne
    private TypeDeclarationTva typeDeclarationTva ;
    @ManyToOne
    private EtatDeclarationTva etatDeclarationTva ;
    @ManyToOne
    private PaiementDeclarationTva paiementDeclarationTva ;


public DeclarationTva(){
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
            public BigDecimal getTvacollecter(){
            return this.tvacollecter;
            }
            public void setTvacollecter(BigDecimal tvacollecter){
            this.tvacollecter = tvacollecter;
            }
            public BigDecimal getTvaperdue(){
            return this.tvaperdue;
            }
            public void setTvaperdue(BigDecimal tvaperdue){
            this.tvaperdue = tvaperdue;
            }
            public BigDecimal getDifferenceTva(){
            return this.differenceTva;
            }
            public void setDifferenceTva(BigDecimal differenceTva){
            this.differenceTva = differenceTva;
            }
            public BigDecimal getMontantTvaCalcule(){
            return this.montantTvaCalcule;
            }
            public void setMontantTvaCalcule(BigDecimal montantTvaCalcule){
            this.montantTvaCalcule = montantTvaCalcule;
            }
            public BigDecimal getMontantTvaAPaye(){
            return this.montantTvaAPaye;
            }
            public void setMontantTvaAPaye(BigDecimal montantTvaAPaye){
            this.montantTvaAPaye = montantTvaAPaye;
            }
            public BigDecimal getAnnee(){
            return this.annee;
            }
            public void setAnnee(BigDecimal annee){
            this.annee = annee;
            }
            public BigDecimal getMois(){
            return this.mois;
            }
            public void setMois(BigDecimal mois){
            this.mois = mois;
            }
            public BigDecimal getTrimestre(){
            return this.trimestre;
            }
            public void setTrimestre(BigDecimal trimestre){
            this.trimestre = trimestre;
            }
            public Societe getSociete(){
            return this.societe;
            }
            public void setSociete(Societe societe){
            this.societe = societe;
            }
            public TypeDeclarationTva getTypeDeclarationTva(){
            return this.typeDeclarationTva;
            }
            public void setTypeDeclarationTva(TypeDeclarationTva typeDeclarationTva){
            this.typeDeclarationTva = typeDeclarationTva;
            }
            public EtatDeclarationTva getEtatDeclarationTva(){
            return this.etatDeclarationTva;
            }
            public void setEtatDeclarationTva(EtatDeclarationTva etatDeclarationTva){
            this.etatDeclarationTva = etatDeclarationTva;
            }
            public PaiementDeclarationTva getPaiementDeclarationTva(){
            return this.paiementDeclarationTva;
            }
            public void setPaiementDeclarationTva(PaiementDeclarationTva paiementDeclarationTva){
            this.paiementDeclarationTva = paiementDeclarationTva;
            }
        public Boolean  getArchive(){
        return this.archive;
        }
        public void setArchive(Boolean archive){
        this.archive = archive;
        }
            public Date getDateArchivage(){
            return this.dateArchivage;
            }
            public void setDateArchivage(Date dateArchivage){
            this.dateArchivage = dateArchivage;
            }
            public Date getDateCreation(){
            return this.dateCreation;
            }
            public void setDateCreation(Date dateCreation){
            this.dateCreation = dateCreation;
            }
        public Boolean  getAdmin(){
        return this.admin;
        }
        public void setAdmin(Boolean admin){
        this.admin = admin;
        }
        public Boolean  getVisible(){
        return this.visible;
        }
        public void setVisible(Boolean visible){
        this.visible = visible;
        }
            public String getUsername(){
            return this.username;
            }
            public void setUsername(String username){
            this.username = username;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationTva declarationTva = (DeclarationTva) o;
        return id != null && id.equals(declarationTva.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

