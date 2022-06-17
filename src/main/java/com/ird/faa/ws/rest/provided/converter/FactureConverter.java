package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.Facture;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.FactureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactureConverter extends AbstractConverter<Facture, FactureVo> {

    @Autowired
    private FacturePieceJointeConverter facturePieceJointeConverter;
    @Autowired
    private SocieteConverter societeConverter;
    @Autowired
    private DeclarationTvaConverter declarationTvaConverter;
    @Autowired
    private CpcFactureConverter cpcFactureConverter;
    @Autowired
    private DemandeConverter demandeConverter;
    @Autowired
    private TypeOperationFactureConverter typeOperationFactureConverter;
    @Autowired
    private ClasseComptableConverter classeComptableConverter;
    @Autowired
    private CompteComptableConverter compteComptableConverter;
    @Autowired
    private EtatFactureConverter etatFactureConverter;
    @Autowired
    private DeclarationIsConverter declarationIsConverter;
    @Autowired
    private EtatPaiementConverter etatPaiementConverter;
    @Autowired
    private TvaConverter tvaConverter;
    private Boolean tva;
    private Boolean typeOperationFacture;
    private Boolean etatFacture;
    private Boolean etatPaiement;
    private Boolean societe;
    private Boolean compteComptable;
    private Boolean declarationIs;
    private Boolean declarationTva;
    private Boolean demande;
    private Boolean classeComptable;
    private Boolean cpcFacture;

    public FactureConverter() {
        init(true);
    }

    @Override
    public Facture toItem(FactureVo vo) {
        if (vo == null) {
            return null;
        } else {
            Facture item = new Facture();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getLibelle()))
                item.setLibelle(vo.getLibelle());
            if (StringUtil.isNotEmpty(vo.getMontantHorsTaxe()))
                item.setMontantHorsTaxe(NumberUtil.toBigDecimal(vo.getMontantHorsTaxe()));
            if (StringUtil.isNotEmpty(vo.getDateOperation()))
                item.setDateOperation(DateUtil.parse(vo.getDateOperation()));
            if (StringUtil.isNotEmpty(vo.getAnnee()))
                item.setAnnee(NumberUtil.toBigDecimal(vo.getAnnee()));
            if (StringUtil.isNotEmpty(vo.getMois()))
                item.setMois(NumberUtil.toBigDecimal(vo.getMois()));
            if (StringUtil.isNotEmpty(vo.getTrimestre()))
                item.setTrimestre(NumberUtil.toBigDecimal(vo.getTrimestre()));
            if (StringUtil.isNotEmpty(vo.getMontantTtc()))
                item.setMontantTtc(NumberUtil.toBigDecimal(vo.getMontantTtc()));
            if (StringUtil.isNotEmpty(vo.getMontantTva()))
                item.setMontantTva(NumberUtil.toBigDecimal(vo.getMontantTva()));
            if (StringUtil.isNotEmpty(vo.getCredit()))
                item.setCredit(vo.getCredit());
            if (StringUtil.isNotEmpty(vo.getDebit()))
                item.setDebit(vo.getDebit());
            if (vo.getFacturePieceJointeVo() != null)
                item.setFacturePieceJointe(facturePieceJointeConverter.toItem(vo.getFacturePieceJointeVo()));
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
            if (vo.getTvaVo() != null && this.tva)
                item.setTva(tvaConverter.toItem(vo.getTvaVo()));
            if (vo.getTypeOperationFactureVo() != null && this.typeOperationFacture)
                item.setTypeOperationFacture(typeOperationFactureConverter.toItem(vo.getTypeOperationFactureVo()));
            if (vo.getEtatFactureVo() != null && this.etatFacture)
                item.setEtatFacture(etatFactureConverter.toItem(vo.getEtatFactureVo()));
            if (vo.getEtatPaiementVo() != null && this.etatPaiement)
                item.setEtatPaiement(etatPaiementConverter.toItem(vo.getEtatPaiementVo()));
            if (vo.getSocieteVo() != null && this.societe)
                item.setSociete(societeConverter.toItem(vo.getSocieteVo()));
            if (vo.getCompteComptableVo() != null && this.compteComptable)
                item.setCompteComptable(compteComptableConverter.toItem(vo.getCompteComptableVo()));
            if (vo.getDeclarationIsVo() != null && this.declarationIs)
                item.setDeclarationIs(declarationIsConverter.toItem(vo.getDeclarationIsVo()));
            if (vo.getDeclarationTvaVo() != null && this.declarationTva)
                item.setDeclarationTva(declarationTvaConverter.toItem(vo.getDeclarationTvaVo()));
            if (vo.getDemandeVo() != null && this.demande)
                item.setDemande(demandeConverter.toItem(vo.getDemandeVo()));
            if (vo.getClasseComptableVo() != null && this.classeComptable)
                item.setClasseComptable(classeComptableConverter.toItem(vo.getClasseComptableVo()));
            if (vo.getCpcFactureVo() != null && this.cpcFacture)
                item.setCpcFacture(cpcFactureConverter.toItem(vo.getCpcFactureVo()));


            return item;
        }
    }

    @Override
    public FactureVo toVo(Facture item) {
        if (item == null) {
            return null;
        } else {
            FactureVo vo = new FactureVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (StringUtil.isNotEmpty(item.getLibelle()))
                vo.setLibelle(item.getLibelle());

            if (item.getMontantHorsTaxe() != null)
                vo.setMontantHorsTaxe(NumberUtil.toString(item.getMontantHorsTaxe()));

            if (item.getDateOperation() != null)
                vo.setDateOperation(DateUtil.formateDate(item.getDateOperation()));
            if (item.getAnnee() != null)
                vo.setAnnee(NumberUtil.toString(item.getAnnee()));

            if (item.getMois() != null)
                vo.setMois(NumberUtil.toString(item.getMois()));

            if (item.getTrimestre() != null)
                vo.setTrimestre(NumberUtil.toString(item.getTrimestre()));

            if (item.getMontantTtc() != null)
                vo.setMontantTtc(NumberUtil.toString(item.getMontantTtc()));

            if (item.getMontantTva() != null)
                vo.setMontantTva(NumberUtil.toString(item.getMontantTva()));

            if (StringUtil.isNotEmpty(item.getCredit()))
                vo.setCredit(item.getCredit());

            if (StringUtil.isNotEmpty(item.getDebit()))
                vo.setDebit(item.getDebit());

            if (item.getFacturePieceJointe() != null)
                vo.setFacturePieceJointeVo(facturePieceJointeConverter.toVo(item.getFacturePieceJointe()));

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

            if (item.getTva() != null && this.tva) {
                vo.setTvaVo(tvaConverter.toVo(item.getTva()));
            }
            if (item.getTypeOperationFacture() != null && this.typeOperationFacture) {
                vo.setTypeOperationFactureVo(typeOperationFactureConverter.toVo(item.getTypeOperationFacture()));
            }
            if (item.getEtatFacture() != null && this.etatFacture) {
                vo.setEtatFactureVo(etatFactureConverter.toVo(item.getEtatFacture()));
            }
            if (item.getEtatPaiement() != null && this.etatPaiement) {
                vo.setEtatPaiementVo(etatPaiementConverter.toVo(item.getEtatPaiement()));
            }
            if (item.getSociete() != null && this.societe) {
                vo.setSocieteVo(societeConverter.toVo(item.getSociete()));
            }
            if (item.getCompteComptable() != null && this.compteComptable) {
                vo.setCompteComptableVo(compteComptableConverter.toVo(item.getCompteComptable()));
            }
            if (item.getDeclarationIs() != null && this.declarationIs) {
                vo.setDeclarationIsVo(declarationIsConverter.toVo(item.getDeclarationIs()));
            }
            if (item.getDeclarationTva() != null && this.declarationTva) {
                vo.setDeclarationTvaVo(declarationTvaConverter.toVo(item.getDeclarationTva()));
            }
            if (item.getDemande() != null && this.demande) {
                vo.setDemandeVo(demandeConverter.toVo(item.getDemande()));
            }
            if (item.getClasseComptable() != null && this.classeComptable) {
                vo.setClasseComptableVo(classeComptableConverter.toVo(item.getClasseComptable()));
            }
            if (item.getCpcFacture() != null && this.cpcFacture) {
                cpcFactureConverter.setFacture(false);
                vo.setCpcFactureVo(cpcFactureConverter.toVo(item.getCpcFacture()));
                cpcFactureConverter.setFacture(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        tva = value;
        typeOperationFacture = value;
        etatFacture = value;
        etatPaiement = value;
        societe = value;
        compteComptable = value;
        declarationIs = value;
        declarationTva = value;
        demande = value;
        classeComptable = value;
        cpcFacture = value;
    }


    public SocieteConverter getSocieteConverter() {
        return this.societeConverter;
    }

    public void setSocieteConverter(SocieteConverter societeConverter) {
        this.societeConverter = societeConverter;
    }

    public DeclarationTvaConverter getDeclarationTvaConverter() {
        return this.declarationTvaConverter;
    }

    public void setDeclarationTvaConverter(DeclarationTvaConverter declarationTvaConverter) {
        this.declarationTvaConverter = declarationTvaConverter;
    }

    public CpcFactureConverter getCpcFactureConverter() {
        return this.cpcFactureConverter;
    }

    public void setCpcFactureConverter(CpcFactureConverter cpcFactureConverter) {
        this.cpcFactureConverter = cpcFactureConverter;
    }

    public DemandeConverter getDemandeConverter() {
        return this.demandeConverter;
    }

    public void setDemandeConverter(DemandeConverter demandeConverter) {
        this.demandeConverter = demandeConverter;
    }

    public TypeOperationFactureConverter getTypeOperationFactureConverter() {
        return this.typeOperationFactureConverter;
    }

    public void setTypeOperationFactureConverter(TypeOperationFactureConverter typeOperationFactureConverter) {
        this.typeOperationFactureConverter = typeOperationFactureConverter;
    }

    public ClasseComptableConverter getClasseComptableConverter() {
        return this.classeComptableConverter;
    }

    public void setClasseComptableConverter(ClasseComptableConverter classeComptableConverter) {
        this.classeComptableConverter = classeComptableConverter;
    }

    public CompteComptableConverter getCompteComptableConverter() {
        return this.compteComptableConverter;
    }

    public void setCompteComptableConverter(CompteComptableConverter compteComptableConverter) {
        this.compteComptableConverter = compteComptableConverter;
    }

    public EtatFactureConverter getEtatFactureConverter() {
        return this.etatFactureConverter;
    }

    public void setEtatFactureConverter(EtatFactureConverter etatFactureConverter) {
        this.etatFactureConverter = etatFactureConverter;
    }

    public DeclarationIsConverter getDeclarationIsConverter() {
        return this.declarationIsConverter;
    }

    public void setDeclarationIsConverter(DeclarationIsConverter declarationIsConverter) {
        this.declarationIsConverter = declarationIsConverter;
    }

    public EtatPaiementConverter getEtatPaiementConverter() {
        return this.etatPaiementConverter;
    }

    public void setEtatPaiementConverter(EtatPaiementConverter etatPaiementConverter) {
        this.etatPaiementConverter = etatPaiementConverter;
    }

    public TvaConverter getTvaConverter() {
        return this.tvaConverter;
    }

    public void setTvaConverter(TvaConverter tvaConverter) {
        this.tvaConverter = tvaConverter;
    }

    public boolean isTva() {
        return this.tva;
    }

    public void setTva(boolean tva) {
        this.tva = tva;
    }

    public boolean isTypeOperationFacture() {
        return this.typeOperationFacture;
    }

    public void setTypeOperationFacture(boolean typeOperationFacture) {
        this.typeOperationFacture = typeOperationFacture;
    }

    public boolean isEtatFacture() {
        return this.etatFacture;
    }

    public void setEtatFacture(boolean etatFacture) {
        this.etatFacture = etatFacture;
    }

    public boolean isEtatPaiement() {
        return this.etatPaiement;
    }

    public void setEtatPaiement(boolean etatPaiement) {
        this.etatPaiement = etatPaiement;
    }

    public boolean isSociete() {
        return this.societe;
    }

    public void setSociete(boolean societe) {
        this.societe = societe;
    }

    public boolean isCompteComptable() {
        return this.compteComptable;
    }

    public void setCompteComptable(boolean compteComptable) {
        this.compteComptable = compteComptable;
    }

    public boolean isDeclarationIs() {
        return this.declarationIs;
    }

    public void setDeclarationIs(boolean declarationIs) {
        this.declarationIs = declarationIs;
    }

    public boolean isDeclarationTva() {
        return this.declarationTva;
    }

    public void setDeclarationTva(boolean declarationTva) {
        this.declarationTva = declarationTva;
    }

    public boolean isDemande() {
        return this.demande;
    }

    public void setDemande(boolean demande) {
        this.demande = demande;
    }

    public boolean isClasseComptable() {
        return this.classeComptable;
    }

    public void setClasseComptable(boolean classeComptable) {
        this.classeComptable = classeComptable;
    }

    public boolean isCpcFacture() {
        return this.cpcFacture;
    }

    public void setCpcFacture(boolean cpcFacture) {
        this.cpcFacture = cpcFacture;
    }


}
