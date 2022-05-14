package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "etat_demande")
public class EtatDemande   {

@Id
    @SequenceGenerator(name="etat_demande_seq",sequenceName="etat_demande_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_demande_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String libelle;
            @Column(length = 500)
            private String couleur;



public EtatDemande(){
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
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public String getCouleur(){
            return this.couleur;
            }
            public void setCouleur(String couleur){
            this.couleur = couleur;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtatDemande etatDemande = (EtatDemande) o;
        return id != null && id.equals(etatDemande.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

