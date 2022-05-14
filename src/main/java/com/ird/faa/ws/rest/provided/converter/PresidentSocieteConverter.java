package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PresidentSociete;
import com.ird.faa.ws.rest.provided.vo.PresidentSocieteVo;

@Component
public class PresidentSocieteConverter extends AbstractConverter<PresidentSociete,PresidentSocieteVo>{

        @Autowired
        private SocieteConverter societeConverter ;
    private Boolean societe;

public  PresidentSocieteConverter(){
init(true);
}

@Override
public PresidentSociete toItem(PresidentSocieteVo vo) {
if (vo == null) {
return null;
} else {
PresidentSociete item = new PresidentSociete();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCin()))
        item.setCin(vo.getCin());
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
        if(StringUtil.isNotEmpty(vo.getEmail()))
        item.setEmail(vo.getEmail());
        if(StringUtil.isNotEmpty(vo.getTelephone()))
        item.setTelephone(vo.getTelephone());
    if(vo.getSocieteVo()!=null && this.societe)
        item.setSociete(societeConverter.toItem(vo.getSocieteVo())) ;


return item;
}
}

@Override
public PresidentSocieteVo toVo(PresidentSociete item) {
if (item == null) {
return null;
} else {
PresidentSocieteVo vo = new PresidentSocieteVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getCin()))
        vo.setCin(item.getCin());

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

        if(StringUtil.isNotEmpty(item.getEmail()))
        vo.setEmail(item.getEmail());

        if(StringUtil.isNotEmpty(item.getTelephone()))
        vo.setTelephone(item.getTelephone());

    if(item.getSociete()!=null && this.societe) {
                societeConverter.setPresidentSociete(false);
        vo.setSocieteVo(societeConverter.toVo(item.getSociete())) ;
                societeConverter.setPresidentSociete(true);
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
