package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.EtatDeclarationTva;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.EtatDeclarationTvaVo;
import org.springframework.stereotype.Component;

@Component
public class EtatDeclarationTvaConverter extends AbstractConverter<EtatDeclarationTva, EtatDeclarationTvaVo> {


    public EtatDeclarationTvaConverter() {
        init(true);
    }

    @Override
    public EtatDeclarationTva toItem(EtatDeclarationTvaVo vo) {
        if (vo == null) {
            return null;
        } else {
            EtatDeclarationTva item = new EtatDeclarationTva();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getLibelle()))
                item.setLibelle(vo.getLibelle());
            if (vo.getArchive() != null)
                item.setArchive(vo.getArchive());
            if (StringUtil.isNotEmpty(vo.getDateArchivage()))
                item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
            if (StringUtil.isNotEmpty(vo.getDateCreation()))
                item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
            if (vo.getAdmin() != null)
                item.setAdmin(vo.getAdmin());
            if (vo.getVisible() != null)
                item.setVisible(vo.getVisible());
            if (StringUtil.isNotEmpty(vo.getUsername()))
                item.setUsername(vo.getUsername());


            return item;
        }
    }

    @Override
    public EtatDeclarationTvaVo toVo(EtatDeclarationTva item) {
        if (item == null) {
            return null;
        } else {
            EtatDeclarationTvaVo vo = new EtatDeclarationTvaVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (StringUtil.isNotEmpty(item.getLibelle()))
                vo.setLibelle(item.getLibelle());

            if (item.getArchive() != null)
                vo.setArchive(item.getArchive());
            if (item.getDateArchivage() != null)
                vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
            if (item.getDateCreation() != null)
                vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
            if (item.getAdmin() != null)
                vo.setAdmin(item.getAdmin());
            if (item.getVisible() != null)
                vo.setVisible(item.getVisible());
            if (StringUtil.isNotEmpty(item.getUsername()))
                vo.setUsername(item.getUsername());


            return vo;
        }
    }

    public void init(Boolean value) {
    }


}
