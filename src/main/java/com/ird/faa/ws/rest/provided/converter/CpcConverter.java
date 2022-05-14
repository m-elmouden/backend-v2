package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Cpc;
import com.ird.faa.ws.rest.provided.vo.CpcVo;

@Component
public class CpcConverter extends AbstractConverter<Cpc,CpcVo>{

        @Autowired
        private CpcFactureConverter cpcFactureConverter ;
        private Boolean cpcFactures;

public  CpcConverter(){
init(true);
}

@Override
public Cpc toItem(CpcVo vo) {
if (vo == null) {
return null;
} else {
Cpc item = new Cpc();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getTotalProdEx()))
        item.setTotalProdEx(NumberUtil.toBigDecimal(vo.getTotalProdEx()));
        if(StringUtil.isNotEmpty(vo.getTotalChargEx()))
        item.setTotalChargEx(NumberUtil.toBigDecimal(vo.getTotalChargEx()));
        if(StringUtil.isNotEmpty(vo.getTotalProdFin()))
        item.setTotalProdFin(NumberUtil.toBigDecimal(vo.getTotalProdFin()));
        if(StringUtil.isNotEmpty(vo.getTotalChargFin()))
        item.setTotalChargFin(NumberUtil.toBigDecimal(vo.getTotalChargFin()));
        if(StringUtil.isNotEmpty(vo.getTotalProdNCour()))
        item.setTotalProdNCour(NumberUtil.toBigDecimal(vo.getTotalProdNCour()));
        if(StringUtil.isNotEmpty(vo.getTotalChargNCour()))
        item.setTotalChargNCour(NumberUtil.toBigDecimal(vo.getTotalChargNCour()));
        if(StringUtil.isNotEmpty(vo.getDateMinCpc()))
        item.setDateMinCpc(DateUtil.parse(vo.getDateMinCpc()));
        if(StringUtil.isNotEmpty(vo.getDateMaxCpc()))
        item.setDateMaxCpc(DateUtil.parse(vo.getDateMaxCpc()));
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
            if(vo.getAdmin() != null)
            item.setAdmin(vo.getAdmin());
            if(vo.getVisible() != null)
            item.setVisible(vo.getVisible());
        if(StringUtil.isNotEmpty(vo.getUsername()))
        item.setUsername(vo.getUsername());

    if(ListUtil.isNotEmpty(vo.getCpcFacturesVo()) && this.cpcFactures)
        item.setCpcFactures(cpcFactureConverter.toItem(vo.getCpcFacturesVo()));

return item;
}
}

@Override
public CpcVo toVo(Cpc item) {
if (item == null) {
return null;
} else {
CpcVo vo = new CpcVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getTotalProdEx()!=null)
        vo.setTotalProdEx(NumberUtil.toString(item.getTotalProdEx()));

        if(item.getTotalChargEx()!=null)
        vo.setTotalChargEx(NumberUtil.toString(item.getTotalChargEx()));

        if(item.getTotalProdFin()!=null)
        vo.setTotalProdFin(NumberUtil.toString(item.getTotalProdFin()));

        if(item.getTotalChargFin()!=null)
        vo.setTotalChargFin(NumberUtil.toString(item.getTotalChargFin()));

        if(item.getTotalProdNCour()!=null)
        vo.setTotalProdNCour(NumberUtil.toString(item.getTotalProdNCour()));

        if(item.getTotalChargNCour()!=null)
        vo.setTotalChargNCour(NumberUtil.toString(item.getTotalChargNCour()));

        if(item.getDateMinCpc()!=null)
        vo.setDateMinCpc(DateUtil.formateDate(item.getDateMinCpc()));
        if(item.getDateMaxCpc()!=null)
        vo.setDateMaxCpc(DateUtil.formateDate(item.getDateMaxCpc()));
        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
        if(item.getAdmin()!=null)
        vo.setAdmin(item.getAdmin());
        if(item.getVisible()!=null)
        vo.setVisible(item.getVisible());
        if(StringUtil.isNotEmpty(item.getUsername()))
        vo.setUsername(item.getUsername());

        if(ListUtil.isNotEmpty(item.getCpcFactures()) && this.cpcFactures){
        cpcFactureConverter.init(true);
        cpcFactureConverter.setCpc(false);
        vo.setCpcFacturesVo(cpcFactureConverter.toVo(item.getCpcFactures()));
        cpcFactureConverter.setCpc(true);
        }

return vo;
}
}

public void init(Boolean value) {
        cpcFactures = value;
}


        public CpcFactureConverter getCpcFactureConverter(){
        return this.cpcFactureConverter;
        }
        public void setCpcFactureConverter(CpcFactureConverter cpcFactureConverter ){
        this.cpcFactureConverter = cpcFactureConverter;
        }






















        public Boolean  isCpcFactures(){
        return this.cpcFactures ;
        }
        public void  setCpcFactures(Boolean cpcFactures ){
        this.cpcFactures  = cpcFactures ;
        }














}
