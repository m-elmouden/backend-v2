package com.ird.faa.ws.rest.provided.vo;

public class TauxIsVo {

    private String id ;
    private String reference ;
    private String resultatFiscalMin ;
    private String resultatFiscalMax ;
    private String pourcentage ;
    private String penalite ;


            private String resultatFiscalMinMax ;
            private String resultatFiscalMinMin ;
            private String resultatFiscalMaxMax ;
            private String resultatFiscalMaxMin ;
            private String pourcentageMax ;
            private String pourcentageMin ;
            private String penaliteMax ;
            private String penaliteMin ;

        private TauxIsConfigVo tauxIsConfigVo ;


    public TauxIsVo(){
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
        public String getResultatFiscalMin(){
        return this.resultatFiscalMin;
        }

        public void setResultatFiscalMin(String resultatFiscalMin){
        this.resultatFiscalMin = resultatFiscalMin;
        }
        public String getResultatFiscalMax(){
        return this.resultatFiscalMax;
        }

        public void setResultatFiscalMax(String resultatFiscalMax){
        this.resultatFiscalMax = resultatFiscalMax;
        }
        public String getPourcentage(){
        return this.pourcentage;
        }

        public void setPourcentage(String pourcentage){
        this.pourcentage = pourcentage;
        }
        public String getPenalite(){
        return this.penalite;
        }

        public void setPenalite(String penalite){
        this.penalite = penalite;
        }


            public String getResultatFiscalMinMax(){
            return this.resultatFiscalMinMax;
            }

            public String getResultatFiscalMinMin(){
            return this.resultatFiscalMinMin;
            }

            public void setResultatFiscalMinMax(String resultatFiscalMinMax){
            this.resultatFiscalMinMax = resultatFiscalMinMax;
            }

            public void setResultatFiscalMinMin(String resultatFiscalMinMin){
            this.resultatFiscalMinMin = resultatFiscalMinMin;
            }

            public String getResultatFiscalMaxMax(){
            return this.resultatFiscalMaxMax;
            }

            public String getResultatFiscalMaxMin(){
            return this.resultatFiscalMaxMin;
            }

            public void setResultatFiscalMaxMax(String resultatFiscalMaxMax){
            this.resultatFiscalMaxMax = resultatFiscalMaxMax;
            }

            public void setResultatFiscalMaxMin(String resultatFiscalMaxMin){
            this.resultatFiscalMaxMin = resultatFiscalMaxMin;
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

            public String getPenaliteMax(){
            return this.penaliteMax;
            }

            public String getPenaliteMin(){
            return this.penaliteMin;
            }

            public void setPenaliteMax(String penaliteMax){
            this.penaliteMax = penaliteMax;
            }

            public void setPenaliteMin(String penaliteMin){
            this.penaliteMin = penaliteMin;
            }


        public TauxIsConfigVo getTauxIsConfigVo(){
        return this.tauxIsConfigVo;
        }

        public void setTauxIsConfigVo(TauxIsConfigVo tauxIsConfigVo){
        this.tauxIsConfigVo = tauxIsConfigVo;
        }


            }
