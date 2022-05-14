package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Acompte;
import com.ird.faa.ws.rest.provided.vo.AcompteVo;

@Component
public class AcompteConverter extends AbstractConverter<Acompte,AcompteVo>{

        @Autowired
        private SocieteConverter societeConverter ;
    private Boolean societe;

public  AcompteConverter(){
init(true);
}

@Override
public Acompte toItem(AcompteVo vo) {
if (vo == null) {
return null;
} else {
Acompte item = new Acompte();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getNumero()))
        item.setNumero(NumberUtil.toLong(vo.getNumero()));
        if(StringUtil.isNotEmpty(vo.getAnnee()))
        item.setAnnee(NumberUtil.toBigDecimal(vo.getAnnee()));
        if(StringUtil.isNotEmpty(vo.getMontant()))
        item.setMontant(NumberUtil.toBigDecimal(vo.getMontant()));
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
    if(vo.getSocieteVo()!=null && this.societe)
        item.setSociete(societeConverter.toItem(vo.getSocieteVo())) ;


return item;
}
}

@Override
public AcompteVo toVo(Acompte item) {
if (item == null) {
return null;
} else {
AcompteVo vo = new AcompteVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getNumero()!=null)
        vo.setNumero(NumberUtil.toString(item.getNumero()));

        if(item.getAnnee()!=null)
        vo.setAnnee(NumberUtil.toString(item.getAnnee()));

        if(item.getMontant()!=null)
        vo.setMontant(NumberUtil.toString(item.getMontant()));

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

    if(item.getSociete()!=null && this.societe) {
        vo.setSocieteVo(societeConverter.toVo(item.getSociete())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    societe = value;
}


        public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
        }
        public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
        }

    public boolean  isSociete(){
    return this.societe;
    }
    public void  setSociete(boolean societe){
    this.societe = societe;
    }






















}
