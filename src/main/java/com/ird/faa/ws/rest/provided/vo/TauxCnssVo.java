package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;

public class TauxCnssVo {

    private String id ;
    private String ref ;
    private String dateApplicationMin ;
    private String dateApplicationMax ;
    private String plafond ;
    private String pourcentage ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String dateApplicationMinMax ;
            private String dateApplicationMinMin ;
            private String dateApplicationMaxMax ;
            private String dateApplicationMaxMin ;
            private String plafondMax ;
            private String plafondMin ;
            private String pourcentageMax ;
            private String pourcentageMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private TypeTauxCnssVo typeTauxCnssVo ;


    public TauxCnssVo(){
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
        public String getDateApplicationMin(){
        return this.dateApplicationMin;
        }

        public void setDateApplicationMin(String dateApplicationMin){
        this.dateApplicationMin = dateApplicationMin;
        }
        public String getDateApplicationMax(){
        return this.dateApplicationMax;
        }

        public void setDateApplicationMax(String dateApplicationMax){
        this.dateApplicationMax = dateApplicationMax;
        }
        public String getPlafond(){
        return this.plafond;
        }

        public void setPlafond(String plafond){
        this.plafond = plafond;
        }
        public String getPourcentage(){
        return this.pourcentage;
        }

        public void setPourcentage(String pourcentage){
        this.pourcentage = pourcentage;
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


            public String getDateApplicationMinMax(){
            return this.dateApplicationMinMax;
            }

            public String getDateApplicationMinMin(){
            return this.dateApplicationMinMin;
            }

            public void setDateApplicationMinMax(String dateApplicationMinMax){
            this.dateApplicationMinMax = dateApplicationMinMax;
            }

            public void setDateApplicationMinMin(String dateApplicationMinMin){
            this.dateApplicationMinMin = dateApplicationMinMin;
            }

            public String getDateApplicationMaxMax(){
            return this.dateApplicationMaxMax;
            }

            public String getDateApplicationMaxMin(){
            return this.dateApplicationMaxMin;
            }

            public void setDateApplicationMaxMax(String dateApplicationMaxMax){
            this.dateApplicationMaxMax = dateApplicationMaxMax;
            }

            public void setDateApplicationMaxMin(String dateApplicationMaxMin){
            this.dateApplicationMaxMin = dateApplicationMaxMin;
            }

            public String getPlafondMax(){
            return this.plafondMax;
            }

            public String getPlafondMin(){
            return this.plafondMin;
            }

            public void setPlafondMax(String plafondMax){
            this.plafondMax = plafondMax;
            }

            public void setPlafondMin(String plafondMin){
            this.plafondMin = plafondMin;
            }

            public String getPourcentageMax(){
            return this.pourcentageMax;
            }

            public String getPourcentageMin(){
            return this.pourcentageMin;
            }

            public void setPourcentageMax(String pourcentageMax){
            this.pourcentageMax = pourcentageMax;
            }

            public void setPourcentageMin(String pourcentageMin){
            this.pourcentageMin = pourcentageMin;
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


        public TypeTauxCnssVo getTypeTauxCnssVo(){
        return this.typeTauxCnssVo;
        }

        public void setTypeTauxCnssVo(TypeTauxCnssVo typeTauxCnssVo){
        this.typeTauxCnssVo = typeTauxCnssVo;
        }


            }
