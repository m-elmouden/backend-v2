package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypeEmploye;
import com.ird.faa.ws.rest.provided.vo.TypeEmployeVo;

@Component
public class TypeEmployeConverter extends AbstractConverter<TypeEmploye,TypeEmployeVo>{


public  TypeEmployeConverter(){
init(true);
}

@Override
public TypeEmploye toItem(TypeEmployeVo vo) {
if (vo == null) {
return null;
} else {
TypeEmploye item = new TypeEmploye();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());


return item;
}
}

@Override
public TypeEmployeVo toVo(TypeEmploye item) {
if (item == null) {
return null;
} else {
TypeEmployeVo vo = new TypeEmployeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());


return vo;
}
}

public void init(Boolean value) {
}









}
