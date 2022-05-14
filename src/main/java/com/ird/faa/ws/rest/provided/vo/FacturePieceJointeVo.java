package  com.ird.faa.ws.rest.provided.vo;


public class FacturePieceJointeVo {

    private String id ;
    private String name ;
    private String path ;



        private FactureVo factureVo ;


    public FacturePieceJointeVo(){
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



        public FactureVo getFactureVo(){
        return this.factureVo;
        }

        public void setFactureVo(FactureVo factureVo){
        this.factureVo = factureVo;
        }


            }
