package com.ird.faa.ws.rest.provided.vo;

public class EmployeVo {

    private String id ;
    private String cin ;
    private String nom ;
    private String prenom ;
    private String totalSalaireNet ;
    private String nombreFamille ;


            private String totalSalaireNetMax ;
            private String totalSalaireNetMin ;
            private String nombreFamilleMax ;
            private String nombreFamilleMin ;

        private TypeEmployeVo typeEmployeVo ;
        private SocieteVo societeVo ;
        private DeclarationCnssVo declarationCnssVo ;


    public EmployeVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getCin(){
        return this.cin;
        }

        public void setCin(String cin){
        this.cin = cin;
        }
        public String getNom(){
        return this.nom;
        }

        public void setNom(String nom){
        this.nom = nom;
        }
        public String getPrenom(){
        return this.prenom;
        }

        public void setPrenom(String prenom){
        this.prenom = prenom;
        }
        public String getTotalSalaireNet(){
        return this.totalSalaireNet;
        }

        public void setTotalSalaireNet(String totalSalaireNet){
        this.totalSalaireNet = totalSalaireNet;
        }
        public String getNombreFamille(){
        return this.nombreFamille;
        }

        public void setNombreFamille(String nombreFamille){
        this.nombreFamille = nombreFamille;
        }


            public String getTotalSalaireNetMax(){
            return this.totalSalaireNetMax;
            }

            public String getTotalSalaireNetMin(){
            return this.totalSalaireNetMin;
            }

            public void setTotalSalaireNetMax(String totalSalaireNetMax){
            this.totalSalaireNetMax = totalSalaireNetMax;
            }

            public void setTotalSalaireNetMin(String totalSalaireNetMin){
            this.totalSalaireNetMin = totalSalaireNetMin;
            }

            public String getNombreFamilleMax(){
            return this.nombreFamilleMax;
            }

            public String getNombreFamilleMin(){
            return this.nombreFamilleMin;
            }

            public void setNombreFamilleMax(String nombreFamilleMax){
            this.nombreFamilleMax = nombreFamilleMax;
            }

            public void setNombreFamilleMin(String nombreFamilleMin){
            this.nombreFamilleMin = nombreFamilleMin;
            }


        public TypeEmployeVo getTypeEmployeVo(){
        return this.typeEmployeVo;
        }

        public void setTypeEmployeVo(TypeEmployeVo typeEmployeVo){
        this.typeEmployeVo = typeEmployeVo;
        }
        public SocieteVo getSocieteVo(){
        return this.societeVo;
        }

        public void setSocieteVo(SocieteVo societeVo){
        this.societeVo = societeVo;
        }
        public DeclarationCnssVo getDeclarationCnssVo(){
        return this.declarationCnssVo;
        }

        public void setDeclarationCnssVo(DeclarationCnssVo declarationCnssVo){
        this.declarationCnssVo = declarationCnssVo;
        }


            }
