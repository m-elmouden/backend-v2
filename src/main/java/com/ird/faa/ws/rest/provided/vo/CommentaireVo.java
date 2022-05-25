package com.ird.faa.ws.rest.provided.vo;

public class CommentaireVo {

    private String id ;
    private String description ;
    private String dateCommentaire ;
    private String auteur ;


            private String dateCommentaireMax ;
            private String dateCommentaireMin ;

        private DemandeVo demandeVo ;


    public CommentaireVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }
        public String getDateCommentaire(){
        return this.dateCommentaire;
        }

        public void setDateCommentaire(String dateCommentaire){
        this.dateCommentaire = dateCommentaire;
        }
        public String getAuteur(){
        return this.auteur;
        }

        public void setAuteur(String auteur){
        this.auteur = auteur;
        }


            public String getDateCommentaireMax(){
            return this.dateCommentaireMax;
            }

            public String getDateCommentaireMin(){
            return this.dateCommentaireMin;
            }

            public void setDateCommentaireMax(String dateCommentaireMax){
            this.dateCommentaireMax = dateCommentaireMax;
            }

            public void setDateCommentaireMin(String dateCommentaireMin){
            this.dateCommentaireMin = dateCommentaireMin;
            }


        public DemandeVo getDemandeVo(){
        return this.demandeVo;
        }

        public void setDemandeVo(DemandeVo demandeVo){
        this.demandeVo = demandeVo;
        }


            }
