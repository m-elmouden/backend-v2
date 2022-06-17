package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.PaiementDeclarationIr;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationIrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaiementDeclarationIrConverter extends AbstractConverter<PaiementDeclarationIr, PaiementDeclarationIrVo> {

    @Autowired
    private DeclarationIrConverter declarationIrConverter;
    private Boolean declarationIr;

    public PaiementDeclarationIrConverter() {
        init(true);
    }

    @Override
    public PaiementDeclarationIr toItem(PaiementDeclarationIrVo vo) {
        if (vo == null) {
            return null;
        } else {
            PaiementDeclarationIr item = new PaiementDeclarationIr();
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
            if (vo.getDeclarationIrVo() != null && this.declarationIr)
                item.setDeclarationIr(declarationIrConverter.toItem(vo.getDeclarationIrVo()));


            return item;
        }
    }

    @Override
    public PaiementDeclarationIrVo toVo(PaiementDeclarationIr item) {
        if (item == null) {
            return null;
        } else {
            PaiementDeclarationIrVo vo = new PaiementDeclarationIrVo();
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

            if (item.getDeclarationIr() != null && this.declarationIr) {
                declarationIrConverter.setPaiementDeclarationIr(false);
                vo.setDeclarationIrVo(declarationIrConverter.toVo(item.getDeclarationIr()));
                declarationIrConverter.setPaiementDeclarationIr(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        declarationIr = value;
    }


    public DeclarationIrConverter getDeclarationIrConverter() {
        return this.declarationIrConverter;
    }

    public void setDeclarationIrConverter(DeclarationIrConverter declarationIrConverter) {
        this.declarationIrConverter = declarationIrConverter;
    }

    public boolean isDeclarationIr() {
        return this.declarationIr;
    }

    public void setDeclarationIr(boolean declarationIr) {
        this.declarationIr = declarationIr;
    }


}
