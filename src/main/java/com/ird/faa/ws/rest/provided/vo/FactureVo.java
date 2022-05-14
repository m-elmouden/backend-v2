package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;

public class FactureVo {

    private String id ;
    private String reference ;
    private String libelle ;
    private String montantHorsTaxe ;
    private String dateOperation ;
    private String annee ;
    private String mois ;
    private String trimestre ;
    private String montantTtc ;
    private String montantTva ;
    private String credit ;
    private String debit ;
    private String facturePieceJointe ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String montantHorsTaxeMax ;
            private String montantHorsTaxeMin ;
            private String dateOperationMax ;
            private String dateOperationMin ;
            private String anneeMax ;
            private String anneeMin ;
            private String moisMax ;
            private String moisMin ;
            private String trimestreMax ;
            private String trimestreMin ;
            private String montantTtcMax ;
            private String montantTtcMin ;
            private String montantTvaMax ;
            private String montantTvaMin ;
            private String facturePieceJointeMax ;
            private String facturePieceJointeMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private TvaVo tvaVo ;
        private TypeOperationFactureVo typeOperationFactureVo ;
        private EtatFactureVo etatFactureVo ;
        private EtatPaiementVo etatPaiementVo ;
        private SocieteVo societeVo ;
        private CompteComptableVo compteComptableVo ;
        private DeclarationIsVo declarationIsVo ;
        private DeclarationTvaVo declarationTvaVo ;
        private DemandeVo demandeVo ;
        private ClasseComptableVo classeComptableVo ;
        private CpcFactureVo cpcFactureVo ;
        private FacturePieceJointeVo facturePieceJointeVo;


    public FactureVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
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
        public String getMontantHorsTaxe(){
        return this.montantHorsTaxe;
        }

        public void setMontantHorsTaxe(String montantHorsTaxe){
        this.montantHorsTaxe = montantHorsTaxe;
        }
        public String getDateOperation(){
        return this.dateOperation;
        }

        public void setDateOperation(String dateOperation){
        this.dateOperation = dateOperation;
        }
        public String getAnnee(){
        return this.annee;
        }

        public void setAnnee(String annee){
        this.annee = annee;
        }
        public String getMois(){
        return this.mois;
        }

        public void setMois(String mois){
        this.mois = mois;
        }
        public String getTrimestre(){
        return this.trimestre;
        }

        public void setTrimestre(String trimestre){
        this.trimestre = trimestre;
        }
        public String getMontantTtc(){
        return this.montantTtc;
        }

        public void setMontantTtc(String montantTtc){
        this.montantTtc = montantTtc;
        }
        public String getMontantTva(){
        return this.montantTva;
        }

