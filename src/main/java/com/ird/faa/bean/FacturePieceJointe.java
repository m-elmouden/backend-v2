package com.ird.faa.bean;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "facture_piece_jointe")
public class FacturePieceJointe {

    @Id
    @SequenceGenerator(name = "facture_piece_jointe_seq", sequenceName = "facture_piece_jointe_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facture_piece_jointe_seq")
    private Long id;

    @Column(length = 500)
    private String name;
    @Column(length = 500)
    private String path;

    @ManyToOne
    private Facture facture;


    public FacturePieceJointe() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Facture getFacture() {
        return this.facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacturePieceJointe facturePieceJointe = (FacturePieceJointe) o;
        return id != null && id.equals(facturePieceJointe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

