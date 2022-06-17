package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.TypeDeclarationTva;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.TypeDeclarationTvaVo;
import org.springframework.stereotype.Component;

@Component
public class TypeDeclarationTvaConverter extends AbstractConverter<TypeDeclarationTva, TypeDeclarationTvaVo> {


    public TypeDeclarationTvaConverter() {
        init(true);
    }

    @Override
    public TypeDeclarationTva toItem(TypeDeclarationTvaVo vo) {
        if (vo == null) {
            return null;
        } else {
            TypeDeclarationTva item = new TypeDeclarationTva();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getLibelle()))
                item.setLibelle(vo.getLibelle());


            return item;
        }
    }

    @Override
    public TypeDeclarationTvaVo toVo(TypeDeclarationTva item) {
        if (item == null) {
            return null;
        } else {
            TypeDeclarationTvaVo vo = new TypeDeclarationTvaVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (StringUtil.isNotEmpty(item.getLibelle()))
                vo.setLibelle(item.getLibelle());


            return vo;
        }
    }

    public void init(Boolean value) {
    }


}
