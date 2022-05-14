package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PaiementDeclarationTva;
import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationTvaVo;

@Component
public class PaiementDeclarationTvaConverter extends AbstractConverter<PaiementDeclarationTva,PaiementDeclarationTvaVo>{

        @Autowired
        private DeclarationTvaConverter declarationTvaConverter ;
    private Boolean declarationTva;

public  PaiementDeclarationTvaConverter(){
init(true);
}

@Override
public PaiementDeclarationTva toItem(PaiementDeclarationTvaVo vo) {
if (vo == null) {
return null;
} else {
PaiementDeclarationTva item = new PaiementDeclarationTva();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getDatePaiement()))
        item.setDatePaiement(DateUtil.parse(vo.getDatePaiement()));
        if(StringUtil.isNotEmpty(vo.getTotal()))
        item.setTotal(NumberUtil.toBigDecimal(vo.getTotal()));
        if(StringUtil.isNotEmpty(vo.getMontantCptTraiteur()))
        item.setMontantCptTraiteur(NumberUtil.toBigDecimal(vo.getMontantCptTraiteur()));
        if(StringUtil.isNotEmpty(vo.getMontantCptValidateur()))
        item.setMontantCptValidateur(NumberUtil.toBigDecimal(vo.getMontantCptValidateur()));
        if(StringUtil.isNotEmpty(vo.getReste()))
        item.setReste(NumberUtil.toBigDecimal(vo.getReste()));
    if(vo.getDeclarationTvaVo()!=null && this.declarationTva)
        item.setDeclarationTva(declarationTvaConverter.toItem(vo.getDeclarationTvaVo())) ;


return item;
}
}

@Override
public PaiementDeclarationTvaVo toVo(PaiementDeclarationTva item) {
if (item == null) {
return null;
} else {
PaiementDeclarationTvaVo vo = new PaiementDeclarationTvaVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getDatePaiement()!=null)
        vo.setDatePaiement(DateUtil.formateDate(item.getDatePaiement()));
        if(item.getTotal()!=null)
        vo.setTotal(NumberUtil.toString(item.getTotal()));

        if(item.getMontantCptTraiteur()!=null)
        vo.setMontantCptTraiteur(NumberUtil.toString(item.getMontantCptTraiteur()));

        if(item.getMontantCptValidateur()!=null)
        vo.setMontantCptValidateur(NumberUtil.toString(item.getMontantCptValidateur()));

        if(item.getReste()!=null)
        vo.setReste(NumberUtil.toString(item.getReste()));

    if(item.getDeclarationTva()!=null && this.declarationTva) {
                declarationTvaConverter.setPaiementDeclarationTva(false);
        vo.setDeclarationTvaVo(declarationTvaConverter.toVo(item.getDeclarationTva())) ;
                declarationTvaConverter.setPaiementDeclarationTva(true);
    }

return vo;
}
}

public void init(Boolean value) {
    declarationTva = value;
}


        public DeclarationTvaConverter getDeclarationTvaConverter(){
        return this.declarationTvaConverter;
        }
        public void setDeclarationTvaConverter(DeclarationTvaConverter declarationTvaConverter ){
        this.declarationTvaConverter = declarationTvaConverter;
        }

    public boolean  isDeclarationTva(){
    return this.declarationTva;
    }
    public void  setDeclarationTva(boolean declarationTva){
    this.declarationTva = declarationTva;
    }
















}
