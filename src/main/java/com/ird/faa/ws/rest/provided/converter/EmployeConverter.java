package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Employe;
import com.ird.faa.ws.rest.provided.vo.EmployeVo;

@Component
public class EmployeConverter extends AbstractConverter<Employe,EmployeVo>{

        @Autowired
        private SocieteConverter societeConverter ;
        @Autowired
        private DeclarationCnssConverter declarationCnssConverter ;
        @Autowired
        private TypeEmployeConverter typeEmployeConverter ;
    private Boolean typeEmploye;
    private Boolean societe;
    private Boolean declarationCnss;

public  EmployeConverter(){
init(true);
}

@Override
public Employe toItem(EmployeVo vo) {
if (vo == null) {
return null;
} else {
Employe item = new Employe();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCin()))
        item.setCin(vo.getCin());
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
        if(StringUtil.isNotEmpty(vo.getTotalSalaireNet()))
        item.setTotalSalaireNet(NumberUtil.toBigDecimal(vo.getTotalSalaireNet()));
        if(StringUtil.isNotEmpty(vo.getNombreFamille()))
        item.setNombreFamille(NumberUtil.toBigDecimal(vo.getNombreFamille()));
    if(vo.getTypeEmployeVo()!=null && this.typeEmploye)
        item.setTypeEmploye(typeEmployeConverter.toItem(vo.getTypeEmployeVo())) ;
    if(vo.getSocieteVo()!=null && this.societe)
        item.setSociete(societeConverter.toItem(vo.getSocieteVo())) ;
    if(vo.getDeclarationCnssVo()!=null && this.declarationCnss)
        item.setDeclarationCnss(declarationCnssConverter.toItem(vo.getDeclarationCnssVo())) ;


return item;
}
}

@Override
public EmployeVo toVo(Employe item) {
if (item == null) {
return null;
} else {
EmployeVo vo = new EmployeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getCin()))
        vo.setCin(item.getCin());

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

        if(item.getTotalSalaireNet()!=null)
        vo.setTotalSalaireNet(NumberUtil.toString(item.getTotalSalaireNet()));

        if(item.getNombreFamille()!=null)
        vo.setNombreFamille(NumberUtil.toString(item.getNombreFamille()));

    if(item.getTypeEmploye()!=null && this.typeEmploye) {
        vo.setTypeEmployeVo(typeEmployeConverter.toVo(item.getTypeEmploye())) ;
    }
    if(item.getSociete()!=null && this.societe) {
        vo.setSocieteVo(societeConverter.toVo(item.getSociete())) ;
    }
    if(item.getDeclarationCnss()!=null && this.declarationCnss) {
                declarationCnssConverter.setEmploye(false);
        vo.setDeclarationCnssVo(declarationCnssConverter.toVo(item.getDeclarationCnss())) ;
                declarationCnssConverter.setEmploye(true);
    }

return vo;
}
}

public void init(Boolean value) {
    typeEmploye = value;
    societe = value;
    declarationCnss = value;
}


        public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
        }
        public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
        }
        public DeclarationCnssConverter getDeclarationCnssConverter(){
        return this.declarationCnssConverter;
        }
        public void setDeclarationCnssConverter(DeclarationCnssConverter declarationCnssConverter ){
        this.declarationCnssConverter = declarationCnssConverter;
        }
        public TypeEmployeConverter getTypeEmployeConverter(){
        return this.typeEmployeConverter;
        }
        public void setTypeEmployeConverter(TypeEmployeConverter typeEmployeConverter ){
        this.typeEmployeConverter = typeEmployeConverter;
        }

    public boolean  isTypeEmploye(){
    return this.typeEmploye;
    }
    public void  setTypeEmploye(boolean typeEmploye){
    this.typeEmploye = typeEmploye;
    }
    public boolean  isSociete(){
    return this.societe;
    }
    public void  setSociete(boolean societe){
    this.societe = societe;
    }
    public boolean  isDeclarationCnss(){
    return this.declarationCnss;
    }
    public void  setDeclarationCnss(boolean declarationCnss){
    this.declarationCnss = declarationCnss;
    }


















}
