package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.DeclarationCnssDetail;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.DeclarationCnssDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeclarationCnssDetailConverter extends AbstractConverter<DeclarationCnssDetail, DeclarationCnssDetailVo> {

    @Autowired
    private TypeTauxCnssConverter typeTauxCnssConverter;
    @Autowired
    private DeclarationCnssConverter declarationCnssConverter;
    private Boolean typeTauxCnss;
    private Boolean declarationCnss;

    public DeclarationCnssDetailConverter() {
        init(true);
    }

    @Override
    public DeclarationCnssDetail toItem(DeclarationCnssDetailVo vo) {
        if (vo == null) {
            return null;
        } else {
            DeclarationCnssDetail item = new DeclarationCnssDetail();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getRef()))
                item.setRef(vo.getRef());
            if (StringUtil.isNotEmpty(vo.getMontantCalcule()))
                item.setMontantCalcule(NumberUtil.toBigDecimal(vo.getMontantCalcule()));
            if (StringUtil.isNotEmpty(vo.getMontantTotal()))
                item.setMontantTotal(NumberUtil.toBigDecimal(vo.getMontantTotal()));
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
            if (vo.getTypeTauxCnssVo() != null && this.typeTauxCnss)
                item.setTypeTauxCnss(typeTauxCnssConverter.toItem(vo.getTypeTauxCnssVo()));
            if (vo.getDeclarationCnssVo() != null && this.declarationCnss)
                item.setDeclarationCnss(declarationCnssConverter.toItem(vo.getDeclarationCnssVo()));


            return item;
        }
    }

    @Override
    public DeclarationCnssDetailVo toVo(DeclarationCnssDetail item) {
        if (item == null) {
            return null;
        } else {
            DeclarationCnssDetailVo vo = new DeclarationCnssDetailVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getRef()))
                vo.setRef(item.getRef());

            if (item.getMontantCalcule() != null)
                vo.setMontantCalcule(NumberUtil.toString(item.getMontantCalcule()));

            if (item.getMontantTotal() != null)
                vo.setMontantTotal(NumberUtil.toString(item.getMontantTotal()));

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

            if (item.getTypeTauxCnss() != null && this.typeTauxCnss) {
                vo.setTypeTauxCnssVo(typeTauxCnssConverter.toVo(item.getTypeTauxCnss()));
            }
            if (item.getDeclarationCnss() != null && this.declarationCnss) {
                vo.setDeclarationCnssVo(declarationCnssConverter.toVo(item.getDeclarationCnss()));
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        typeTauxCnss = value;
        declarationCnss = value;
    }


    public TypeTauxCnssConverter getTypeTauxCnssConverter() {
        return this.typeTauxCnssConverter;
    }

    public void setTypeTauxCnssConverter(TypeTauxCnssConverter typeTauxCnssConverter) {
        this.typeTauxCnssConverter = typeTauxCnssConverter;
    }

    public DeclarationCnssConverter getDeclarationCnssConverter() {
        return this.declarationCnssConverter;
    }

    public void setDeclarationCnssConverter(DeclarationCnssConverter declarationCnssConverter) {
        this.declarationCnssConverter = declarationCnssConverter;
    }

    public boolean isTypeTauxCnss() {
        return this.typeTauxCnss;
    }

    public void setTypeTauxCnss(boolean typeTauxCnss) {
        this.typeTauxCnss = typeTauxCnss;
    }

    public boolean isDeclarationCnss() {
        return this.declarationCnss;
    }

    public void setDeclarationCnss(boolean declarationCnss) {
        this.declarationCnss = declarationCnss;
    }


}
