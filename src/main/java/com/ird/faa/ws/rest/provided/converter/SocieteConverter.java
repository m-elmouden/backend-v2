package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Societe;
import com.ird.faa.ws.rest.provided.vo.SocieteVo;

@Component
public class SocieteConverter extends AbstractConverter<Societe,SocieteVo>{

        @Autowired
        private TypeSocieteConverter typeSocieteConverter ;
        @Autowired
        private DeclarationTvaConverter declarationTvaConverter ;
        @Autowired
        private AcompteConverter acompteConverter ;
        @Autowired
        private PresidentSocieteConverter presidentSocieteConverter ;
        @Autowired
        private DemandeConverter demandeConverter ;
        @Autowired
        private FactureConverter factureConverter ;
        @Autowired
        private DeclarationCnssConverter declarationCnssConverter ;
        @Autowired
        private DeclarationIsConverter declarationIsConverter ;
        @Autowired
        private DeclarationIrConverter declarationIrConverter ;
        @Autowired
        private EmployeConverter employeConverter ;
        @Autowired
        private ComptableConverter comptableConverter ;
    private Boolean comptable;
    private Boolean presidentSociete;
    private Boolean typeSociete;
        private Boolean demandes;
        private Boolean declarationIrs;
        private Boolean declarationIss;
        private Boolean declarationTvas;
        private Boolean declarationCnsss;
        private Boolean acomptes;
        private Boolean employes;
        private Boolean factures;

public  SocieteConverter(){
init(true);
}

@Override
public Societe toItem(SocieteVo vo) {
if (vo == null) {
return null;
} else {
Societe item = new Societe();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getIce()))
        item.setIce(vo.getIce());
        if(StringUtil.isNotEmpty(vo.getAdresse()))
        item.setAdresse(vo.getAdresse());
        if(StringUtil.isNotEmpty(vo.getFax()))
        item.setFax(vo.getFax());
        if(StringUtil.isNotEmpty(vo.getTelephone()))
        item.setTelephone(NumberUtil.toBigDecimal(vo.getTelephone()));
        if(StringUtil.isNotEmpty(vo.getRaisonSociale()))
        item.setRaisonSociale(vo.getRaisonSociale());
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
        if(StringUtil.isNotEmpty(vo.getAnneeExploitation()))
        item.setAnneeExploitation(NumberUtil.toBigDecimal(vo.getAnneeExploitation()));
        if(StringUtil.isNotEmpty(vo.getCapitalSocial()))
        item.setCapitalSocial(NumberUtil.toLong(vo.getCapitalSocial()));
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getAge()))
        item.setAge(NumberUtil.toBigDecimal(vo.getAge()));
            item.setCredentialsNonExpired(vo.getCredentialsNonExpired());
            item.setEnabled(vo.getEnabled());
            item.setAccountNonExpired(vo.getAccountNonExpired());
            item.setAccountNonLocked(vo.getAccountNonLocked());
            item.setPasswordChanged(vo.getPasswordChanged());
        if(StringUtil.isNotEmpty(vo.getCreatedAt()))
        item.setCreatedAt(DateUtil.parse(vo.getCreatedAt()));
        if(StringUtil.isNotEmpty(vo.getUpdatedAt()))
        item.setUpdatedAt(DateUtil.parse(vo.getUpdatedAt()));
        if(StringUtil.isNotEmpty(vo.getUsername()))
        item.setUsername(vo.getUsername());
        if(StringUtil.isNotEmpty(vo.getPassword()))
        item.setPassword(vo.getPassword());
        if(StringUtil.isNotEmpty(vo.getEquivalenceAvecPanelErc()))
        item.setEquivalenceAvecPanelErc(vo.getEquivalenceAvecPanelErc());
        if(StringUtil.isNotEmpty(vo.getBaseHorizon()))
        item.setBaseHorizon(vo.getBaseHorizon());
        if(StringUtil.isNotEmpty(vo.getRole()))
        item.setRole(vo.getRole());
    if(vo.getComptableVo()!=null && this.comptable)
        item.setComptable(comptableConverter.toItem(vo.getComptableVo())) ;
    if(vo.getPresidentSocieteVo()!=null && this.presidentSociete)
        item.setPresidentSociete(presidentSocieteConverter.toItem(vo.getPresidentSocieteVo())) ;
    if(vo.getTypeSocieteVo()!=null && this.typeSociete)
        item.setTypeSociete(typeSocieteConverter.toItem(vo.getTypeSocieteVo())) ;

    if(ListUtil.isNotEmpty(vo.getDemandesVo()) && this.demandes)
        item.setDemandes(demandeConverter.toItem(vo.getDemandesVo()));
    if(ListUtil.isNotEmpty(vo.getDeclarationIrsVo()) && this.declarationIrs)
        item.setDeclarationIrs(declarationIrConverter.toItem(vo.getDeclarationIrsVo()));
    if(ListUtil.isNotEmpty(vo.getDeclarationIssVo()) && this.declarationIss)
        item.setDeclarationIss(declarationIsConverter.toItem(vo.getDeclarationIssVo()));
    if(ListUtil.isNotEmpty(vo.getDeclarationTvasVo()) && this.declarationTvas)
        item.setDeclarationTvas(declarationTvaConverter.toItem(vo.getDeclarationTvasVo()));
    if(ListUtil.isNotEmpty(vo.getDeclarationCnsssVo()) && this.declarationCnsss)
        item.setDeclarationCnsss(declarationCnssConverter.toItem(vo.getDeclarationCnsssVo()));
    if(ListUtil.isNotEmpty(vo.getAcomptesVo()) && this.acomptes)
        item.setAcomptes(acompteConverter.toItem(vo.getAcomptesVo()));
    if(ListUtil.isNotEmpty(vo.getEmployesVo()) && this.employes)
        item.setEmployes(employeConverter.toItem(vo.getEmployesVo()));
    if(ListUtil.isNotEmpty(vo.getFacturesVo()) && this.factures)
        item.setFactures(factureConverter.toItem(vo.getFacturesVo()));

