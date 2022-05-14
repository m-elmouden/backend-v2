package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.DeclarationIs;
import com.ird.faa.ws.rest.provided.vo.DeclarationIsVo;

@Component
public class DeclarationIsConverter extends AbstractConverter<DeclarationIs,DeclarationIsVo>{

        @Autowired
        private SocieteConverter societeConverter ;
        @Autowired
        private EtatDeclarationIsConverter etatDeclarationIsConverter ;
        @Autowired
        private TauxIsConfigConverter tauxIsConfigConverter ;
        @Autowired
        private TauxIsConverter tauxIsConverter ;
        @Autowired
        private PaiementDeclarationIsConverter paiementDeclarationIsConverter ;
    private Boolean societe;
    private Boolean tauxIs;
    private Boolean tauxIsConfig;
    private Boolean etatDeclarationIs;
    private Boolean paiementDeclarationIs;

public  DeclarationIsConverter(){
init(true);
}

@Override
public DeclarationIs toItem(DeclarationIsVo vo) {
if (vo == null) {
return null;
} else {
DeclarationIs item = new DeclarationIs();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getAnnee()))
        item.setAnnee(NumberUtil.toBigDecimal(vo.getAnnee()));
        if(StringUtil.isNotEmpty(vo.getTotalHtProduit()))
        item.setTotalHtProduit(NumberUtil.toBigDecimal(vo.getTotalHtProduit()));
        if(StringUtil.isNotEmpty(vo.getTotalHtCharge()))
        item.setTotalHtCharge(NumberUtil.toBigDecimal(vo.getTotalHtCharge()));
        if(StringUtil.isNotEmpty(vo.getTotalHtDifference()))
        item.setTotalHtDifference(NumberUtil.toBigDecimal(vo.getTotalHtDifference()));
        if(StringUtil.isNotEmpty(vo.getMontantIsCalcule()))
        item.setMontantIsCalcule(NumberUtil.toBigDecimal(vo.getMontantIsCalcule()));
        if(StringUtil.isNotEmpty(vo.getMontantIsAPaye()))
        item.setMontantIsAPaye(NumberUtil.toBigDecimal(vo.getMontantIsAPaye()));
        if(StringUtil.isNotEmpty(vo.getTotalAPaye()))
        item.setTotalAPaye(NumberUtil.toBigDecimal(vo.getTotalAPaye()));
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
    if(vo.getSocieteVo()!=null && this.societe)
        item.setSociete(societeConverter.toItem(vo.getSocieteVo())) ;
    if(vo.getTauxIsVo()!=null && this.tauxIs)
        item.setTauxIs(tauxIsConverter.toItem(vo.getTauxIsVo())) ;
    if(vo.getTauxIsConfigVo()!=null && this.tauxIsConfig)
        item.setTauxIsConfig(tauxIsConfigConverter.toItem(vo.getTauxIsConfigVo())) ;
    if(vo.getEtatDeclarationIsVo()!=null && this.etatDeclarationIs)
        item.setEtatDeclarationIs(etatDeclarationIsConverter.toItem(vo.getEtatDeclarationIsVo())) ;
    if(vo.getPaiementDeclarationIsVo()!=null && this.paiementDeclarationIs)
        item.setPaiementDeclarationIs(paiementDeclarationIsConverter.toItem(vo.getPaiementDeclarationIsVo())) ;


return item;
}
}

