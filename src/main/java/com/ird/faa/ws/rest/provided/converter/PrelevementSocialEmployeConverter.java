package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.PrelevementSocialEmploye;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.PrelevementSocialEmployeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrelevementSocialEmployeConverter extends AbstractConverter<PrelevementSocialEmploye, PrelevementSocialEmployeVo> {

    @Autowired
    private PrelevementSocialConverter prelevementSocialConverter;
    @Autowired
    private EmployeConverter employeConverter;
    @Autowired
    private DeclarationIrConverter declarationIrConverter;
    private Boolean prelevementSocial;
    private Boolean employe;
    private Boolean declarationIr;

    public PrelevementSocialEmployeConverter() {
        init(true);
    }

    @Override
    public PrelevementSocialEmploye toItem(PrelevementSocialEmployeVo vo) {
        if (vo == null) {
            return null;
        } else {
            PrelevementSocialEmploye item = new PrelevementSocialEmploye();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getSalaireBrutImposable()))
                item.setSalaireBrutImposable(NumberUtil.toBigDecimal(vo.getSalaireBrutImposable()));
            if (StringUtil.isNotEmpty(vo.getMontantCalculer()))
                item.setMontantCalculer(NumberUtil.toBigDecimal(vo.getMontantCalculer()));
            if (vo.getPrelevementSocialVo() != null && this.prelevementSocial)
                item.setPrelevementSocial(prelevementSocialConverter.toItem(vo.getPrelevementSocialVo()));
            if (vo.getEmployeVo() != null && this.employe)
                item.setEmploye(employeConverter.toItem(vo.getEmployeVo()));
            if (vo.getDeclarationIrVo() != null && this.declarationIr)
                item.setDeclarationIr(declarationIrConverter.toItem(vo.getDeclarationIrVo()));


            return item;
        }
    }

    @Override
    public PrelevementSocialEmployeVo toVo(PrelevementSocialEmploye item) {
        if (item == null) {
            return null;
        } else {
            PrelevementSocialEmployeVo vo = new PrelevementSocialEmployeVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (item.getSalaireBrutImposable() != null)
                vo.setSalaireBrutImposable(NumberUtil.toString(item.getSalaireBrutImposable()));

            if (item.getMontantCalculer() != null)
                vo.setMontantCalculer(NumberUtil.toString(item.getMontantCalculer()));

            if (item.getPrelevementSocial() != null && this.prelevementSocial) {
                vo.setPrelevementSocialVo(prelevementSocialConverter.toVo(item.getPrelevementSocial()));
            }
            if (item.getEmploye() != null && this.employe) {
                vo.setEmployeVo(employeConverter.toVo(item.getEmploye()));
            }
            if (item.getDeclarationIr() != null && this.declarationIr) {
                vo.setDeclarationIrVo(declarationIrConverter.toVo(item.getDeclarationIr()));
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        prelevementSocial = value;
        employe = value;
        declarationIr = value;
    }


    public PrelevementSocialConverter getPrelevementSocialConverter() {
        return this.prelevementSocialConverter;
    }

    public void setPrelevementSocialConverter(PrelevementSocialConverter prelevementSocialConverter) {
        this.prelevementSocialConverter = prelevementSocialConverter;
    }

    public EmployeConverter getEmployeConverter() {
        return this.employeConverter;
    }

    public void setEmployeConverter(EmployeConverter employeConverter) {
        this.employeConverter = employeConverter;
    }

    public DeclarationIrConverter getDeclarationIrConverter() {
        return this.declarationIrConverter;
    }

    public void setDeclarationIrConverter(DeclarationIrConverter declarationIrConverter) {
        this.declarationIrConverter = declarationIrConverter;
    }

    public boolean isPrelevementSocial() {
        return this.prelevementSocial;
    }

    public void setPrelevementSocial(boolean prelevementSocial) {
        this.prelevementSocial = prelevementSocial;
    }

    public boolean isEmploye() {
        return this.employe;
    }

    public void setEmploye(boolean employe) {
        this.employe = employe;
    }

    public boolean isDeclarationIr() {
        return this.declarationIr;
    }

    public void setDeclarationIr(boolean declarationIr) {
        this.declarationIr = declarationIr;
    }


}
