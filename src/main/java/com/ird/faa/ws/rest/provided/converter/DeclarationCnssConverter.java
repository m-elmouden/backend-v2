package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.DeclarationCnss;
import com.ird.faa.ws.rest.provided.vo.DeclarationCnssVo;

@Component
public class DeclarationCnssConverter extends AbstractConverter<DeclarationCnss,DeclarationCnssVo>{

        @Autowired
        private SocieteConverter societeConverter ;
        @Autowired
        private EmployeConverter employeConverter ;
        @Autowired
        private DeclarationCnssDetailConverter declarationCnssDetailConverter ;
    private Boolean employe;
    private Boolean societe;
        private Boolean declarationCnssDetails;

public  DeclarationCnssConverter(){
init(true);
}

@Override
public DeclarationCnss toItem(DeclarationCnssVo vo) {
if (vo == null) {
return null;
} else {
DeclarationCnss item = new DeclarationCnss();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getRef()))
        item.setRef(vo.getRef());
        if(StringUtil.isNotEmpty(vo.getSalaireNet()))
        item.setSalaireNet(NumberUtil.toBigDecimal(vo.getSalaireNet()));
        if(StringUtil.isNotEmpty(vo.getSalaireBrut()))
        item.setSalaireBrut(NumberUtil.toBigDecimal(vo.getSalaireBrut()));
        if(StringUtil.isNotEmpty(vo.getSalaireImposable()))
        item.setSalaireImposable(NumberUtil.toBigDecimal(vo.getSalaireImposable()));
        if(StringUtil.isNotEmpty(vo.getMontantTotal()))
        item.setMontantTotal(NumberUtil.toBigDecimal(vo.getMontantTotal()));
        if(StringUtil.isNotEmpty(vo.getMois()))
        item.setMois(NumberUtil.toBigDecimal(vo.getMois()));
        if(StringUtil.isNotEmpty(vo.getAnnee()))
        item.setAnnee(NumberUtil.toBigDecimal(vo.getAnnee()));
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
            if(vo.getAdmin() != null)
            item.setAdmin(vo.getAdmin());
            if(vo.getVisible() != null)
            item.setVisible(vo.getVisible());
        if(StringUtil.isNotEmpty(vo.getUsername()))
        item.setUsername(vo.getUsername());
    if(vo.getEmployeVo()!=null && this.employe)
        item.setEmploye(employeConverter.toItem(vo.getEmployeVo())) ;
    if(vo.getSocieteVo()!=null && this.societe)
        item.setSociete(societeConverter.toItem(vo.getSocieteVo())) ;

    if(ListUtil.isNotEmpty(vo.getDeclarationCnssDetailsVo()) && this.declarationCnssDetails)
        item.setDeclarationCnssDetails(declarationCnssDetailConverter.toItem(vo.getDeclarationCnssDetailsVo()));

return item;
}
}

@Override
public DeclarationCnssVo toVo(DeclarationCnss item) {
if (item == null) {
return null;
} else {
DeclarationCnssVo vo = new DeclarationCnssVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getRef()))
        vo.setRef(item.getRef());

        if(item.getSalaireNet()!=null)
        vo.setSalaireNet(NumberUtil.toString(item.getSalaireNet()));

        if(item.getSalaireBrut()!=null)
        vo.setSalaireBrut(NumberUtil.toString(item.getSalaireBrut()));

        if(item.getSalaireImposable()!=null)
        vo.setSalaireImposable(NumberUtil.toString(item.getSalaireImposable()));

        if(item.getMontantTotal()!=null)
        vo.setMontantTotal(NumberUtil.toString(item.getMontantTotal()));

        if(item.getMois()!=null)
        vo.setMois(NumberUtil.toString(item.getMois()));

        if(item.getAnnee()!=null)
        vo.setAnnee(NumberUtil.toString(item.getAnnee()));

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
        if(item.getAdmin()!=null)
        vo.setAdmin(item.getAdmin());
        if(item.getVisible()!=null)
        vo.setVisible(item.getVisible());
        if(StringUtil.isNotEmpty(item.getUsername()))
        vo.setUsername(item.getUsername());

    if(item.getEmploye()!=null && this.employe) {
                employeConverter.setDeclarationCnss(false);
        vo.setEmployeVo(employeConverter.toVo(item.getEmploye())) ;
                employeConverter.setDeclarationCnss(true);
    }
    if(item.getSociete()!=null && this.societe) {
        vo.setSocieteVo(societeConverter.toVo(item.getSociete())) ;
    }
        if(ListUtil.isNotEmpty(item.getDeclarationCnssDetails()) && this.declarationCnssDetails){
        declarationCnssDetailConverter.init(true);
        declarationCnssDetailConverter.setDeclarationCnss(false);
        vo.setDeclarationCnssDetailsVo(declarationCnssDetailConverter.toVo(item.getDeclarationCnssDetails()));
        declarationCnssDetailConverter.setDeclarationCnss(true);
        }

return vo;
}
}

public void init(Boolean value) {
    employe = value;
    societe = value;
        declarationCnssDetails = value;
}


        public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
        }
        public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
        }
        public EmployeConverter getEmployeConverter(){
        return this.employeConverter;
        }
        public void setEmployeConverter(EmployeConverter employeConverter ){
        this.employeConverter = employeConverter;
        }
        public DeclarationCnssDetailConverter getDeclarationCnssDetailConverter(){
        return this.declarationCnssDetailConverter;
        }
        public void setDeclarationCnssDetailConverter(DeclarationCnssDetailConverter declarationCnssDetailConverter ){
        this.declarationCnssDetailConverter = declarationCnssDetailConverter;
        }

    public boolean  isEmploye(){
    return this.employe;
    }
    public void  setEmploye(boolean employe){
    this.employe = employe;
    }
    public boolean  isSociete(){
    return this.societe;
    }
    public void  setSociete(boolean societe){
    this.societe = societe;
    }















        public Boolean  isDeclarationCnssDetails(){
        return this.declarationCnssDetails ;
        }
        public void  setDeclarationCnssDetails(Boolean declarationCnssDetails ){
        this.declarationCnssDetails  = declarationCnssDetails ;
        }




















}
