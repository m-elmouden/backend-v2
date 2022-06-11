package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.DeclarationIr;
import com.ird.faa.ws.rest.provided.vo.DeclarationIrVo;

@Component
public class DeclarationIrConverter extends AbstractConverter<DeclarationIr, DeclarationIrVo> {

    @Autowired
    private SocieteConverter societeConverter;
    @Autowired
    private PaiementDeclarationIrConverter paiementDeclarationIrConverter;
    @Autowired
    private EtatDeclarationIrConverter etatDeclarationIrConverter;
    @Autowired
    private DeclarationIrEmployeConverter declarationIrEmployeConverter;
    @Autowired
    private PrelevementSocialEmployeConverter prelevementSocialEmployeConverter;
    @Autowired
    private ComptableConverter comptableConverter;
    @Autowired
    private DemandeConverter demandeConverter;
    private Boolean societe;
    private Boolean etatDeclarationIr;
    private Boolean paiementDeclarationIr;
    private Boolean declarationIrEmployes;
    private Boolean prelevementSocialEmployes;
    private Boolean comptableTraiteur;
    private Boolean comptableValidateur;
    private Boolean demande;

    public DeclarationIrConverter() {
        init(true);
    }

    @Override
    public DeclarationIr toItem(DeclarationIrVo vo) {
        if (vo == null) {
            return null;
        } else {
            DeclarationIr item = new DeclarationIr();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getRefrerence()))
                item.setRefrerence(vo.getRefrerence());
            if (StringUtil.isNotEmpty(vo.getAnnee()))
                item.setAnnee(vo.getAnnee());
            if (StringUtil.isNotEmpty(vo.getMois()))
                item.setMois(vo.getMois());
            if (StringUtil.isNotEmpty(vo.getMontantIrCalcule()))
                item.setMontantIrCalcule(NumberUtil.toBigDecimal(vo.getMontantIrCalcule()));
            if (StringUtil.isNotEmpty(vo.getMontantIrAPaye()))
                item.setMontantIrAPaye(NumberUtil.toBigDecimal(vo.getMontantIrAPaye()));
            if (StringUtil.isNotEmpty(vo.getTotalAPaye()))
                item.setTotalAPaye(NumberUtil.toBigDecimal(vo.getTotalAPaye()));
            if (StringUtil.isNotEmpty(vo.getTotalSalaireNet()))
                item.setTotalSalaireNet(NumberUtil.toBigDecimal(vo.getTotalSalaireNet()));
            if (StringUtil.isNotEmpty(vo.getTotalSalaireBrut()))
                item.setTotalSalaireBrut(NumberUtil.toBigDecimal(vo.getTotalSalaireBrut()));
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
            if (vo.getSocieteVo() != null && this.societe)
                item.setSociete(societeConverter.toItem(vo.getSocieteVo()));
            if (vo.getEtatDeclarationIrVo() != null && this.etatDeclarationIr)
                item.setEtatDeclarationIr(etatDeclarationIrConverter.toItem(vo.getEtatDeclarationIrVo()));
            if (vo.getPaiementDeclarationIrVo() != null && this.paiementDeclarationIr)
                item.setPaiementDeclarationIr(paiementDeclarationIrConverter.toItem(vo.getPaiementDeclarationIrVo()));
            if (vo.getComptableTraiteurVo() != null && this.comptableTraiteur)
                item.setComptableTraiteur(comptableConverter.toItem(vo.getComptableTraiteurVo()));
            if (vo.getComptableValidateurVo() != null && this.comptableValidateur)
                item.setComptableValidateur(comptableConverter.toItem(vo.getComptableValidateurVo()));
            if (vo.getDemandeVo() != null && this.demande)
                item.setDemande(demandeConverter.toItem(vo.getDemandeVo()));
            if (ListUtil.isNotEmpty(vo.getDeclarationIrEmployesVo()) && this.declarationIrEmployes)
                item.setDeclarationIrEmployes(declarationIrEmployeConverter.toItem(vo.getDeclarationIrEmployesVo()));
            if (ListUtil.isNotEmpty(vo.getPrelevementSocialEmployesVo()) && this.prelevementSocialEmployes)
                item.setPrelevementSocialEmployes(prelevementSocialEmployeConverter.toItem(vo.getPrelevementSocialEmployesVo()));

