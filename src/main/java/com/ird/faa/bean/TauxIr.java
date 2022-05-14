package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "taux_ir")
public class TauxIr   {

@Id
    @SequenceGenerator(name="taux_ir_seq",sequenceName="taux_ir_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="taux_ir_seq")
private Long id;

            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMin ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMax ;
            private BigDecimal salaireImpoMin ;
            private BigDecimal salaireImpoMax ;
            private BigDecimal forfaitDeduit ;
            private BigDecimal pourcentage ;



public TauxIr(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Date getDateMin(){
            return this.dateMin;
            }
            public void setDateMin(Date dateMin){
            this.dateMin = dateMin;
            }
            public Date getDateMax(){
            return this.dateMax;
            }
            public void setDateMax(Date dateMax){
            this.dateMax = dateMax;
            }
            public BigDecimal getSalaireImpoMin(){
            return this.salaireImpoMin;
            }
            public void setSalaireImpoMin(BigDecimal salaireImpoMin){
            this.salaireImpoMin = salaireImpoMin;
            }
            public BigDecimal getSalaireImpoMax(){
            return this.salaireImpoMax;
            }
            public void setSalaireImpoMax(BigDecimal salaireImpoMax){
            this.salaireImpoMax = salaireImpoMax;
            }
            public BigDecimal getForfaitDeduit(){
            return this.forfaitDeduit;
            }
            public void setForfaitDeduit(BigDecimal forfaitDeduit){
            this.forfaitDeduit = forfaitDeduit;
            }
            public BigDecimal getPourcentage(){
            return this.pourcentage;
            }
            public void setPourcentage(BigDecimal pourcentage){
            this.pourcentage = pourcentage;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TauxIr tauxIr = (TauxIr) o;
        return id != null && id.equals(tauxIr.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

