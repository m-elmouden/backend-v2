package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatPaiement;
import com.ird.faa.ws.rest.provided.vo.EtatPaiementVo;

@Component
public class EtatPaiementConverter extends AbstractConverter<EtatPaiement,EtatPaiementVo>{


public  EtatPaiementConverter(){
init(true);
}

@Override
public EtatPaiement toItem(EtatPaiementVo vo) {
if (vo == null) {
return null;
} else {
EtatPaiement item = new EtatPaiement();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(NumberUtil.toBigDecimal(vo.getCode()));


return item;
}
}

@Override
public EtatPaiementVo toVo(EtatPaiement item) {
if (item == null) {
return null;
} else {
EtatPaiementVo vo = new EtatPaiementVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getCode()!=null)
        vo.setCode(NumberUtil.toString(item.getCode()));


return vo;
}
}

public void init(Boolean value) {
}









}