return item;
}
}

@Override
public SocieteVo toVo(Societe item) {
if (item == null) {
return null;
} else {
SocieteVo vo = new SocieteVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getIce()))
        vo.setIce(item.getIce());

        if(StringUtil.isNotEmpty(item.getAdresse()))
        vo.setAdresse(item.getAdresse());

        if(StringUtil.isNotEmpty(item.getFax()))
        vo.setFax(item.getFax());

        if(item.getTelephone()!=null)
        vo.setTelephone(NumberUtil.toString(item.getTelephone()));

        if(StringUtil.isNotEmpty(item.getRaisonSociale()))
        vo.setRaisonSociale(item.getRaisonSociale());

        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
        if(item.getAnneeExploitation()!=null)
        vo.setAnneeExploitation(NumberUtil.toString(item.getAnneeExploitation()));

        if(item.getCapitalSocial()!=null)
        vo.setCapitalSocial(NumberUtil.toString(item.getCapitalSocial()));

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(item.getAge()!=null)
        vo.setAge(NumberUtil.toString(item.getAge()));

        vo.setCredentialsNonExpired(item.getCredentialsNonExpired());
        vo.setEnabled(item.getEnabled());
        vo.setAccountNonExpired(item.getAccountNonExpired());
        vo.setAccountNonLocked(item.getAccountNonLocked());
        vo.setPasswordChanged(item.getPasswordChanged());
        if(item.getCreatedAt()!=null)
        vo.setCreatedAt(DateUtil.formateDate(item.getCreatedAt()));
        if(item.getUpdatedAt()!=null)
        vo.setUpdatedAt(DateUtil.formateDate(item.getUpdatedAt()));
        if(StringUtil.isNotEmpty(item.getUsername()))
        vo.setUsername(item.getUsername());

        if(StringUtil.isNotEmpty(item.getPassword()))
        vo.setPassword(item.getPassword());

        if(StringUtil.isNotEmpty(item.getEquivalenceAvecPanelErc()))
        vo.setEquivalenceAvecPanelErc(item.getEquivalenceAvecPanelErc());

        if(StringUtil.isNotEmpty(item.getBaseHorizon()))
        vo.setBaseHorizon(item.getBaseHorizon());

        if(StringUtil.isNotEmpty(item.getRole()))
        vo.setRole(item.getRole());

    if(item.getComptable()!=null && this.comptable) {
        vo.setComptableVo(comptableConverter.toVo(item.getComptable())) ;
    }
    if(item.getPresidentSociete()!=null && this.presidentSociete) {
                presidentSocieteConverter.setSociete(false);
        vo.setPresidentSocieteVo(presidentSocieteConverter.toVo(item.getPresidentSociete())) ;
                presidentSocieteConverter.setSociete(true);
    }
    if(item.getTypeSociete()!=null && this.typeSociete) {
        vo.setTypeSocieteVo(typeSocieteConverter.toVo(item.getTypeSociete())) ;
    }
        if(ListUtil.isNotEmpty(item.getDemandes()) && this.demandes){
        demandeConverter.init(true);
        demandeConverter.setSociete(false);
        vo.setDemandesVo(demandeConverter.toVo(item.getDemandes()));
        demandeConverter.setSociete(true);
        }
        if(ListUtil.isNotEmpty(item.getDeclarationIrs()) && this.declarationIrs){
        declarationIrConverter.init(true);
        declarationIrConverter.setSociete(false);
        vo.setDeclarationIrsVo(declarationIrConverter.toVo(item.getDeclarationIrs()));
        declarationIrConverter.setSociete(true);
        }
        if(ListUtil.isNotEmpty(item.getDeclarationIss()) && this.declarationIss){
        declarationIsConverter.init(true);
        declarationIsConverter.setSociete(false);
        vo.setDeclarationIssVo(declarationIsConverter.toVo(item.getDeclarationIss()));
        declarationIsConverter.setSociete(true);
        }
        if(ListUtil.isNotEmpty(item.getDeclarationTvas()) && this.declarationTvas){
        declarationTvaConverter.init(true);
        declarationTvaConverter.setSociete(false);
        vo.setDeclarationTvasVo(declarationTvaConverter.toVo(item.getDeclarationTvas()));
        declarationTvaConverter.setSociete(true);
        }
        if(ListUtil.isNotEmpty(item.getDeclarationCnsss()) && this.declarationCnsss){
        declarationCnssConverter.init(true);
        declarationCnssConverter.setSociete(false);
        vo.setDeclarationCnsssVo(declarationCnssConverter.toVo(item.getDeclarationCnsss()));
        declarationCnssConverter.setSociete(true);
        }
        if(ListUtil.isNotEmpty(item.getAcomptes()) && this.acomptes){
        acompteConverter.init(true);
        acompteConverter.setSociete(false);
        vo.setAcomptesVo(acompteConverter.toVo(item.getAcomptes()));
        acompteConverter.setSociete(true);
        }
        if(ListUtil.isNotEmpty(item.getEmployes()) && this.employes){
        employeConverter.init(true);
        employeConverter.setSociete(false);
        vo.setEmployesVo(employeConverter.toVo(item.getEmployes()));
        employeConverter.setSociete(true);
        }
        if(ListUtil.isNotEmpty(item.getFactures()) && this.factures){
        factureConverter.init(true);
        factureConverter.setSociete(false);
        vo.setFacturesVo(factureConverter.toVo(item.getFactures()));
        factureConverter.setSociete(true);
        }