@Override
public DeclarationIsVo toVo(DeclarationIs item) {
if (item == null) {
return null;
} else {
DeclarationIsVo vo = new DeclarationIsVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getAnnee()!=null)
        vo.setAnnee(NumberUtil.toString(item.getAnnee()));

        if(item.getTotalHtProduit()!=null)
        vo.setTotalHtProduit(NumberUtil.toString(item.getTotalHtProduit()));

        if(item.getTotalHtCharge()!=null)
        vo.setTotalHtCharge(NumberUtil.toString(item.getTotalHtCharge()));

        if(item.getTotalHtDifference()!=null)
        vo.setTotalHtDifference(NumberUtil.toString(item.getTotalHtDifference()));

        if(item.getMontantIsCalcule()!=null)
        vo.setMontantIsCalcule(NumberUtil.toString(item.getMontantIsCalcule()));

        if(item.getMontantIsAPaye()!=null)
        vo.setMontantIsAPaye(NumberUtil.toString(item.getMontantIsAPaye()));

        if(item.getTotalAPaye()!=null)
        vo.setTotalAPaye(NumberUtil.toString(item.getTotalAPaye()));

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

    if(item.getSociete()!=null && this.societe) {
        vo.setSocieteVo(societeConverter.toVo(item.getSociete())) ;
    }
    if(item.getTauxIs()!=null && this.tauxIs) {
        vo.setTauxIsVo(tauxIsConverter.toVo(item.getTauxIs())) ;
    }
    if(item.getTauxIsConfig()!=null && this.tauxIsConfig) {
        vo.setTauxIsConfigVo(tauxIsConfigConverter.toVo(item.getTauxIsConfig())) ;
    }
    if(item.getEtatDeclarationIs()!=null && this.etatDeclarationIs) {
        vo.setEtatDeclarationIsVo(etatDeclarationIsConverter.toVo(item.getEtatDeclarationIs())) ;
    }
    if(item.getPaiementDeclarationIs()!=null && this.paiementDeclarationIs) {
                paiementDeclarationIsConverter.setDeclarationIs(false);
        vo.setPaiementDeclarationIsVo(paiementDeclarationIsConverter.toVo(item.getPaiementDeclarationIs())) ;
                paiementDeclarationIsConverter.setDeclarationIs(true);
    }

return vo;
}
}

public void init(Boolean value) {
    societe = value;
    tauxIs = value;
    tauxIsConfig = value;
    etatDeclarationIs = value;
    paiementDeclarationIs = value;
}


        public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
        }
        public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
        }
        public EtatDeclarationIsConverter getEtatDeclarationIsConverter(){
        return this.etatDeclarationIsConverter;
        }
        public void setEtatDeclarationIsConverter(EtatDeclarationIsConverter etatDeclarationIsConverter ){
        this.etatDeclarationIsConverter = etatDeclarationIsConverter;
        }
        public TauxIsConfigConverter getTauxIsConfigConverter(){
        return this.tauxIsConfigConverter;
        }
        public void setTauxIsConfigConverter(TauxIsConfigConverter tauxIsConfigConverter ){
        this.tauxIsConfigConverter = tauxIsConfigConverter;
        }
        public TauxIsConverter getTauxIsConverter(){
        return this.tauxIsConverter;
        }
        public void setTauxIsConverter(TauxIsConverter tauxIsConverter ){
        this.tauxIsConverter = tauxIsConverter;
        }
        public PaiementDeclarationIsConverter getPaiementDeclarationIsConverter(){
        return this.paiementDeclarationIsConverter;
        }
        public void setPaiementDeclarationIsConverter(PaiementDeclarationIsConverter paiementDeclarationIsConverter ){
        this.paiementDeclarationIsConverter = paiementDeclarationIsConverter;
        }

    public boolean  isSociete(){
    return this.societe;
    }
    public void  setSociete(boolean societe){
    this.societe = societe;
    }
    public boolean  isTauxIs(){
    return this.tauxIs;
    }
    public void  setTauxIs(boolean tauxIs){
    this.tauxIs = tauxIs;
    }
    public boolean  isTauxIsConfig(){
    return this.tauxIsConfig;
    }
    public void  setTauxIsConfig(boolean tauxIsConfig){
    this.tauxIsConfig = tauxIsConfig;
    }
    public boolean  isEtatDeclarationIs(){
    return this.etatDeclarationIs;
    }
    public void  setEtatDeclarationIs(boolean etatDeclarationIs){
    this.etatDeclarationIs = etatDeclarationIs;
    }
    public boolean  isPaiementDeclarationIs(){
    return this.paiementDeclarationIs;
    }
    public void  setPaiementDeclarationIs(boolean paiementDeclarationIs){
    this.paiementDeclarationIs = paiementDeclarationIs;
    }








































}
