package com.ird.faa.ws.rest.provided.vo;

    import java.util.List;

public class TauxIsConfigVo {

    private String id ;
    private String reference ;
    private String cotisationMinimale ;
    private String dateMin ;
    private String dateMax ;


            private String cotisationMinimaleMax ;
            private String cotisationMinimaleMin ;
            private String dateMinMax ;
            private String dateMinMin ;
            private String dateMaxMax ;
            private String dateMaxMin ;


    private List<TauxIsVo> tauxIssVo ;

    public TauxIsConfigVo(){
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
        public String getCotisationMinimale(){
        return this.cotisationMinimale;
        }

        public void setCotisationMinimale(String cotisationMinimale){
        this.cotisationMinimale = cotisationMinimale;
        }
        public String getDateMin(){
        return this.dateMin;
        }

        public void setDateMin(String dateMin){
        this.dateMin = dateMin;
        }
        public String getDateMax(){
        return this.dateMax;
        }

        public void setDateMax(String dateMax){
        this.dateMax = dateMax;
        }


            public String getCotisationMinimaleMax(){
            return this.cotisationMinimaleMax;
            }

            public String getCotisationMinimaleMin(){
            return this.cotisationMinimaleMin;
            }

            public void setCotisationMinimaleMax(String cotisationMinimaleMax){
            this.cotisationMinimaleMax = cotisationMinimaleMax;
            }

            public void setCotisationMinimaleMin(String cotisationMinimaleMin){
            this.cotisationMinimaleMin = cotisationMinimaleMin;
            }

            public String getDateMinMax(){
            return this.dateMinMax;
            }

            public String getDateMinMin(){
            return this.dateMinMin;
            }

            public void setDateMinMax(String dateMinMax){
            this.dateMinMax = dateMinMax;
            }

            public void setDateMinMin(String dateMinMin){
            this.dateMinMin = dateMinMin;
            }

            public String getDateMaxMax(){
            return this.dateMaxMax;
            }

            public String getDateMaxMin(){
            return this.dateMaxMin;
            }

            public void setDateMaxMax(String dateMaxMax){
            this.dateMaxMax = dateMaxMax;
            }

            public void setDateMaxMin(String dateMaxMin){
            this.dateMaxMin = dateMaxMin;
            }




        public List<TauxIsVo> getTauxIssVo(){
        return this.tauxIssVo;
        }

        public void setTauxIssVo(List<TauxIsVo> tauxIssVo){
            this.tauxIssVo = tauxIssVo;
            }

            }
