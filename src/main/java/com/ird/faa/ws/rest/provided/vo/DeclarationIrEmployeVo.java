package  com.ird.faa.ws.rest.provided.vo;

    import java.math.BigDecimal;

public class DeclarationIrEmployeVo {

    private String id ;
    private String salaireNet ;
    private String salaireBrut ;
    private String salaireNetImposable ;
    private String salaireBrutImposable ;
    private String salaireBase ;
    private String indemnite ;
    private String primes ;
    private String pourcentageAnciennete ;
    private String cotisation ;


            private String salaireNetMax ;
            private String salaireNetMin ;
            private String salaireBrutMax ;
            private String salaireBrutMin ;
            private String salaireNetImposableMax ;
            private String salaireNetImposableMin ;
            private String salaireBrutImposableMax ;
            private String salaireBrutImposableMin ;
            private String salaireBaseMax ;
            private String salaireBaseMin ;
            private String indemniteMax ;
            private String indemniteMin ;
            private String primesMax ;
            private String primesMin ;
            private String pourcentageAncienneteMax ;
            private String pourcentageAncienneteMin ;
            private String cotisationMax ;
            private String cotisationMin ;

        private DeclarationIrVo declarationIrVo ;
        private EmployeVo employeVo ;
        private TauxIrVo tauxIrVo ;


    public DeclarationIrEmployeVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
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
        public String getSalaireNetImposable(){
        return this.salaireNetImposable;
        }

        public void setSalaireNetImposable(String salaireNetImposable){
        this.salaireNetImposable = salaireNetImposable;
        }
        public String getSalaireBrutImposable(){
        return this.salaireBrutImposable;
        }

        public void setSalaireBrutImposable(String salaireBrutImposable){
        this.salaireBrutImposable = salaireBrutImposable;
        }
        public String getSalaireBase(){
        return this.salaireBase;
        }

        public void setSalaireBase(String salaireBase){
        this.salaireBase = salaireBase;
        }
        public String getIndemnite(){
        return this.indemnite;
        }

        public void setIndemnite(String indemnite){
        this.indemnite = indemnite;
        }
        public String getPrimes(){
        return this.primes;
        }

        public void setPrimes(String primes){
        this.primes = primes;
        }
        public String getPourcentageAnciennete(){
        return this.pourcentageAnciennete;
        }

        public void setPourcentageAnciennete(String pourcentageAnciennete){
        this.pourcentageAnciennete = pourcentageAnciennete;
        }
        public String getCotisation(){
        return this.cotisation;
        }

        public void setCotisation(String cotisation){
        this.cotisation = cotisation;
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

            public String getSalaireNetImposableMax(){
            return this.salaireNetImposableMax;
            }

            public String getSalaireNetImposableMin(){
            return this.salaireNetImposableMin;
            }

            public void setSalaireNetImposableMax(String salaireNetImposableMax){
            this.salaireNetImposableMax = salaireNetImposableMax;
            }

            public void setSalaireNetImposableMin(String salaireNetImposableMin){
            this.salaireNetImposableMin = salaireNetImposableMin;
            }

            public String getSalaireBrutImposableMax(){
            return this.salaireBrutImposableMax;
            }

            public String getSalaireBrutImposableMin(){
            return this.salaireBrutImposableMin;
            }

            public void setSalaireBrutImposableMax(String salaireBrutImposableMax){
            this.salaireBrutImposableMax = salaireBrutImposableMax;
            }

            public void setSalaireBrutImposableMin(String salaireBrutImposableMin){
            this.salaireBrutImposableMin = salaireBrutImposableMin;
            }

            public String getSalaireBaseMax(){
            return this.salaireBaseMax;
            }

            public String getSalaireBaseMin(){
            return this.salaireBaseMin;
            }

            public void setSalaireBaseMax(String salaireBaseMax){
            this.salaireBaseMax = salaireBaseMax;
            }

            public void setSalaireBaseMin(String salaireBaseMin){
            this.salaireBaseMin = salaireBaseMin;
            }

            public String getIndemniteMax(){
            return this.indemniteMax;
            }

            public String getIndemniteMin(){
            return this.indemniteMin;
            }

            public void setIndemniteMax(String indemniteMax){
            this.indemniteMax = indemniteMax;
            }

            public void setIndemniteMin(String indemniteMin){
            this.indemniteMin = indemniteMin;
            }

            public String getPrimesMax(){
            return this.primesMax;
            }

            public String getPrimesMin(){
            return this.primesMin;
            }

            public void setPrimesMax(String primesMax){
            this.primesMax = primesMax;
            }

            public void setPrimesMin(String primesMin){
            this.primesMin = primesMin;
            }

            public String getPourcentageAncienneteMax(){
            return this.pourcentageAncienneteMax;
            }

            public String getPourcentageAncienneteMin(){
            return this.pourcentageAncienneteMin;
            }

            public void setPourcentageAncienneteMax(String pourcentageAncienneteMax){
            this.pourcentageAncienneteMax = pourcentageAncienneteMax;
            }

            public void setPourcentageAncienneteMin(String pourcentageAncienneteMin){
            this.pourcentageAncienneteMin = pourcentageAncienneteMin;
            }

            public String getCotisationMax(){
            return this.cotisationMax;
            }

            public String getCotisationMin(){
            return this.cotisationMin;
            }

            public void setCotisationMax(String cotisationMax){
            this.cotisationMax = cotisationMax;
            }

            public void setCotisationMin(String cotisationMin){
            this.cotisationMin = cotisationMin;
            }


        public DeclarationIrVo getDeclarationIrVo(){
        return this.declarationIrVo;
        }

        public void setDeclarationIrVo(DeclarationIrVo declarationIrVo){
        this.declarationIrVo = declarationIrVo;
        }
        public EmployeVo getEmployeVo(){
        return this.employeVo;
        }

        public void setEmployeVo(EmployeVo employeVo){
        this.employeVo = employeVo;
        }
        public TauxIrVo getTauxIrVo(){
        return this.tauxIrVo;
        }

        public void setTauxIrVo(TauxIrVo tauxIrVo){
        this.tauxIrVo = tauxIrVo;
        }


            }
