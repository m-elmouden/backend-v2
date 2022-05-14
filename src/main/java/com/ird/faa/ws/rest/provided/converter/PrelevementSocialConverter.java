package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PrelevementSocial;
import com.ird.faa.ws.rest.provided.vo.PrelevementSocialVo;

@Component
public class PrelevementSocialConverter extends AbstractConverter<PrelevementSocial,PrelevementSocialVo>{


public  PrelevementSocialConverter(){
init(true);
}

@Override
public PrelevementSocial toItem(PrelevementSocialVo vo) {
if (vo == null) {
return null;
} else {
PrelevementSocial item = new PrelevementSocial();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getPourcentage()))
        item.setPourcentage(NumberUtil.toBigDecimal(vo.getPourcentage()));
        if(StringUtil.isNotEmpty(vo.getDateMax()))
        item.setDateMax(DateUtil.parse(vo.getDateMax()));
        if(StringUtil.isNotEmpty(vo.getDateMin()))
        item.setDateMin(DateUtil.parse(vo.getDateMin()));


return item;
}
}

@Override
public PrelevementSocialVo toVo(PrelevementSocial item) {
if (item == null) {
return null;
} else {
PrelevementSocialVo vo = new PrelevementSocialVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getPourcentage()!=null)
        vo.setPourcentage(NumberUtil.toString(item.getPourcentage()));

        if(item.getDateMax()!=null)
        vo.setDateMax(DateUtil.formateDate(item.getDateMax()));
        if(item.getDateMin()!=null)
        vo.setDateMin(DateUtil.formateDate(item.getDateMin()));

return vo;
}
}

public void init(Boolean value) {
}













}