return vo;
}
}

public void init(Boolean value) {
    comptable = value;
    presidentSociete = value;
    typeSociete = value;
        demandes = value;
        declarationIrs = value;
        declarationIss = value;
        declarationTvas = value;
        declarationCnsss = value;
        acomptes = value;
        employes = value;
        factures = value;
}


        public TypeSocieteConverter getTypeSocieteConverter(){
        return this.typeSocieteConverter;
        }
        public void setTypeSocieteConverter(TypeSocieteConverter typeSocieteConverter ){
        this.typeSocieteConverter = typeSocieteConverter;
        }
        public DeclarationTvaConverter getDeclarationTvaConverter(){
        return this.declarationTvaConverter;
        }
        public void setDeclarationTvaConverter(DeclarationTvaConverter declarationTvaConverter ){
        this.declarationTvaConverter = declarationTvaConverter;
        }
        public AcompteConverter getAcompteConverter(){
        return this.acompteConverter;
        }
        public void setAcompteConverter(AcompteConverter acompteConverter ){
        this.acompteConverter = acompteConverter;
        }
        public PresidentSocieteConverter getPresidentSocieteConverter(){
        return this.presidentSocieteConverter;
        }
        public void setPresidentSocieteConverter(PresidentSocieteConverter presidentSocieteConverter ){
        this.presidentSocieteConverter = presidentSocieteConverter;
        }
        public DemandeConverter getDemandeConverter(){
        return this.demandeConverter;
        }
        public void setDemandeConverter(DemandeConverter demandeConverter ){
        this.demandeConverter = demandeConverter;
        }
        public FactureConverter getFactureConverter(){
        return this.factureConverter;
        }
        public void setFactureConverter(FactureConverter factureConverter ){
        this.factureConverter = factureConverter;
        }
        public DeclarationCnssConverter getDeclarationCnssConverter(){
        return this.declarationCnssConverter;
        }
        public void setDeclarationCnssConverter(DeclarationCnssConverter declarationCnssConverter ){
        this.declarationCnssConverter = declarationCnssConverter;
        }
        public DeclarationIsConverter getDeclarationIsConverter(){
        return this.declarationIsConverter;
        }
        public void setDeclarationIsConverter(DeclarationIsConverter declarationIsConverter ){
        this.declarationIsConverter = declarationIsConverter;
        }
        public DeclarationIrConverter getDeclarationIrConverter(){
        return this.declarationIrConverter;
        }
        public void setDeclarationIrConverter(DeclarationIrConverter declarationIrConverter ){
        this.declarationIrConverter = declarationIrConverter;
        }
        public EmployeConverter getEmployeConverter(){
        return this.employeConverter;
        }
        public void setEmployeConverter(EmployeConverter employeConverter ){
        this.employeConverter = employeConverter;
        }
        public ComptableConverter getComptableConverter(){
        return this.comptableConverter;
        }
        public void setComptableConverter(ComptableConverter comptableConverter ){
        this.comptableConverter = comptableConverter;
        }

    public boolean  isComptable(){
    return this.comptable;
    }
    public void  setComptable(boolean comptable){
    this.comptable = comptable;
    }
    public boolean  isPresidentSociete(){
    return this.presidentSociete;
    }
    public void  setPresidentSociete(boolean presidentSociete){
    this.presidentSociete = presidentSociete;
    }
    public boolean  isTypeSociete(){
    return this.typeSociete;
    }
    public void  setTypeSociete(boolean typeSociete){
    this.typeSociete = typeSociete;
    }



























        public Boolean  isDemandes(){
        return this.demandes ;
        }
        public void  setDemandes(Boolean demandes ){
        this.demandes  = demandes ;
        }



        public Boolean  isDeclarationIrs(){
        return this.declarationIrs ;
        }
        public void  setDeclarationIrs(Boolean declarationIrs ){
        this.declarationIrs  = declarationIrs ;
        }



        public Boolean  isDeclarationIss(){
        return this.declarationIss ;
        }
        public void  setDeclarationIss(Boolean declarationIss ){
        this.declarationIss  = declarationIss ;
        }



        public Boolean  isDeclarationTvas(){
        return this.declarationTvas ;
        }
        public void  setDeclarationTvas(Boolean declarationTvas ){
        this.declarationTvas  = declarationTvas ;
        }



        public Boolean  isDeclarationCnsss(){
        return this.declarationCnsss ;
        }
        public void  setDeclarationCnsss(Boolean declarationCnsss ){
        this.declarationCnsss  = declarationCnsss ;
        }



        public Boolean  isAcomptes(){
        return this.acomptes ;
        }
        public void  setAcomptes(Boolean acomptes ){
        this.acomptes  = acomptes ;
        }



        public Boolean  isEmployes(){
        return this.employes ;
        }
        public void  setEmployes(Boolean employes ){
        this.employes  = employes ;
        }





        public Boolean  isFactures(){
        return this.factures ;
        }
        public void  setFactures(Boolean factures ){
        this.factures  = factures ;
        }


























}
