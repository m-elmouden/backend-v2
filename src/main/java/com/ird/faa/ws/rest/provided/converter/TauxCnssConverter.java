package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TauxCnss;
import com.ird.faa.ws.rest.provided.vo.TauxCnssVo;

@Component
public class TauxCnssConverter extends AbstractConverter<TauxCnss,TauxCnssVo>{

        @Autowired
        private TypeTauxCnssConverter typeTauxCnssConverter ;
    private Boolean typeTauxCnss;

public  TauxCnssConverter(){
init(true);
}

@Override
public TauxCnss toItem(TauxCnssVo vo) {
if (vo == null) {
return null;
} else {
TauxCnss item = new TauxCnss();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getRef()))
        item.setRef(vo.getRef());
        if(StringUtil.isNotEmpty(vo.getDateApplicationMin()))
        item.setDateApplicationMin(DateUtil.parse(vo.getDateApplicationMin()));
        if(StringUtil.isNotEmpty(vo.getDateApplicationMax()))
        item.setDateApplicationMax(DateUtil.parse(vo.getDateApplicationMax()));
        if(StringUtil.isNotEmpty(vo.getPlafond()))
        item.setPlafond(NumberUtil.toBigDecimal(vo.getPlafond()));
        if(StringUtil.isNotEmpty(vo.getPourcentage()))
        item.setPourcentage(NumberUtil.toBigDecimal(vo.getPourcentage()));
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
    if(vo.getTypeTauxCnssVo()!=null && this.typeTauxCnss)
        item.setTypeTauxCnss(typeTauxCnssConverter.toItem(vo.getTypeTauxCnssVo())) ;


return item;
}
}

@Override
public TauxCnssVo toVo(TauxCnss item) {
if (item == null) {
return null;
} else {
TauxCnssVo vo = new TauxCnssVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getRef()))
        vo.setRef(item.getRef());

        if(item.getDateApplicationMin()!=null)
        vo.setDateApplicationMin(DateUtil.formateDate(item.getDateApplicationMin()));
        if(item.getDateApplicationMax()!=null)
        vo.setDateApplicationMax(DateUtil.formateDate(item.getDateApplicationMax()));
        if(item.getPlafond()!=null)
        vo.setPlafond(NumberUtil.toString(item.getPlafond()));

        if(item.getPourcentage()!=null)
        vo.setPourcentage(NumberUtil.toString(item.getPourcentage()));

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

    if(item.getTypeTauxCnss()!=null && this.typeTauxCnss) {
        vo.setTypeTauxCnssVo(typeTauxCnssConverter.toVo(item.getTypeTauxCnss())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    typeTauxCnss = value;
}


        public TypeTauxCnssConverter getTypeTauxCnssConverter(){
        return this.typeTauxCnssConverter;
        }
        public void setTypeTauxCnssConverter(TypeTauxCnssConverter typeTauxCnssConverter ){
        this.typeTauxCnssConverter = typeTauxCnssConverter;
        }

    public boolean  isTypeTauxCnss(){
    return this.typeTauxCnss;
    }
    public void  setTypeTauxCnss(boolean typeTauxCnss){
    this.typeTauxCnss = typeTauxCnss;
    }


























}
