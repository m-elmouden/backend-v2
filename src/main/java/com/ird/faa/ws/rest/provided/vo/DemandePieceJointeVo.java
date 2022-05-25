package com.ird.faa.ws.rest.provided.vo;


public class DemandePieceJointeVo {

    private String id ;
    private String name ;
    private String path ;



        private DemandeVo demandeVo ;


    public DemandePieceJointeVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
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



        public DemandeVo getDemandeVo(){
        return this.demandeVo;
        }

        public void setDemandeVo(DemandeVo demandeVo){
        this.demandeVo = demandeVo;
        }


            }
