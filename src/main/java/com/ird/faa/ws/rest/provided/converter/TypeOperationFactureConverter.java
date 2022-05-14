package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypeOperationFacture;
import com.ird.faa.ws.rest.provided.vo.TypeOperationFactureVo;

@Component
public class TypeOperationFactureConverter extends AbstractConverter<TypeOperationFacture,TypeOperationFactureVo>{


public  TypeOperationFactureConverter(){
init(true);
}

@Override
public TypeOperationFacture toItem(TypeOperationFactureVo vo) {
if (vo == null) {
return null;
} else {
TypeOperationFacture item = new TypeOperationFacture();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getTypeOperationSociete()))
        item.setTypeOperationSociete(vo.getTypeOperationSociete());


return item;
}
}

@Override
public TypeOperationFactureVo toVo(TypeOperationFacture item) {
if (item == null) {
return null;
} else {
TypeOperationFactureVo vo = new TypeOperationFactureVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getTypeOperationSociete()))
        vo.setTypeOperationSociete(item.getTypeOperationSociete());


return vo;
}
}

public void init(Boolean value) {
}









}
