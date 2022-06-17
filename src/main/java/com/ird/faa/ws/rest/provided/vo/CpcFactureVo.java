package com.ird.faa.ws.rest.provided.vo;


public class CpcFactureVo {

    private String id;


    private CpcVo cpcVo;
    private FactureVo factureVo;


    public CpcFactureVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public CpcVo getCpcVo() {
        return this.cpcVo;
    }

    public void setCpcVo(CpcVo cpcVo) {
        this.cpcVo = cpcVo;
    }

    public FactureVo getFactureVo() {
        return this.factureVo;
    }

    public void setFactureVo(FactureVo factureVo) {
        this.factureVo = factureVo;
    }


}
