package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.PaiementDeclarationIs;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationIsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaiementDeclarationIsConverter extends AbstractConverter<PaiementDeclarationIs, PaiementDeclarationIsVo> {

    @Autowired
    private DeclarationIsConverter declarationIsConverter;
    private Boolean declarationIs;

    public PaiementDeclarationIsConverter() {
        init(true);
    }

    @Override
    public PaiementDeclarationIs toItem(PaiementDeclarationIsVo vo) {
        if (vo == null) {
            return null;
        } else {
            PaiementDeclarationIs item = new PaiementDeclarationIs();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getDatePaiement()))
                item.setDatePaiement(DateUtil.parse(vo.getDatePaiement()));
            if (StringUtil.isNotEmpty(vo.getTotal()))
                item.setTotal(NumberUtil.toBigDecimal(vo.getTotal()));
            if (StringUtil.isNotEmpty(vo.getMontantCptTraiteur()))
                item.setMontantCptTraiteur(NumberUtil.toBigDecimal(vo.getMontantCptTraiteur()));
            if (StringUtil.isNotEmpty(vo.getMontantCptValidateur()))
                item.setMontantCptValidateur(NumberUtil.toBigDecimal(vo.getMontantCptValidateur()));
            if (StringUtil.isNotEmpty(vo.getReste()))
                item.setReste(NumberUtil.toBigDecimal(vo.getReste()));
            if (vo.getDeclarationIsVo() != null && this.declarationIs)
                item.setDeclarationIs(declarationIsConverter.toItem(vo.getDeclarationIsVo()));


            return item;
        }
    }

    @Override
    public PaiementDeclarationIsVo toVo(PaiementDeclarationIs item) {
        if (item == null) {
            return null;
        } else {
            PaiementDeclarationIsVo vo = new PaiementDeclarationIsVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (item.getDatePaiement() != null)
                vo.setDatePaiement(DateUtil.formateDate(item.getDatePaiement()));
            if (item.getTotal() != null)
                vo.setTotal(NumberUtil.toString(item.getTotal()));

            if (item.getMontantCptTraiteur() != null)
                vo.setMontantCptTraiteur(NumberUtil.toString(item.getMontantCptTraiteur()));

            if (item.getMontantCptValidateur() != null)
                vo.setMontantCptValidateur(NumberUtil.toString(item.getMontantCptValidateur()));

            if (item.getReste() != null)
                vo.setReste(NumberUtil.toString(item.getReste()));

            if (item.getDeclarationIs() != null && this.declarationIs) {
                declarationIsConverter.setPaiementDeclarationIs(false);
                vo.setDeclarationIsVo(declarationIsConverter.toVo(item.getDeclarationIs()));
                declarationIsConverter.setPaiementDeclarationIs(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        declarationIs = value;
    }


    public DeclarationIsConverter getDeclarationIsConverter() {
        return this.declarationIsConverter;
    }

    public void setDeclarationIsConverter(DeclarationIsConverter declarationIsConverter) {
        this.declarationIsConverter = declarationIsConverter;
    }

    public boolean isDeclarationIs() {
        return this.declarationIs;
    }

    public void setDeclarationIs(boolean declarationIs) {
        this.declarationIs = declarationIs;
    }


}
