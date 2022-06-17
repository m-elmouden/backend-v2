package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.TypeSociete;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.TypeSocieteVo;
import org.springframework.stereotype.Component;

@Component
public class TypeSocieteConverter extends AbstractConverter<TypeSociete, TypeSocieteVo> {


    public TypeSocieteConverter() {
        init(true);
    }

    @Override
    public TypeSociete toItem(TypeSocieteVo vo) {
        if (vo == null) {
            return null;
        } else {
            TypeSociete item = new TypeSociete();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getCode()))
                item.setCode(vo.getCode());
            if (StringUtil.isNotEmpty(vo.getLibelle()))
                item.setLibelle(vo.getLibelle());


            return item;
        }
    }

    @Override
    public TypeSocieteVo toVo(TypeSociete item) {
        if (item == null) {
            return null;
        } else {
            TypeSocieteVo vo = new TypeSocieteVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getCode()))
                vo.setCode(item.getCode());

            if (StringUtil.isNotEmpty(item.getLibelle()))
                vo.setLibelle(item.getLibelle());


            return vo;
        }
    }

    public void init(Boolean value) {
    }


}
