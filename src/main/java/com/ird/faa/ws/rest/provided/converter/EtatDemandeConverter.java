package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatDemande;
import com.ird.faa.ws.rest.provided.vo.EtatDemandeVo;

@Component
public class EtatDemandeConverter extends AbstractConverter<EtatDemande,EtatDemandeVo>{


public  EtatDemandeConverter(){
init(true);
}

@Override
public EtatDemande toItem(EtatDemandeVo vo) {
if (vo == null) {
return null;
} else {
EtatDemande item = new EtatDemande();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCouleur()))
        item.setCouleur(vo.getCouleur());


return item;
}
}

@Override
public EtatDemandeVo toVo(EtatDemande item) {
if (item == null) {
return null;
} else {
EtatDemandeVo vo = new EtatDemandeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCouleur()))
        vo.setCouleur(item.getCouleur());


return vo;
}
}

public void init(Boolean value) {
}











}
