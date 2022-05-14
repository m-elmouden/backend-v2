package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TauxIs;
import com.ird.faa.ws.rest.provided.vo.TauxIsVo;

@Component
public class TauxIsConverter extends AbstractConverter<TauxIs,TauxIsVo>{

        @Autowired
        private TauxIsConfigConverter tauxIsConfigConverter ;
    private Boolean tauxIsConfig;

public  TauxIsConverter(){
init(true);
}

@Override
public TauxIs toItem(TauxIsVo vo) {
if (vo == null) {
return null;
} else {
TauxIs item = new TauxIs();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getResultatFiscalMin()))
        item.setResultatFiscalMin(NumberUtil.toBigDecimal(vo.getResultatFiscalMin()));
        if(StringUtil.isNotEmpty(vo.getResultatFiscalMax()))
        item.setResultatFiscalMax(NumberUtil.toBigDecimal(vo.getResultatFiscalMax()));
        if(StringUtil.isNotEmpty(vo.getPourcentage()))
        item.setPourcentage(NumberUtil.toBigDecimal(vo.getPourcentage()));
        if(StringUtil.isNotEmpty(vo.getPenalite()))
        item.setPenalite(NumberUtil.toBigDecimal(vo.getPenalite()));
    if(vo.getTauxIsConfigVo()!=null && this.tauxIsConfig)
        item.setTauxIsConfig(tauxIsConfigConverter.toItem(vo.getTauxIsConfigVo())) ;


return item;
}
}

@Override
public TauxIsVo toVo(TauxIs item) {
if (item == null) {
return null;
} else {
TauxIsVo vo = new TauxIsVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getResultatFiscalMin()!=null)
        vo.setResultatFiscalMin(NumberUtil.toString(item.getResultatFiscalMin()));

        if(item.getResultatFiscalMax()!=null)
        vo.setResultatFiscalMax(NumberUtil.toString(item.getResultatFiscalMax()));

        if(item.getPourcentage()!=null)
        vo.setPourcentage(NumberUtil.toString(item.getPourcentage()));

        if(item.getPenalite()!=null)
        vo.setPenalite(NumberUtil.toString(item.getPenalite()));

    if(item.getTauxIsConfig()!=null && this.tauxIsConfig) {
        vo.setTauxIsConfigVo(tauxIsConfigConverter.toVo(item.getTauxIsConfig())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    tauxIsConfig = value;
}


        public TauxIsConfigConverter getTauxIsConfigConverter(){
        return this.tauxIsConfigConverter;
        }
        public void setTauxIsConfigConverter(TauxIsConfigConverter tauxIsConfigConverter ){
        this.tauxIsConfigConverter = tauxIsConfigConverter;
        }

    public boolean  isTauxIsConfig(){
    return this.tauxIsConfig;
    }
    public void  setTauxIsConfig(boolean tauxIsConfig){
    this.tauxIsConfig = tauxIsConfig;
    }














}
