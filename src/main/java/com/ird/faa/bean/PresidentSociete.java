package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "president_societe")
public class PresidentSociete   {

@Id
    @SequenceGenerator(name="president_societe_seq",sequenceName="president_societe_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="president_societe_seq")
private Long id;

            @Column(length = 500)
            private String cin;
            @Column(length = 500)
            private String nom;
            @Column(length = 500)
            private String prenom;
            @Column(length = 500)
            private String email;
            @Column(length = 500)
            private String telephone;

    @ManyToOne
    private Societe societe ;


public PresidentSociete(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getCin(){
            return this.cin;
            }
            public void setCin(String cin){
            this.cin = cin;
            }
            public String getNom(){
            return this.nom;
            }
            public void setNom(String nom){
            this.nom = nom;
            }
            public String getPrenom(){
            return this.prenom;
            }
            public void setPrenom(String prenom){
            this.prenom = prenom;
            }
            public String getEmail(){
            return this.email;
            }
            public void setEmail(String email){
            this.email = email;
            }
            public String getTelephone(){
            return this.telephone;
            }
            public void setTelephone(String telephone){
            this.telephone = telephone;
            }
            public Societe getSociete(){
            return this.societe;
            }
            public void setSociete(Societe societe){
            this.societe = societe;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresidentSociete presidentSociete = (PresidentSociete) o;
        return id != null && id.equals(presidentSociete.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

