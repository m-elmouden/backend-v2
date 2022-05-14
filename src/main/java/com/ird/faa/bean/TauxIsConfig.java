package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "taux_is_config")
public class TauxIsConfig   {

@Id
    @SequenceGenerator(name="taux_is_config_seq",sequenceName="taux_is_config_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="taux_is_config_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            private BigDecimal cotisationMinimale ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMin ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMax ;


                @OneToMany(mappedBy = "tauxIsConfig")
            private List<TauxIs> tauxIss ;

public TauxIsConfig(){
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
            public BigDecimal getCotisationMinimale(){
            return this.cotisationMinimale;
            }
            public void setCotisationMinimale(BigDecimal cotisationMinimale){
            this.cotisationMinimale = cotisationMinimale;
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
            public List<TauxIs> getTauxIss(){
            return this.tauxIss;
            }
            public void setTauxIss(List<TauxIs> tauxIss){
            this.tauxIss = tauxIss;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TauxIsConfig tauxIsConfig = (TauxIsConfig) o;
        return id != null && id.equals(tauxIsConfig.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

