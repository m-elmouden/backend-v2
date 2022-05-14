package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "cpc")
public class Cpc    implements Archivable  {

@Id
    @SequenceGenerator(name="cpc_seq",sequenceName="cpc_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="cpc_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            private BigDecimal totalProdEx ;
            private BigDecimal totalChargEx ;
            private BigDecimal totalProdFin ;
            private BigDecimal totalChargFin ;
            private BigDecimal totalProdNCour ;
            private BigDecimal totalChargNCour ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMinCpc ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMaxCpc ;
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


                @OneToMany(mappedBy = "cpc")
            private List<CpcFacture> cpcFactures ;

public Cpc(){
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
            public BigDecimal getTotalProdEx(){
            return this.totalProdEx;
            }
            public void setTotalProdEx(BigDecimal totalProdEx){
            this.totalProdEx = totalProdEx;
            }
            public BigDecimal getTotalChargEx(){
            return this.totalChargEx;
            }
            public void setTotalChargEx(BigDecimal totalChargEx){
            this.totalChargEx = totalChargEx;
            }
            public BigDecimal getTotalProdFin(){
            return this.totalProdFin;
            }
            public void setTotalProdFin(BigDecimal totalProdFin){
            this.totalProdFin = totalProdFin;
            }
            public BigDecimal getTotalChargFin(){
            return this.totalChargFin;
            }
            public void setTotalChargFin(BigDecimal totalChargFin){
            this.totalChargFin = totalChargFin;
            }
            public BigDecimal getTotalProdNCour(){
            return this.totalProdNCour;
            }
            public void setTotalProdNCour(BigDecimal totalProdNCour){
            this.totalProdNCour = totalProdNCour;
            }
            public BigDecimal getTotalChargNCour(){
            return this.totalChargNCour;
            }
            public void setTotalChargNCour(BigDecimal totalChargNCour){
            this.totalChargNCour = totalChargNCour;
            }
            public Date getDateMinCpc(){
            return this.dateMinCpc;
            }
            public void setDateMinCpc(Date dateMinCpc){
            this.dateMinCpc = dateMinCpc;
            }
            public Date getDateMaxCpc(){
            return this.dateMaxCpc;
            }
            public void setDateMaxCpc(Date dateMaxCpc){
            this.dateMaxCpc = dateMaxCpc;
            }
            public List<CpcFacture> getCpcFactures(){
            return this.cpcFactures;
            }
            public void setCpcFactures(List<CpcFacture> cpcFactures){
            this.cpcFactures = cpcFactures;
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
        Cpc cpc = (Cpc) o;
        return id != null && id.equals(cpc.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

