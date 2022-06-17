package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.EtatFacture;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.EtatFactureVo;
import org.springframework.stereotype.Component;

@Component
public class EtatFactureConverter extends AbstractConverter<EtatFacture, EtatFactureVo> {


    public EtatFactureConverter() {
        init(true);
    }

    @Override
    public EtatFacture toItem(EtatFactureVo vo) {
        if (vo == null) {
            return null;
        } else {
            EtatFacture item = new EtatFacture();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getLibelle()))
                item.setLibelle(vo.getLibelle());
            if (StringUtil.isNotEmpty(vo.getCode()))
                item.setCode(NumberUtil.toBigDecimal(vo.getCode()));


            return item;
        }
    }

    @Override
    public EtatFactureVo toVo(EtatFacture item) {
        if (item == null) {
            return null;
        } else {
            EtatFactureVo vo = new EtatFactureVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getLibelle()))
                vo.setLibelle(item.getLibelle());

            if (item.getCode() != null)
                vo.setCode(NumberUtil.toString(item.getCode()));


            return vo;
        }
    }

    public void init(Boolean value) {
    }


}