        public void setMontantTva(String montantTva){
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
        public FacturePieceJointeVo getFacturePieceJointeVo(){
        return this.facturePieceJointeVo;
        }

        public void setFacturePieceJointe(String facturePieceJointe){
        this.facturePieceJointe = facturePieceJointe;
        }
        public Boolean getArchive(){
        return this.archive;
        }

        public void setArchive(Boolean archive){
        this.archive = archive;
        }
        public String getDateArchivage(){
        return this.dateArchivage;
        }

        public void setDateArchivage(String dateArchivage){
        this.dateArchivage = dateArchivage;
        }
        public String getDateCreation(){
        return this.dateCreation;
        }

        public void setDateCreation(String dateCreation){
        this.dateCreation = dateCreation;
        }
        public Boolean getAdmin(){
        return this.admin;
        }

        public void setAdmin(Boolean admin){
        this.admin = admin;
        }
        public Boolean getVisible(){
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


            public String getMontantHorsTaxeMax(){
            return this.montantHorsTaxeMax;
            }

            public String getMontantHorsTaxeMin(){
            return this.montantHorsTaxeMin;
            }

            public void setMontantHorsTaxeMax(String montantHorsTaxeMax){
            this.montantHorsTaxeMax = montantHorsTaxeMax;
            }

            public void setMontantHorsTaxeMin(String montantHorsTaxeMin){
            this.montantHorsTaxeMin = montantHorsTaxeMin;
            }

            public String getDateOperationMax(){
            return this.dateOperationMax;
            }

            public String getDateOperationMin(){
            return this.dateOperationMin;
            }

            public void setDateOperationMax(String dateOperationMax){
            this.dateOperationMax = dateOperationMax;
            }

            public void setDateOperationMin(String dateOperationMin){
            this.dateOperationMin = dateOperationMin;
            }

            public String getAnneeMax(){
            return this.anneeMax;
            }

            public String getAnneeMin(){
            return this.anneeMin;
            }

            public void setAnneeMax(String anneeMax){
            this.anneeMax = anneeMax;
            }

            public void setAnneeMin(String anneeMin){
            this.anneeMin = anneeMin;
            }

            public String getMoisMax(){
            return this.moisMax;
            }

            public String getMoisMin(){
            return this.moisMin;
            }

            public void setMoisMax(String moisMax){
            this.moisMax = moisMax;
            }

            public void setMoisMin(String moisMin){
            this.moisMin = moisMin;
            }

            public String getTrimestreMax(){
            return this.trimestreMax;
            }

            public String getTrimestreMin(){
            return this.trimestreMin;
            }

            public void setTrimestreMax(String trimestreMax){
            this.trimestreMax = trimestreMax;
            }

            public void setTrimestreMin(String trimestreMin){
            this.trimestreMin = trimestreMin;
            }

            public String getMontantTtcMax(){
            return this.montantTtcMax;
            }

            public String getMontantTtcMin(){
            return this.montantTtcMin;
            }

            public void setMontantTtcMax(String montantTtcMax){
            this.montantTtcMax = montantTtcMax;
            }

            public void setMontantTtcMin(String montantTtcMin){
            this.montantTtcMin = montantTtcMin;
            }

            public String getMontantTvaMax(){
            return this.montantTvaMax;
            }

            public String getMontantTvaMin(){
            return this.montantTvaMin;
            }

            public void setMontantTvaMax(String montantTvaMax){
            this.montantTvaMax = montantTvaMax;
            }

            public void setMontantTvaMin(String montantTvaMin){
            this.montantTvaMin = montantTvaMin;
            }

            public String getFacturePieceJointeMax(){
            return this.facturePieceJointeMax;
            }

            public String getFacturePieceJointeMin(){
            return this.facturePieceJointeMin;
            }

            public void setFacturePieceJointeMax(String facturePieceJointeMax){
            this.facturePieceJointeMax = facturePieceJointeMax;
            }

            public void setFacturePieceJointeMin(String facturePieceJointeMin){
            this.facturePieceJointeMin = facturePieceJointeMin;
            }

            public String getDateArchivageMax(){
            return this.dateArchivageMax;
            }

            public String getDateArchivageMin(){
            return this.dateArchivageMin;
            }

            public void setDateArchivageMax(String dateArchivageMax){
            this.dateArchivageMax = dateArchivageMax;
            }

            public void setDateArchivageMin(String dateArchivageMin){
            this.dateArchivageMin = dateArchivageMin;
            }

            public String getDateCreationMax(){
            return this.dateCreationMax;
            }

            public String getDateCreationMin(){
            return this.dateCreationMin;
            }

            public void setDateCreationMax(String dateCreationMax){
            this.dateCreationMax = dateCreationMax;
            }

            public void setDateCreationMin(String dateCreationMin){
            this.dateCreationMin = dateCreationMin;
            }


        public TvaVo getTvaVo(){
        return this.tvaVo;
        }

        public void setTvaVo(TvaVo tvaVo){
        this.tvaVo = tvaVo;
        }
        public void setFacturePieceJointeVo(FacturePieceJointeVo facturePieceJointeVo){
        this.facturePieceJointeVo = facturePieceJointeVo;
        }
        public TypeOperationFactureVo getTypeOperationFactureVo(){
        return this.typeOperationFactureVo;
        }

        public void setTypeOperationFactureVo(TypeOperationFactureVo typeOperationFactureVo){
        this.typeOperationFactureVo = typeOperationFactureVo;
        }
        public EtatFactureVo getEtatFactureVo(){
        return this.etatFactureVo;
        }

        public void setEtatFactureVo(EtatFactureVo etatFactureVo){
        this.etatFactureVo = etatFactureVo;
        }
        public EtatPaiementVo getEtatPaiementVo(){
        return this.etatPaiementVo;
        }

        public void setEtatPaiementVo(EtatPaiementVo etatPaiementVo){
        this.etatPaiementVo = etatPaiementVo;
        }
        public SocieteVo getSocieteVo(){
        return this.societeVo;
        }

        public void setSocieteVo(SocieteVo societeVo){
        this.societeVo = societeVo;
        }
        public CompteComptableVo getCompteComptableVo(){
        return this.compteComptableVo;
        }

        public void setCompteComptableVo(CompteComptableVo compteComptableVo){
        this.compteComptableVo = compteComptableVo;
        }
        public DeclarationIsVo getDeclarationIsVo(){
        return this.declarationIsVo;
        }

        public void setDeclarationIsVo(DeclarationIsVo declarationIsVo){
        this.declarationIsVo = declarationIsVo;
        }
        public DeclarationTvaVo getDeclarationTvaVo(){
        return this.declarationTvaVo;
        }

        public void setDeclarationTvaVo(DeclarationTvaVo declarationTvaVo){
        this.declarationTvaVo = declarationTvaVo;
        }
        public DemandeVo getDemandeVo(){
        return this.demandeVo;
        }

        public void setDemandeVo(DemandeVo demandeVo){
        this.demandeVo = demandeVo;
        }
        public ClasseComptableVo getClasseComptableVo(){
        return this.classeComptableVo;
        }

        public void setClasseComptableVo(ClasseComptableVo classeComptableVo){
        this.classeComptableVo = classeComptableVo;
        }
        public CpcFactureVo getCpcFactureVo(){
        return this.cpcFactureVo;
        }

        public void setCpcFactureVo(CpcFactureVo cpcFactureVo){
        this.cpcFactureVo = cpcFactureVo;
        }


            }
