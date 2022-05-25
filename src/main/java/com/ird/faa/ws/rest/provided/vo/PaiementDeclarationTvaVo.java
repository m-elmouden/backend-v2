package com.ird.faa.ws.rest.provided.vo;

public class PaiementDeclarationTvaVo {

    private String id ;
    private String reference ;
    private String datePaiement ;
    private String total ;
    private String montantCptTraiteur ;
    private String montantCptValidateur ;
    private String reste ;


            private String datePaiementMax ;
            private String datePaiementMin ;
            private String totalMax ;
            private String totalMin ;
            private String montantCptTraiteurMax ;
            private String montantCptTraiteurMin ;
            private String montantCptValidateurMax ;
            private String montantCptValidateurMin ;
            private String resteMax ;
            private String resteMin ;

        private DeclarationTvaVo declarationTvaVo ;


    public PaiementDeclarationTvaVo(){
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
        public String getDatePaiement(){
        return this.datePaiement;
        }

        public void setDatePaiement(String datePaiement){
        this.datePaiement = datePaiement;
        }
        public String getTotal(){
        return this.total;
        }

        public void setTotal(String total){
        this.total = total;
        }
        public String getMontantCptTraiteur(){
        return this.montantCptTraiteur;
        }

        public void setMontantCptTraiteur(String montantCptTraiteur){
        this.montantCptTraiteur = montantCptTraiteur;
        }
        public String getMontantCptValidateur(){
        return this.montantCptValidateur;
        }

        public void setMontantCptValidateur(String montantCptValidateur){
        this.montantCptValidateur = montantCptValidateur;
        }
        public String getReste(){
        return this.reste;
        }

        public void setReste(String reste){
        this.reste = reste;
        }


            public String getDatePaiementMax(){
            return this.datePaiementMax;
            }

            public String getDatePaiementMin(){
            return this.datePaiementMin;
            }

            public void setDatePaiementMax(String datePaiementMax){
            this.datePaiementMax = datePaiementMax;
            }

            public void setDatePaiementMin(String datePaiementMin){
            this.datePaiementMin = datePaiementMin;
            }

            public String getTotalMax(){
            return this.totalMax;
            }

            public String getTotalMin(){
            return this.totalMin;
            }

            public void setTotalMax(String totalMax){
            this.totalMax = totalMax;
            }

            public void setTotalMin(String totalMin){
            this.totalMin = totalMin;
            }

            public String getMontantCptTraiteurMax(){
            return this.montantCptTraiteurMax;
            }

            public String getMontantCptTraiteurMin(){
            return this.montantCptTraiteurMin;
            }

            public void setMontantCptTraiteurMax(String montantCptTraiteurMax){
            this.montantCptTraiteurMax = montantCptTraiteurMax;
            }

            public void setMontantCptTraiteurMin(String montantCptTraiteurMin){
            this.montantCptTraiteurMin = montantCptTraiteurMin;
            }

            public String getMontantCptValidateurMax(){
            return this.montantCptValidateurMax;
            }

            public String getMontantCptValidateurMin(){
            return this.montantCptValidateurMin;
            }

            public void setMontantCptValidateurMax(String montantCptValidateurMax){
            this.montantCptValidateurMax = montantCptValidateurMax;
            }

            public void setMontantCptValidateurMin(String montantCptValidateurMin){
            this.montantCptValidateurMin = montantCptValidateurMin;
            }

            public String getResteMax(){
            return this.resteMax;
            }

            public String getResteMin(){
            return this.resteMin;
            }

            public void setResteMax(String resteMax){
            this.resteMax = resteMax;
            }

            public void setResteMin(String resteMin){
            this.resteMin = resteMin;
            }


        public DeclarationTvaVo getDeclarationTvaVo(){
        return this.declarationTvaVo;
        }

        public void setDeclarationTvaVo(DeclarationTvaVo declarationTvaVo){
        this.declarationTvaVo = declarationTvaVo;
        }


            }
