package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TauxIr;
import com.ird.faa.ws.rest.provided.vo.TauxIrVo;

@Component
public class TauxIrConverter extends AbstractConverter<TauxIr,TauxIrVo>{


public  TauxIrConverter(){
init(true);
}

@Override
public TauxIr toItem(TauxIrVo vo) {
if (vo == null) {
return null;
} else {
TauxIr item = new TauxIr();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getDateMin()))
        item.setDateMin(DateUtil.parse(vo.getDateMin()));
        if(StringUtil.isNotEmpty(vo.getDateMax()))
        item.setDateMax(DateUtil.parse(vo.getDateMax()));
        if(StringUtil.isNotEmpty(vo.getSalaireImpoMin()))
        item.setSalaireImpoMin(NumberUtil.toBigDecimal(vo.getSalaireImpoMin()));
        if(StringUtil.isNotEmpty(vo.getSalaireImpoMax()))
        item.setSalaireImpoMax(NumberUtil.toBigDecimal(vo.getSalaireImpoMax()));
        if(StringUtil.isNotEmpty(vo.getForfaitDeduit()))
        item.setForfaitDeduit(NumberUtil.toBigDecimal(vo.getForfaitDeduit()));
        if(StringUtil.isNotEmpty(vo.getPourcentage()))
        item.setPourcentage(NumberUtil.toBigDecimal(vo.getPourcentage()));


return item;
}
}

@Override
public TauxIrVo toVo(TauxIr item) {
if (item == null) {
return null;
} else {
TauxIrVo vo = new TauxIrVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getDateMin()!=null)
        vo.setDateMin(DateUtil.formateDate(item.getDateMin()));
        if(item.getDateMax()!=null)
        vo.setDateMax(DateUtil.formateDate(item.getDateMax()));
        if(item.getSalaireImpoMin()!=null)
        vo.setSalaireImpoMin(NumberUtil.toString(item.getSalaireImpoMin()));

        if(item.getSalaireImpoMax()!=null)
        vo.setSalaireImpoMax(NumberUtil.toString(item.getSalaireImpoMax()));

        if(item.getForfaitDeduit()!=null)
        vo.setForfaitDeduit(NumberUtil.toString(item.getForfaitDeduit()));

        if(item.getPourcentage()!=null)
        vo.setPourcentage(NumberUtil.toString(item.getPourcentage()));


return vo;
}
}

public void init(Boolean value) {
}

















}
