package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.DeclarationTva;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.DeclarationTvaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeclarationTvaConverter extends AbstractConverter<DeclarationTva, DeclarationTvaVo> {

    @Autowired
    private SocieteConverter societeConverter;
    @Autowired
    private PaiementDeclarationTvaConverter paiementDeclarationTvaConverter;
    @Autowired
    private EtatDeclarationTvaConverter etatDeclarationTvaConverter;
    @Autowired
    private TypeDeclarationTvaConverter typeDeclarationTvaConverter;
    private Boolean societe;
    private Boolean typeDeclarationTva;
    private Boolean etatDeclarationTva;
    private Boolean paiementDeclarationTva;

    public DeclarationTvaConverter() {
        init(true);
    }

    @Override
    public DeclarationTva toItem(DeclarationTvaVo vo) {
        if (vo == null) {
            return null;
        } else {
            DeclarationTva item = new DeclarationTva();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getTvacollecter()))
                item.setTvacollecter(NumberUtil.toBigDecimal(vo.getTvacollecter()));
            if (StringUtil.isNotEmpty(vo.getTvaperdue()))
                item.setTvaperdue(NumberUtil.toBigDecimal(vo.getTvaperdue()));
            if (StringUtil.isNotEmpty(vo.getDifferenceTva()))
                item.setDifferenceTva(NumberUtil.toBigDecimal(vo.getDifferenceTva()));
            if (StringUtil.isNotEmpty(vo.getMontantTvaCalcule()))
                item.setMontantTvaCalcule(NumberUtil.toBigDecimal(vo.getMontantTvaCalcule()));
            if (StringUtil.isNotEmpty(vo.getMontantTvaAPaye()))
                item.setMontantTvaAPaye(NumberUtil.toBigDecimal(vo.getMontantTvaAPaye()));
            if (StringUtil.isNotEmpty(vo.getAnnee()))
                item.setAnnee(NumberUtil.toBigDecimal(vo.getAnnee()));
            if (StringUtil.isNotEmpty(vo.getMois()))
                item.setMois(NumberUtil.toBigDecimal(vo.getMois()));
            if (StringUtil.isNotEmpty(vo.getTrimestre()))
                item.setTrimestre(NumberUtil.toBigDecimal(vo.getTrimestre()));
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
            if (vo.getTypeDeclarationTvaVo() != null && this.typeDeclarationTva)
                item.setTypeDeclarationTva(typeDeclarationTvaConverter.toItem(vo.getTypeDeclarationTvaVo()));
            if (vo.getEtatDeclarationTvaVo() != null && this.etatDeclarationTva)
                item.setEtatDeclarationTva(etatDeclarationTvaConverter.toItem(vo.getEtatDeclarationTvaVo()));
            if (vo.getPaiementDeclarationTvaVo() != null && this.paiementDeclarationTva)
                item.setPaiementDeclarationTva(paiementDeclarationTvaConverter.toItem(vo.getPaiementDeclarationTvaVo()));


            return item;
        }
    }

    @Override
    public DeclarationTvaVo toVo(DeclarationTva item) {
        if (item == null) {
            return null;
        } else {
            DeclarationTvaVo vo = new DeclarationTvaVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (item.getTvacollecter() != null)
                vo.setTvacollecter(NumberUtil.toString(item.getTvacollecter()));

            if (item.getTvaperdue() != null)
                vo.setTvaperdue(NumberUtil.toString(item.getTvaperdue()));

            if (item.getDifferenceTva() != null)
                vo.setDifferenceTva(NumberUtil.toString(item.getDifferenceTva()));

            if (item.getMontantTvaCalcule() != null)
                vo.setMontantTvaCalcule(NumberUtil.toString(item.getMontantTvaCalcule()));

            if (item.getMontantTvaAPaye() != null)
                vo.setMontantTvaAPaye(NumberUtil.toString(item.getMontantTvaAPaye()));

            if (item.getAnnee() != null)
                vo.setAnnee(NumberUtil.toString(item.getAnnee()));

            if (item.getMois() != null)
                vo.setMois(NumberUtil.toString(item.getMois()));

            if (item.getTrimestre() != null)
                vo.setTrimestre(NumberUtil.toString(item.getTrimestre()));

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

            if (item.getSociete() != null && this.societe) {
                vo.setSocieteVo(societeConverter.toVo(item.getSociete()));
            }
            if (item.getTypeDeclarationTva() != null && this.typeDeclarationTva) {
                vo.setTypeDeclarationTvaVo(typeDeclarationTvaConverter.toVo(item.getTypeDeclarationTva()));
            }
            if (item.getEtatDeclarationTva() != null && this.etatDeclarationTva) {
                vo.setEtatDeclarationTvaVo(etatDeclarationTvaConverter.toVo(item.getEtatDeclarationTva()));
            }
            if (item.getPaiementDeclarationTva() != null && this.paiementDeclarationTva) {
                paiementDeclarationTvaConverter.setDeclarationTva(false);
                vo.setPaiementDeclarationTvaVo(paiementDeclarationTvaConverter.toVo(item.getPaiementDeclarationTva()));
                paiementDeclarationTvaConverter.setDeclarationTva(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        societe = value;
        typeDeclarationTva = value;
        etatDeclarationTva = value;
        paiementDeclarationTva = value;
    }


    public SocieteConverter getSocieteConverter() {
        return this.societeConverter;
    }

    public void setSocieteConverter(SocieteConverter societeConverter) {
        this.societeConverter = societeConverter;
    }

    public PaiementDeclarationTvaConverter getPaiementDeclarationTvaConverter() {
        return this.paiementDeclarationTvaConverter;
    }

    public void setPaiementDeclarationTvaConverter(PaiementDeclarationTvaConverter paiementDeclarationTvaConverter) {
        this.paiementDeclarationTvaConverter = paiementDeclarationTvaConverter;
    }

    public EtatDeclarationTvaConverter getEtatDeclarationTvaConverter() {
        return this.etatDeclarationTvaConverter;
    }

    public void setEtatDeclarationTvaConverter(EtatDeclarationTvaConverter etatDeclarationTvaConverter) {
        this.etatDeclarationTvaConverter = etatDeclarationTvaConverter;
    }

    public TypeDeclarationTvaConverter getTypeDeclarationTvaConverter() {
        return this.typeDeclarationTvaConverter;
    }

    public void setTypeDeclarationTvaConverter(TypeDeclarationTvaConverter typeDeclarationTvaConverter) {
        this.typeDeclarationTvaConverter = typeDeclarationTvaConverter;
    }

    public boolean isSociete() {
        return this.societe;
    }

    public void setSociete(boolean societe) {
        this.societe = societe;
    }

    public boolean isTypeDeclarationTva() {
        return this.typeDeclarationTva;
    }

    public void setTypeDeclarationTva(boolean typeDeclarationTva) {
        this.typeDeclarationTva = typeDeclarationTva;
    }

    public boolean isEtatDeclarationTva() {
        return this.etatDeclarationTva;
    }

    public void setEtatDeclarationTva(boolean etatDeclarationTva) {
        this.etatDeclarationTva = etatDeclarationTva;
    }

    public boolean isPaiementDeclarationTva() {
        return this.paiementDeclarationTva;
    }

    public void setPaiementDeclarationTva(boolean paiementDeclarationTva) {
        this.paiementDeclarationTva = paiementDeclarationTva;
    }


}
