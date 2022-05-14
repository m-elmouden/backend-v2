package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "taux_cnss")
public class TauxCnss    implements Archivable  {

@Id
    @SequenceGenerator(name="taux_cnss_seq",sequenceName="taux_cnss_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="taux_cnss_seq")
private Long id;

            @Column(length = 500)
            private String ref;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateApplicationMin ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateApplicationMax ;
            private BigDecimal plafond ;
            private BigDecimal pourcentage ;
            @Column(columnDefinition = "boolean default false")
                 private Boolean archive = false;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateArchivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;
            @Column(columnDefinition = "boolean default false")
                 private Boolean admin = false;
            @Column(columnDefinition = "boolean default false")
                 private Boolean visible = false;
            @Column(length = 500)
            private String username;

    @ManyToOne
    private TypeTauxCnss typeTauxCnss ;


public TauxCnss(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getRef(){
            return this.ref;
            }
            public void setRef(String ref){
            this.ref = ref;
            }
            public TypeTauxCnss getTypeTauxCnss(){
            return this.typeTauxCnss;
            }
            public void setTypeTauxCnss(TypeTauxCnss typeTauxCnss){
            this.typeTauxCnss = typeTauxCnss;
            }
            public Date getDateApplicationMin(){
            return this.dateApplicationMin;
            }
            public void setDateApplicationMin(Date dateApplicationMin){
            this.dateApplicationMin = dateApplicationMin;
            }
            public Date getDateApplicationMax(){
            return this.dateApplicationMax;
            }
            public void setDateApplicationMax(Date dateApplicationMax){
            this.dateApplicationMax = dateApplicationMax;
            }
            public BigDecimal getPlafond(){
            return this.plafond;
            }
            public void setPlafond(BigDecimal plafond){
            this.plafond = plafond;
            }
            public BigDecimal getPourcentage(){
            return this.pourcentage;
            }
            public void setPourcentage(BigDecimal pourcentage){
            this.pourcentage = pourcentage;
            }
        public Boolean  getArchive(){
        return this.archive;
        }
        public void setArchive(Boolean archive){
        this.archive = archive;
        }
            public Date getDateArchivage(){
            return this.dateArchivage;
            }
            public void setDateArchivage(Date dateArchivage){
            this.dateArchivage = dateArchivage;
            }
            public Date getDateCreation(){
            return this.dateCreation;
            }
            public void setDateCreation(Date dateCreation){
            this.dateCreation = dateCreation;
            }
        public Boolean  getAdmin(){
        return this.admin;
        }
        public void setAdmin(Boolean admin){
        this.admin = admin;
        }
        public Boolean  getVisible(){
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

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TauxCnss tauxCnss = (TauxCnss) o;
        return id != null && id.equals(tauxCnss.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

