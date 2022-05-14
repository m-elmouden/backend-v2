package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "facture")
public class Facture    implements Archivable  {

@Id
    @SequenceGenerator(name="facture_seq",sequenceName="facture_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="facture_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String libelle;
            private BigDecimal montantHorsTaxe ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateOperation ;
            private BigDecimal annee ;
            private BigDecimal mois ;
            private BigDecimal trimestre ;
            private BigDecimal montantTtc ;
            private BigDecimal montantTva ;
            @Column(length = 500)
            private String credit;
            @Column(length = 500)
            private String debit;
            @OneToOne
            private FacturePieceJointe facturePieceJointe ;
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
    private Tva tva ;
    @ManyToOne
    private TypeOperationFacture typeOperationFacture ;
    @ManyToOne
    private EtatFacture etatFacture ;
    @ManyToOne
    private EtatPaiement etatPaiement ;
    @ManyToOne
    private Societe societe ;
    @ManyToOne
    private CompteComptable compteComptable ;
    @ManyToOne
    private DeclarationIs declarationIs ;
    @ManyToOne
    private DeclarationTva declarationTva ;
    @ManyToOne
    private Demande demande ;
    @ManyToOne
    private ClasseComptable classeComptable ;
    @ManyToOne
    private CpcFacture cpcFacture ;


public Facture(){
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
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public BigDecimal getMontantHorsTaxe(){
            return this.montantHorsTaxe;
            }
            public void setMontantHorsTaxe(BigDecimal montantHorsTaxe){
            this.montantHorsTaxe = montantHorsTaxe;
            }
            public Date getDateOperation(){
            return this.dateOperation;
            }
            public void setDateOperation(Date dateOperation){
            this.dateOperation = dateOperation;
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
            public BigDecimal getMontantTtc(){
            return this.montantTtc;
            }
            public void setMontantTtc(BigDecimal montantTtc){
            this.montantTtc = montantTtc;
            }
            public BigDecimal getMontantTva(){
            return this.montantTva;
            }
            public void setMontantTva(BigDecimal montantTva){
            this.montantTva = montantTva;
            }
            public String getCredit(){
            return this.credit;
            }
            public void setCredit(String credit){
            this.credit = credit;
            }
            public String getDebit(){
            return this.debit;
            }
            public void setDebit(String debit){
            this.debit = debit;
            }
            public FacturePieceJointe getFacturePieceJointe(){
            return this.facturePieceJointe;
            }
            public void setFacturePieceJointe(FacturePieceJointe facturePieceJointe){
            this.facturePieceJointe = facturePieceJointe;
            }
            public Tva getTva(){
            return this.tva;
            }
            public void setTva(Tva tva){
            this.tva = tva;
            }
            public TypeOperationFacture getTypeOperationFacture(){
            return this.typeOperationFacture;
            }
            public void setTypeOperationFacture(TypeOperationFacture typeOperationFacture){
            this.typeOperationFacture = typeOperationFacture;
            }
            public EtatFacture getEtatFacture(){
            return this.etatFacture;
            }
            public void setEtatFacture(EtatFacture etatFacture){
            this.etatFacture = etatFacture;
            }
            public EtatPaiement getEtatPaiement(){
            return this.etatPaiement;
            }
            public void setEtatPaiement(EtatPaiement etatPaiement){
            this.etatPaiement = etatPaiement;
            }
            public Societe getSociete(){
            return this.societe;
            }
            public void setSociete(Societe societe){
            this.societe = societe;
            }
            public CompteComptable getCompteComptable(){
            return this.compteComptable;
            }
            public void setCompteComptable(CompteComptable compteComptable){
            this.compteComptable = compteComptable;
            }
            public DeclarationIs getDeclarationIs(){
            return this.declarationIs;
            }
            public void setDeclarationIs(DeclarationIs declarationIs){
            this.declarationIs = declarationIs;
            }
            public DeclarationTva getDeclarationTva(){
            return this.declarationTva;
            }
            public void setDeclarationTva(DeclarationTva declarationTva){
            this.declarationTva = declarationTva;
            }
            public Demande getDemande(){
            return this.demande;
            }
            public void setDemande(Demande demande){
            this.demande = demande;
            }
            public ClasseComptable getClasseComptable(){
            return this.classeComptable;
            }
            public void setClasseComptable(ClasseComptable classeComptable){
            this.classeComptable = classeComptable;
            }
            public CpcFacture getCpcFacture(){
            return this.cpcFacture;
            }
            public void setCpcFacture(CpcFacture cpcFacture){
            this.cpcFacture = cpcFacture;
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
        Facture facture = (Facture) o;
        return id != null && id.equals(facture.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

