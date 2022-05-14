package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "demande_piece_jointe")
public class DemandePieceJointe   {

@Id
    @SequenceGenerator(name="demande_piece_jointe_seq",sequenceName="demande_piece_jointe_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demande_piece_jointe_seq")
private Long id;

            @Column(length = 500)
            private String name;
            @Column(length = 500)
            private String path;

    @ManyToOne
    private Demande demande ;


public DemandePieceJointe(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getName(){
            return this.name;
            }
            public void setName(String name){
            this.name = name;
            }
            public String getPath(){
            return this.path;
            }
            public void setPath(String path){
            this.path = path;
            }
            public Demande getDemande(){
            return this.demande;
            }
            public void setDemande(Demande demande){
            this.demande = demande;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandePieceJointe demandePieceJointe = (DemandePieceJointe) o;
        return id != null && id.equals(demandePieceJointe.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

