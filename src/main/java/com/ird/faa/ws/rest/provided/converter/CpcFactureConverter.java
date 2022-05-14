package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.CpcFacture;
import com.ird.faa.ws.rest.provided.vo.CpcFactureVo;

@Component
public class CpcFactureConverter extends AbstractConverter<CpcFacture,CpcFactureVo>{

        @Autowired
        private CpcConverter cpcConverter ;
        @Autowired
        private FactureConverter factureConverter ;
    private Boolean cpc;
    private Boolean facture;

public  CpcFactureConverter(){
init(true);
}

@Override
public CpcFacture toItem(CpcFactureVo vo) {
if (vo == null) {
return null;
} else {
CpcFacture item = new CpcFacture();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getCpcVo()!=null && this.cpc)
        item.setCpc(cpcConverter.toItem(vo.getCpcVo())) ;
    if(vo.getFactureVo()!=null && this.facture)
        item.setFacture(factureConverter.toItem(vo.getFactureVo())) ;


return item;
}
}

@Override
public CpcFactureVo toVo(CpcFacture item) {
if (item == null) {
return null;
} else {
CpcFactureVo vo = new CpcFactureVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

    if(item.getCpc()!=null && this.cpc) {
        vo.setCpcVo(cpcConverter.toVo(item.getCpc())) ;
    }
    if(item.getFacture()!=null && this.facture) {
                factureConverter.setCpcFacture(false);
        vo.setFactureVo(factureConverter.toVo(item.getFacture())) ;
                factureConverter.setCpcFacture(true);
    }

return vo;
}
}

public void init(Boolean value) {
    cpc = value;
    facture = value;
}


        public CpcConverter getCpcConverter(){
        return this.cpcConverter;
        }
        public void setCpcConverter(CpcConverter cpcConverter ){
        this.cpcConverter = cpcConverter;
        }
        public FactureConverter getFactureConverter(){
        return this.factureConverter;
        }
        public void setFactureConverter(FactureConverter factureConverter ){
        this.factureConverter = factureConverter;
        }

    public boolean  isCpc(){
    return this.cpc;
    }
    public void  setCpc(boolean cpc){
    this.cpc = cpc;
    }
    public boolean  isFacture(){
    return this.facture;
    }
    public void  setFacture(boolean facture){
    this.facture = facture;
    }






}
