package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "commentaire")
public class Commentaire {

    @Id
    @SequenceGenerator(name = "commentaire_seq", sequenceName = "commentaire_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentaire_seq")
    private Long id;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateCommentaire;
    @Column(length = 500)
    private String auteur;

    @ManyToOne
    private Demande demande;


    public Commentaire() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCommentaire() {
        return this.dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Demande getDemande() {
        return this.demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commentaire commentaire = (Commentaire) o;
        return id != null && id.equals(commentaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

