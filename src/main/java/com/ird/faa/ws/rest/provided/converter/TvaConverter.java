package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Tva;
import com.ird.faa.ws.rest.provided.vo.TvaVo;

@Component
public class TvaConverter extends AbstractConverter<Tva,TvaVo>{


public  TvaConverter(){
init(true);
}

@Override
public Tva toItem(TvaVo vo) {
if (vo == null) {
return null;
} else {
Tva item = new Tva();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getPourcentage()))
        item.setPourcentage(NumberUtil.toBigDecimal(vo.getPourcentage()));


return item;
}
}

@Override
public TvaVo toVo(Tva item) {
if (item == null) {
return null;
} else {
TvaVo vo = new TvaVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getPourcentage()!=null)
        vo.setPourcentage(NumberUtil.toString(item.getPourcentage()));


return vo;
}
}

public void init(Boolean value) {
}









}
