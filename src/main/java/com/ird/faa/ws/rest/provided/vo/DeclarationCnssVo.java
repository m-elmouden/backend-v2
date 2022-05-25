package com.ird.faa.ws.rest.provided.vo;

    import java.util.List;

public class DeclarationCnssVo {

    private String id ;
    private String ref ;
    private String salaireNet ;
    private String salaireBrut ;
    private String salaireImposable ;
    private String montantTotal ;
    private String mois ;
    private String annee ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String salaireNetMax ;
            private String salaireNetMin ;
            private String salaireBrutMax ;
            private String salaireBrutMin ;
            private String salaireImposableMax ;
            private String salaireImposableMin ;
            private String montantTotalMax ;
            private String montantTotalMin ;
            private String moisMax ;
            private String moisMin ;
            private String anneeMax ;
            private String anneeMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private EmployeVo employeVo ;
        private SocieteVo societeVo ;

    private List<DeclarationCnssDetailVo> declarationCnssDetailsVo ;

    public DeclarationCnssVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getRef(){
        return this.ref;
        }

        public void setRef(String ref){
        this.ref = ref;
        }
        public String getSalaireNet(){
        return this.salaireNet;
        }

        public void setSalaireNet(String salaireNet){
        this.salaireNet = salaireNet;
        }
        public String getSalaireBrut(){
        return this.salaireBrut;
        }

        public void setSalaireBrut(String salaireBrut){
        this.salaireBrut = salaireBrut;
        }
        public String getSalaireImposable(){
        return this.salaireImposable;
        }

        public void setSalaireImposable(String salaireImposable){
        this.salaireImposable = salaireImposable;
        }
        public String getMontantTotal(){
        return this.montantTotal;
        }

        public void setMontantTotal(String montantTotal){
        this.montantTotal = montantTotal;
        }
        public String getMois(){
        return this.mois;
        }

        public void setMois(String mois){
        this.mois = mois;
        }
        public String getAnnee(){
        return this.annee;
        }

        public void setAnnee(String annee){
        this.annee = annee;
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


            public String getSalaireNetMax(){
            return this.salaireNetMax;
            }

            public String getSalaireNetMin(){
            return this.salaireNetMin;
            }

            public void setSalaireNetMax(String salaireNetMax){
            this.salaireNetMax = salaireNetMax;
            }

            public void setSalaireNetMin(String salaireNetMin){
            this.salaireNetMin = salaireNetMin;
            }

            public String getSalaireBrutMax(){
            return this.salaireBrutMax;
            }

            public String getSalaireBrutMin(){
            return this.salaireBrutMin;
            }

            public void setSalaireBrutMax(String salaireBrutMax){
            this.salaireBrutMax = salaireBrutMax;
            }

            public void setSalaireBrutMin(String salaireBrutMin){
            this.salaireBrutMin = salaireBrutMin;
            }

            public String getSalaireImposableMax(){
            return this.salaireImposableMax;
            }

            public String getSalaireImposableMin(){
            return this.salaireImposableMin;
            }

            public void setSalaireImposableMax(String salaireImposableMax){
            this.salaireImposableMax = salaireImposableMax;
            }

            public void setSalaireImposableMin(String salaireImposableMin){
            this.salaireImposableMin = salaireImposableMin;
            }

            public String getMontantTotalMax(){
            return this.montantTotalMax;
            }

            public String getMontantTotalMin(){
            return this.montantTotalMin;
            }

            public void setMontantTotalMax(String montantTotalMax){
            this.montantTotalMax = montantTotalMax;
            }

            public void setMontantTotalMin(String montantTotalMin){
            this.montantTotalMin = montantTotalMin;
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


        public EmployeVo getEmployeVo(){
        return this.employeVo;
        }

        public void setEmployeVo(EmployeVo employeVo){
        this.employeVo = employeVo;
        }
        public SocieteVo getSocieteVo(){
        return this.societeVo;
        }

        public void setSocieteVo(SocieteVo societeVo){
        this.societeVo = societeVo;
        }


        public List<DeclarationCnssDetailVo> getDeclarationCnssDetailsVo(){
        return this.declarationCnssDetailsVo;
        }

        public void setDeclarationCnssDetailsVo(List<DeclarationCnssDetailVo> declarationCnssDetailsVo){
            this.declarationCnssDetailsVo = declarationCnssDetailsVo;
            }

            }
