package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "cpc_facture")
public class CpcFacture   {

@Id
    @SequenceGenerator(name="cpc_facture_seq",sequenceName="cpc_facture_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="cpc_facture_seq")
private Long id;


    @ManyToOne
    private Cpc cpc ;
    @ManyToOne
    private Facture facture ;


public CpcFacture(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Cpc getCpc(){
            return this.cpc;
            }
            public void setCpc(Cpc cpc){
            this.cpc = cpc;
            }
            public Facture getFacture(){
            return this.facture;
            }
            public void setFacture(Facture facture){
            this.facture = facture;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CpcFacture cpcFacture = (CpcFacture) o;
        return id != null && id.equals(cpcFacture.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

