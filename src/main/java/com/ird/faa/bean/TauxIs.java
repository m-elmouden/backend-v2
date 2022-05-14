package com.ird.faa.bean;

import java.util.Objects;



    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "taux_is")
public class TauxIs   {

@Id
    @SequenceGenerator(name="taux_is_seq",sequenceName="taux_is_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="taux_is_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            private BigDecimal resultatFiscalMin ;
            private BigDecimal resultatFiscalMax ;
            private BigDecimal pourcentage ;
            private BigDecimal penalite ;

    @ManyToOne
    private TauxIsConfig tauxIsConfig ;


public TauxIs(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getReference(){
            return this.reference;
            }
            public void setReference(String reference){
            this.reference = reference;
            }
            public BigDecimal getResultatFiscalMin(){
            return this.resultatFiscalMin;
            }
            public void setResultatFiscalMin(BigDecimal resultatFiscalMin){
            this.resultatFiscalMin = resultatFiscalMin;
            }
            public BigDecimal getResultatFiscalMax(){
            return this.resultatFiscalMax;
            }
            public void setResultatFiscalMax(BigDecimal resultatFiscalMax){
            this.resultatFiscalMax = resultatFiscalMax;
            }
            public BigDecimal getPourcentage(){
            return this.pourcentage;
            }
            public void setPourcentage(BigDecimal pourcentage){
            this.pourcentage = pourcentage;
            }
            public BigDecimal getPenalite(){
            return this.penalite;
            }
            public void setPenalite(BigDecimal penalite){
            this.penalite = penalite;
            }
            public TauxIsConfig getTauxIsConfig(){
            return this.tauxIsConfig;
            }
            public void setTauxIsConfig(TauxIsConfig tauxIsConfig){
            this.tauxIsConfig = tauxIsConfig;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TauxIs tauxIs = (TauxIs) o;
        return id != null && id.equals(tauxIs.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

