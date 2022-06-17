package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.DeclarationIrEmploye;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.DeclarationIrEmployeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeclarationIrEmployeConverter extends AbstractConverter<DeclarationIrEmploye, DeclarationIrEmployeVo> {

    @Autowired
    private TauxIrConverter tauxIrConverter;
    @Autowired
    private DeclarationIrConverter declarationIrConverter;
    @Autowired
    private EmployeConverter employeConverter;
    private Boolean declarationIr;
    private Boolean employe;
    private Boolean tauxIr;

    public DeclarationIrEmployeConverter() {
        init(true);
    }

    @Override
    public DeclarationIrEmploye toItem(DeclarationIrEmployeVo vo) {
        if (vo == null) {
            return null;
        } else {
            DeclarationIrEmploye item = new DeclarationIrEmploye();
            if (StringUtil.isNotEmpty(vo.getId())) item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getSalaireNet()))
                item.setSalaireNet(NumberUtil.toBigDecimal(vo.getSalaireNet()));
            if (StringUtil.isNotEmpty(vo.getSalaireBrut()))
                item.setSalaireBrut(NumberUtil.toBigDecimal(vo.getSalaireBrut()));
            if (StringUtil.isNotEmpty(vo.getSalaireNetImposable()))
                item.setSalaireNetImposable(NumberUtil.toBigDecimal(vo.getSalaireNetImposable()));
            if (StringUtil.isNotEmpty(vo.getSalaireBrutImposable()))
                item.setSalaireBrutImposable(NumberUtil.toBigDecimal(vo.getSalaireBrutImposable()));
            if (StringUtil.isNotEmpty(vo.getSalaireBase()))
                item.setSalaireBase(NumberUtil.toBigDecimal(vo.getSalaireBase()));
            if (StringUtil.isNotEmpty(vo.getIndemnite()))
                item.setIndemnite(NumberUtil.toBigDecimal(vo.getIndemnite()));
            if (StringUtil.isNotEmpty(vo.getPrimes())) item.setPrimes(NumberUtil.toBigDecimal(vo.getPrimes()));
            if (StringUtil.isNotEmpty(vo.getIndemniteJustifie()))
                item.setIndemniteJustifie(NumberUtil.toBigDecimal(vo.getIndemniteJustifie()));
            if (StringUtil.isNotEmpty(vo.getAvantage())) item.setAvantage(NumberUtil.toBigDecimal(vo.getAvantage()));
            if (StringUtil.isNotEmpty(vo.getHeuresSupplementaires()))
                item.setHeuresSupplementaires(NumberUtil.toBigDecimal(vo.getHeuresSupplementaires()));
            if (StringUtil.isNotEmpty(vo.getPourcentageAnciennete()))
                item.setPourcentageAnciennete(NumberUtil.toBigDecimal(vo.getPourcentageAnciennete()));
            if (StringUtil.isNotEmpty(vo.getCotisation()))
                item.setCotisation(NumberUtil.toBigDecimal(vo.getCotisation()));
            if (vo.getDeclarationIrVo() != null && this.declarationIr)
                item.setDeclarationIr(declarationIrConverter.toItem(vo.getDeclarationIrVo()));
            if (vo.getEmployeVo() != null && this.employe) item.setEmploye(employeConverter.toItem(vo.getEmployeVo()));
            if (vo.getTauxIrVo() != null && this.tauxIr) item.setTauxIr(tauxIrConverter.toItem(vo.getTauxIrVo()));


            return item;
        }
    }

    @Override
    public DeclarationIrEmployeVo toVo(DeclarationIrEmploye item) {
        if (item == null) {
            return null;
        } else {
            DeclarationIrEmployeVo vo = new DeclarationIrEmployeVo();
            if (item.getId() != null) vo.setId(NumberUtil.toString(item.getId()));

            if (item.getSalaireNet() != null) vo.setSalaireNet(NumberUtil.toString(item.getSalaireNet()));

            if (item.getSalaireBrut() != null) vo.setSalaireBrut(NumberUtil.toString(item.getSalaireBrut()));

            if (item.getSalaireNetImposable() != null)
                vo.setSalaireNetImposable(NumberUtil.toString(item.getSalaireNetImposable()));

            if (item.getSalaireBrutImposable() != null)
                vo.setSalaireBrutImposable(NumberUtil.toString(item.getSalaireBrutImposable()));

            if (item.getSalaireBase() != null) vo.setSalaireBase(NumberUtil.toString(item.getSalaireBase()));

            if (item.getPrimes() != null) vo.setPrimes(NumberUtil.toString(item.getPrimes()));

            if (item.getIndemnite() != null) vo.setIndemnite(NumberUtil.toString(item.getIndemnite()));

            if (item.getIndemniteJustifie() != null)
                vo.setIndemniteJustifie(NumberUtil.toString(item.getIndemniteJustifie()));

            if (item.getHeuresSupplementaires() != null)
                vo.setHeuresSupplementaires(NumberUtil.toString(item.getHeuresSupplementaires()));

            if (item.getAvantage() != null) vo.setAvantage(NumberUtil.toString(item.getAvantage()));

            if (item.getPourcentageAnciennete() != null)
                vo.setPourcentageAnciennete(NumberUtil.toString(item.getPourcentageAnciennete()));

            if (item.getCotisation() != null) vo.setCotisation(NumberUtil.toString(item.getCotisation()));

            if (item.getDeclarationIr() != null && this.declarationIr) {
                vo.setDeclarationIrVo(declarationIrConverter.toVo(item.getDeclarationIr()));
            }
            if (item.getEmploye() != null && this.employe) {
                vo.setEmployeVo(employeConverter.toVo(item.getEmploye()));
            }
            if (item.getTauxIr() != null && this.tauxIr) {
                vo.setTauxIrVo(tauxIrConverter.toVo(item.getTauxIr()));
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        declarationIr = value;
        employe = value;
        tauxIr = value;
    }


    public TauxIrConverter getTauxIrConverter() {
        return this.tauxIrConverter;
    }

    public void setTauxIrConverter(TauxIrConverter tauxIrConverter) {
        this.tauxIrConverter = tauxIrConverter;
    }

    public DeclarationIrConverter getDeclarationIrConverter() {
        return this.declarationIrConverter;
    }

    public void setDeclarationIrConverter(DeclarationIrConverter declarationIrConverter) {
        this.declarationIrConverter = declarationIrConverter;
    }

    public EmployeConverter getEmployeConverter() {
        return this.employeConverter;
    }

    public void setEmployeConverter(EmployeConverter employeConverter) {
        this.employeConverter = employeConverter;
    }

    public boolean isDeclarationIr() {
        return this.declarationIr;
    }

    public void setDeclarationIr(boolean declarationIr) {
        this.declarationIr = declarationIr;
    }

    public boolean isEmploye() {
        return this.employe;
    }

    public void setEmploye(boolean employe) {
        this.employe = employe;
    }

    public boolean isTauxIr() {
        return this.tauxIr;
    }

    public void setTauxIr(boolean tauxIr) {
        this.tauxIr = tauxIr;
    }


}