            return item;
        }
    }

    @Override
    public DeclarationIrVo toVo(DeclarationIr item) {
        if (item == null) {
            return null;
        } else {
            DeclarationIrVo vo = new DeclarationIrVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getRefrerence()))
                vo.setRefrerence(item.getRefrerence());

            if (item.getAnnee() != null)
                vo.setAnnee(item.getAnnee());

            if (item.getMois() != null)
                vo.setMois(item.getMois());

            if (item.getMontantIrCalcule() != null)
                vo.setMontantIrCalcule(NumberUtil.toString(item.getMontantIrCalcule()));

            if (item.getMontantIrAPaye() != null)
                vo.setMontantIrAPaye(NumberUtil.toString(item.getMontantIrAPaye()));

            if (item.getTotalAPaye() != null)
                vo.setTotalAPaye(NumberUtil.toString(item.getTotalAPaye()));

            if (item.getTotalSalaireNet() != null)
                vo.setTotalSalaireNet(NumberUtil.toString(item.getTotalSalaireNet()));

            if (item.getTotalSalaireBrut() != null)
                vo.setTotalSalaireBrut(NumberUtil.toString(item.getTotalSalaireBrut()));

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

            if (item.getComptableTraiteur() != null && this.comptableTraiteur) {
                vo.setComptableTraiteurVo(comptableConverter.toVo(item.getComptableTraiteur()));
            }
            if (item.getComptableValidateur() != null && this.comptableValidateur) {
                vo.setComptableValidateurVo(comptableConverter.toVo(item.getComptableValidateur()));
            }


            if (item.getSociete() != null && this.societe) {
                vo.setSocieteVo(societeConverter.toVo(item.getSociete()));
            }
            if (item.getDemande() != null && this.demande) {
                vo.setDemandeVo(demandeConverter.toVo(item.getDemande()));
            }
            if (item.getEtatDeclarationIr() != null && this.etatDeclarationIr) {
                vo.setEtatDeclarationIrVo(etatDeclarationIrConverter.toVo(item.getEtatDeclarationIr()));
            }
            if (item.getPaiementDeclarationIr() != null && this.paiementDeclarationIr) {
                paiementDeclarationIrConverter.setDeclarationIr(false);
                vo.setPaiementDeclarationIrVo(paiementDeclarationIrConverter.toVo(item.getPaiementDeclarationIr()));
                paiementDeclarationIrConverter.setDeclarationIr(true);
            }
            if (ListUtil.isNotEmpty(item.getDeclarationIrEmployes()) && this.declarationIrEmployes) {
                declarationIrEmployeConverter.init(true);
                declarationIrEmployeConverter.setDeclarationIr(false);
                vo.setDeclarationIrEmployesVo(declarationIrEmployeConverter.toVo(item.getDeclarationIrEmployes()));
                declarationIrEmployeConverter.setDeclarationIr(true);
            }
            if (ListUtil.isNotEmpty(item.getPrelevementSocialEmployes()) && this.prelevementSocialEmployes) {
                prelevementSocialEmployeConverter.init(true);
                prelevementSocialEmployeConverter.setDeclarationIr(false);
                vo.setPrelevementSocialEmployesVo(prelevementSocialEmployeConverter.toVo(item.getPrelevementSocialEmployes()));
                prelevementSocialEmployeConverter.setDeclarationIr(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        societe = value;
        etatDeclarationIr = value;
        paiementDeclarationIr = value;
        declarationIrEmployes = value;
        prelevementSocialEmployes = value;
        demande = value;
        comptableTraiteur = value;
        comptableValidateur = value;
    }


    public SocieteConverter getSocieteConverter() {
        return this.societeConverter;
    }

    public void setSocieteConverter(SocieteConverter societeConverter) {
        this.societeConverter = societeConverter;
    }

    public PaiementDeclarationIrConverter getPaiementDeclarationIrConverter() {
        return this.paiementDeclarationIrConverter;
    }

    public void setPaiementDeclarationIrConverter(PaiementDeclarationIrConverter paiementDeclarationIrConverter) {
        this.paiementDeclarationIrConverter = paiementDeclarationIrConverter;
    }

    public EtatDeclarationIrConverter getEtatDeclarationIrConverter() {
        return this.etatDeclarationIrConverter;
    }

    public void setEtatDeclarationIrConverter(EtatDeclarationIrConverter etatDeclarationIrConverter) {
        this.etatDeclarationIrConverter = etatDeclarationIrConverter;
    }

    public DeclarationIrEmployeConverter getDeclarationIrEmployeConverter() {
        return this.declarationIrEmployeConverter;
    }

    public void setDeclarationIrEmployeConverter(DeclarationIrEmployeConverter declarationIrEmployeConverter) {
        this.declarationIrEmployeConverter = declarationIrEmployeConverter;
    }

    public PrelevementSocialEmployeConverter getPrelevementSocialEmployeConverter() {
        return this.prelevementSocialEmployeConverter;
    }

    public void setPrelevementSocialEmployeConverter(PrelevementSocialEmployeConverter prelevementSocialEmployeConverter) {
        this.prelevementSocialEmployeConverter = prelevementSocialEmployeConverter;
    }

    public boolean isSociete() {
        return this.societe;
    }

    public void setSociete(boolean societe) {
        this.societe = societe;
    }

    public boolean isEtatDeclarationIr() {
        return this.etatDeclarationIr;
    }

    public void setEtatDeclarationIr(boolean etatDeclarationIr) {
        this.etatDeclarationIr = etatDeclarationIr;
    }

    public boolean isPaiementDeclarationIr() {
        return this.paiementDeclarationIr;
    }

    public void setPaiementDeclarationIr(boolean paiementDeclarationIr) {
        this.paiementDeclarationIr = paiementDeclarationIr;
    }


    public Boolean isDeclarationIrEmployes() {
        return this.declarationIrEmployes;
    }

    public void setDeclarationIrEmployes(Boolean declarationIrEmployes) {
        this.declarationIrEmployes = declarationIrEmployes;
    }


    public Boolean isPrelevementSocialEmployes() {
        return this.prelevementSocialEmployes;
    }

    public void setPrelevementSocialEmployes(Boolean prelevementSocialEmployes) {
        this.prelevementSocialEmployes = prelevementSocialEmployes;
    }


}
