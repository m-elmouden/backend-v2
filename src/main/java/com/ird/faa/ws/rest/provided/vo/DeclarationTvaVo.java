package com.ird.faa.ws.rest.provided.vo;

public class DeclarationTvaVo {

    private String id ;
    private String reference ;
    private String tvacollecter ;
    private String tvaperdue ;
    private String differenceTva ;
    private String montantTvaCalcule ;
    private String montantTvaAPaye ;
    private String annee ;
    private String mois ;
    private String trimestre ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String tvacollecterMax ;
            private String tvacollecterMin ;
            private String tvaperdueMax ;
            private String tvaperdueMin ;
            private String differenceTvaMax ;
            private String differenceTvaMin ;
            private String montantTvaCalculeMax ;
            private String montantTvaCalculeMin ;
            private String montantTvaAPayeMax ;
            private String montantTvaAPayeMin ;
            private String anneeMax ;
            private String anneeMin ;
            private String moisMax ;
            private String moisMin ;
            private String trimestreMax ;
            private String trimestreMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private SocieteVo societeVo ;
        private TypeDeclarationTvaVo typeDeclarationTvaVo ;
        private EtatDeclarationTvaVo etatDeclarationTvaVo ;
        private PaiementDeclarationTvaVo paiementDeclarationTvaVo ;


    public DeclarationTvaVo(){
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
        public String getTvacollecter(){
        return this.tvacollecter;
        }

        public void setTvacollecter(String tvacollecter){
        this.tvacollecter = tvacollecter;
        }
        public String getTvaperdue(){
        return this.tvaperdue;
        }

        public void setTvaperdue(String tvaperdue){
        this.tvaperdue = tvaperdue;
        }
        public String getDifferenceTva(){
        return this.differenceTva;
        }

        public void setDifferenceTva(String differenceTva){
        this.differenceTva = differenceTva;
        }
        public String getMontantTvaCalcule(){
        return this.montantTvaCalcule;
        }

        public void setMontantTvaCalcule(String montantTvaCalcule){
        this.montantTvaCalcule = montantTvaCalcule;
        }
        public String getMontantTvaAPaye(){
        return this.montantTvaAPaye;
        }

        public void setMontantTvaAPaye(String montantTvaAPaye){
        this.montantTvaAPaye = montantTvaAPaye;
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


            public String getTvacollecterMax(){
            return this.tvacollecterMax;
            }

            public String getTvacollecterMin(){
            return this.tvacollecterMin;
            }

            public void setTvacollecterMax(String tvacollecterMax){
            this.tvacollecterMax = tvacollecterMax;
            }

            public void setTvacollecterMin(String tvacollecterMin){
            this.tvacollecterMin = tvacollecterMin;
            }

            public String getTvaperdueMax(){
            return this.tvaperdueMax;
            }

            public String getTvaperdueMin(){
            return this.tvaperdueMin;
            }

            public void setTvaperdueMax(String tvaperdueMax){
            this.tvaperdueMax = tvaperdueMax;
            }

            public void setTvaperdueMin(String tvaperdueMin){
            this.tvaperdueMin = tvaperdueMin;
            }

            public String getDifferenceTvaMax(){
            return this.differenceTvaMax;
            }

            public String getDifferenceTvaMin(){
            return this.differenceTvaMin;
            }

            public void setDifferenceTvaMax(String differenceTvaMax){
            this.differenceTvaMax = differenceTvaMax;
            }

            public void setDifferenceTvaMin(String differenceTvaMin){
            this.differenceTvaMin = differenceTvaMin;
            }

            public String getMontantTvaCalculeMax(){
            return this.montantTvaCalculeMax;
            }

            public String getMontantTvaCalculeMin(){
            return this.montantTvaCalculeMin;
            }

            public void setMontantTvaCalculeMax(String montantTvaCalculeMax){
            this.montantTvaCalculeMax = montantTvaCalculeMax;
            }

            public void setMontantTvaCalculeMin(String montantTvaCalculeMin){
            this.montantTvaCalculeMin = montantTvaCalculeMin;
            }

            public String getMontantTvaAPayeMax(){
            return this.montantTvaAPayeMax;
            }

            public String getMontantTvaAPayeMin(){
            return this.montantTvaAPayeMin;
            }

            public void setMontantTvaAPayeMax(String montantTvaAPayeMax){
            this.montantTvaAPayeMax = montantTvaAPayeMax;
            }

            public void setMontantTvaAPayeMin(String montantTvaAPayeMin){
            this.montantTvaAPayeMin = montantTvaAPayeMin;
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
        public TypeDeclarationTvaVo getTypeDeclarationTvaVo(){
        return this.typeDeclarationTvaVo;
        }

        public void setTypeDeclarationTvaVo(TypeDeclarationTvaVo typeDeclarationTvaVo){
        this.typeDeclarationTvaVo = typeDeclarationTvaVo;
        }
        public EtatDeclarationTvaVo getEtatDeclarationTvaVo(){
        return this.etatDeclarationTvaVo;
        }

        public void setEtatDeclarationTvaVo(EtatDeclarationTvaVo etatDeclarationTvaVo){
        this.etatDeclarationTvaVo = etatDeclarationTvaVo;
        }
        public PaiementDeclarationTvaVo getPaiementDeclarationTvaVo(){
        return this.paiementDeclarationTvaVo;
        }

        public void setPaiementDeclarationTvaVo(PaiementDeclarationTvaVo paiementDeclarationTvaVo){
        this.paiementDeclarationTvaVo = paiementDeclarationTvaVo;
        }


            }
