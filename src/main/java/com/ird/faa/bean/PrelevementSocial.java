package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "prelevement_social")
public class PrelevementSocial   {

@Id
    @SequenceGenerator(name="prelevement_social_seq",sequenceName="prelevement_social_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="prelevement_social_seq")
private Long id;

            @Column(length = 500)
            private String libelle;
            private BigDecimal pourcentage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMax ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMin ;



public PrelevementSocial(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public BigDecimal getPourcentage(){
            return this.pourcentage;
            }
            public void setPourcentage(BigDecimal pourcentage){
            this.pourcentage = pourcentage;
            }
            public Date getDateMax(){
            return this.dateMax;
            }
            public void setDateMax(Date dateMax){
            this.dateMax = dateMax;
            }
            public Date getDateMin(){
            return this.dateMin;
            }
            public void setDateMin(Date dateMin){
            this.dateMin = dateMin;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrelevementSocial prelevementSocial = (PrelevementSocial) o;
        return id != null && id.equals(prelevementSocial.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

