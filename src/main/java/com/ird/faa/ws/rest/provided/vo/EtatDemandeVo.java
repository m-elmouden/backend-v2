package com.ird.faa.ws.rest.provided.vo;


public class EtatDemandeVo {

    private String id ;
    private String reference ;
    private String libelle ;
    private String couleur ;





    public EtatDemandeVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
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





            }
