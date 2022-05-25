package com.ird.faa.ws.rest.provided.vo;

public class DeclarationIsVo {

    private String id ;
    private String reference ;
    private String annee ;
    private String totalHtProduit ;
    private String totalHtCharge ;
    private String totalHtDifference ;
    private String montantIsCalcule ;
    private String montantIsAPaye ;
    private String totalAPaye ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String anneeMax ;
            private String anneeMin ;
            private String totalHtProduitMax ;
            private String totalHtProduitMin ;
            private String totalHtChargeMax ;
            private String totalHtChargeMin ;
            private String totalHtDifferenceMax ;
            private String totalHtDifferenceMin ;
            private String montantIsCalculeMax ;
            private String montantIsCalculeMin ;
            private String montantIsAPayeMax ;
            private String montantIsAPayeMin ;
            private String totalAPayeMax ;
            private String totalAPayeMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private SocieteVo societeVo ;
        private TauxIsVo tauxIsVo ;
        private TauxIsConfigVo tauxIsConfigVo ;
        private EtatDeclarationIsVo etatDeclarationIsVo ;
        private PaiementDeclarationIsVo paiementDeclarationIsVo ;


    public DeclarationIsVo(){
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
        public String getAnnee(){
        return this.annee;
        }

        public void setAnnee(String annee){
        this.annee = annee;
        }
        public String getTotalHtProduit(){
        return this.totalHtProduit;
        }

        public void setTotalHtProduit(String totalHtProduit){
        this.totalHtProduit = totalHtProduit;
        }
        public String getTotalHtCharge(){
        return this.totalHtCharge;
        }

        public void setTotalHtCharge(String totalHtCharge){
        this.totalHtCharge = totalHtCharge;
        }
        public String getTotalHtDifference(){
        return this.totalHtDifference;
        }

        public void setTotalHtDifference(String totalHtDifference){
        this.totalHtDifference = totalHtDifference;
        }
        public String getMontantIsCalcule(){
        return this.montantIsCalcule;
        }

        public void setMontantIsCalcule(String montantIsCalcule){
        this.montantIsCalcule = montantIsCalcule;
        }
        public String getMontantIsAPaye(){
        return this.montantIsAPaye;
        }

        public void setMontantIsAPaye(String montantIsAPaye){
        this.montantIsAPaye = montantIsAPaye;
        }
        public String getTotalAPaye(){
        return this.totalAPaye;
        }

        public void setTotalAPaye(String totalAPaye){
        this.totalAPaye = totalAPaye;
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

            public String getTotalHtProduitMax(){
            return this.totalHtProduitMax;
            }

            public String getTotalHtProduitMin(){
            return this.totalHtProduitMin;
            }

            public void setTotalHtProduitMax(String totalHtProduitMax){
            this.totalHtProduitMax = totalHtProduitMax;
            }

            public void setTotalHtProduitMin(String totalHtProduitMin){
            this.totalHtProduitMin = totalHtProduitMin;
            }

            public String getTotalHtChargeMax(){
            return this.totalHtChargeMax;
            }

            public String getTotalHtChargeMin(){
            return this.totalHtChargeMin;
            }

            public void setTotalHtChargeMax(String totalHtChargeMax){
            this.totalHtChargeMax = totalHtChargeMax;
            }

            public void setTotalHtChargeMin(String totalHtChargeMin){
            this.totalHtChargeMin = totalHtChargeMin;
            }

            public String getTotalHtDifferenceMax(){
            return this.totalHtDifferenceMax;
            }

            public String getTotalHtDifferenceMin(){
            return this.totalHtDifferenceMin;
            }

            public void setTotalHtDifferenceMax(String totalHtDifferenceMax){
            this.totalHtDifferenceMax = totalHtDifferenceMax;
            }

            public void setTotalHtDifferenceMin(String totalHtDifferenceMin){
            this.totalHtDifferenceMin = totalHtDifferenceMin;
            }

            public String getMontantIsCalculeMax(){
            return this.montantIsCalculeMax;
            }

            public String getMontantIsCalculeMin(){
            return this.montantIsCalculeMin;
            }

            public void setMontantIsCalculeMax(String montantIsCalculeMax){
            this.montantIsCalculeMax = montantIsCalculeMax;
            }

            public void setMontantIsCalculeMin(String montantIsCalculeMin){
            this.montantIsCalculeMin = montantIsCalculeMin;
            }

            public String getMontantIsAPayeMax(){
            return this.montantIsAPayeMax;
            }

            public String getMontantIsAPayeMin(){
            return this.montantIsAPayeMin;
            }

            public void setMontantIsAPayeMax(String montantIsAPayeMax){
            this.montantIsAPayeMax = montantIsAPayeMax;
            }

            public void setMontantIsAPayeMin(String montantIsAPayeMin){
            this.montantIsAPayeMin = montantIsAPayeMin;
            }

            public String getTotalAPayeMax(){
            return this.totalAPayeMax;
            }

            public String getTotalAPayeMin(){
            return this.totalAPayeMin;
            }

            public void setTotalAPayeMax(String totalAPayeMax){
            this.totalAPayeMax = totalAPayeMax;
            }

            public void setTotalAPayeMin(String totalAPayeMin){
            this.totalAPayeMin = totalAPayeMin;
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


        public SocieteVo getSocieteVo(){
        return this.societeVo;
        }

        public void setSocieteVo(SocieteVo societeVo){
        this.societeVo = societeVo;
        }
        public TauxIsVo getTauxIsVo(){
        return this.tauxIsVo;
        }

        public void setTauxIsVo(TauxIsVo tauxIsVo){
        this.tauxIsVo = tauxIsVo;
        }
        public TauxIsConfigVo getTauxIsConfigVo(){
        return this.tauxIsConfigVo;
        }

        public void setTauxIsConfigVo(TauxIsConfigVo tauxIsConfigVo){
        this.tauxIsConfigVo = tauxIsConfigVo;
        }
        public EtatDeclarationIsVo getEtatDeclarationIsVo(){
        return this.etatDeclarationIsVo;
        }

        public void setEtatDeclarationIsVo(EtatDeclarationIsVo etatDeclarationIsVo){
        this.etatDeclarationIsVo = etatDeclarationIsVo;
        }
        public PaiementDeclarationIsVo getPaiementDeclarationIsVo(){
        return this.paiementDeclarationIsVo;
        }

        public void setPaiementDeclarationIsVo(PaiementDeclarationIsVo paiementDeclarationIsVo){
        this.paiementDeclarationIsVo = paiementDeclarationIsVo;
        }


            }
