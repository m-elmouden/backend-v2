package com.ird.faa.ws.rest.provided.vo;

    import java.math.BigDecimal;

public class TvaVo {

    private String id ;
    private String reference ;
    private String pourcentage ;


            private String pourcentageMax ;
            private String pourcentageMin ;



    public TvaVo(){
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
        public String getPourcentage(){
        return this.pourcentage;
        }

        public void setPourcentage(String pourcentage){
        this.pourcentage = pourcentage;
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




            }
