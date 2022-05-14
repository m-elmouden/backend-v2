package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypeComptable;
import com.ird.faa.ws.rest.provided.vo.TypeComptableVo;

@Component
public class TypeComptableConverter extends AbstractConverter<TypeComptable,TypeComptableVo>{


public  TypeComptableConverter(){
init(true);
}

@Override
public TypeComptable toItem(TypeComptableVo vo) {
if (vo == null) {
return null;
} else {
TypeComptable item = new TypeComptable();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());


return item;
}
}

@Override
public TypeComptableVo toVo(TypeComptable item) {
if (item == null) {
return null;
} else {
TypeComptableVo vo = new TypeComptableVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());


return vo;
}
}

public void init(Boolean value) {
}









}
