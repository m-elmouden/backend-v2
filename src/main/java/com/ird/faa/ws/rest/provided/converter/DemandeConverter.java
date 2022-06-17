package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.Demande;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.DemandeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemandeConverter extends AbstractConverter<Demande, DemandeVo> {

    @Autowired
    private SocieteConverter societeConverter;
    @Autowired
    private EtatDemandeConverter etatDemandeConverter;
    @Autowired
    private DemandePieceJointeConverter demandePieceJointeConverter;
    @Autowired
    private FactureConverter factureConverter;
    @Autowired
    private CommentaireConverter commentaireConverter;
    @Autowired
    private ComptableConverter comptableConverter;
    @Autowired
    private DeclarationIrConverter declarationIrConverter;

    private Boolean societe;
    private Boolean comptable;
    private Boolean etatDemande;
    private Boolean factures;
    private Boolean demandePieceJointes;
    private Boolean commentaires;
    private Boolean declarationIrs;

    public DemandeConverter() {
        init(true);
    }

    @Override
    public Demande toItem(DemandeVo vo) {
        if (vo == null) {
            return null;
        } else {
            Demande item = new Demande();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getOperation()))
                item.setOperation(vo.getOperation());
            if (StringUtil.isNotEmpty(vo.getDateDemande()))
                item.setDateDemande(DateUtil.parse(vo.getDateDemande()));
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
            if (vo.getComptableVo() != null && this.comptable)
                item.setComptable(comptableConverter.toItem(vo.getComptableVo()));
            if (vo.getEtatDemandeVo() != null && this.etatDemande)
                item.setEtatDemande(etatDemandeConverter.toItem(vo.getEtatDemandeVo()));

            if (ListUtil.isNotEmpty(vo.getFacturesVo()) && this.factures)
                item.setFactures(factureConverter.toItem(vo.getFacturesVo()));
            if (ListUtil.isNotEmpty(vo.getDemandePieceJointesVo()) && this.demandePieceJointes)
                item.setDemandePieceJointes(demandePieceJointeConverter.toItem(vo.getDemandePieceJointesVo()));
            if (ListUtil.isNotEmpty(vo.getCommentairesVo()) && this.commentaires)
                item.setCommentaires(commentaireConverter.toItem(vo.getCommentairesVo()));
            if (ListUtil.isNotEmpty(vo.getDeclarationIrVos()) && this.declarationIrs)
                item.setDeclarationIrs(declarationIrConverter.toItem(vo.getDeclarationIrVos()));

            return item;
        }
    }

    @Override
    public DemandeVo toVo(Demande item) {
        if (item == null) {
            return null;
        } else {
            DemandeVo vo = new DemandeVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (StringUtil.isNotEmpty(item.getOperation()))
                vo.setOperation(item.getOperation());

            if (item.getDateDemande() != null)
                vo.setDateDemande(DateUtil.formateDate(item.getDateDemande()));
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
            if (item.getComptable() != null && this.comptable) {
                vo.setComptableVo(comptableConverter.toVo(item.getComptable()));
            }
            if (item.getEtatDemande() != null && this.etatDemande) {
                vo.setEtatDemandeVo(etatDemandeConverter.toVo(item.getEtatDemande()));
            }
            if (ListUtil.isNotEmpty(item.getFactures()) && this.factures) {
                factureConverter.init(true);
                factureConverter.setDemande(false);
                vo.setFacturesVo(factureConverter.toVo(item.getFactures()));
                factureConverter.setDemande(true);
            }
            if (ListUtil.isNotEmpty(item.getDemandePieceJointes()) && this.demandePieceJointes) {
                demandePieceJointeConverter.init(true);
                demandePieceJointeConverter.setDemande(false);
                vo.setDemandePieceJointesVo(demandePieceJointeConverter.toVo(item.getDemandePieceJointes()));
                demandePieceJointeConverter.setDemande(true);
            }

            if (ListUtil.isNotEmpty(item.getDeclarationIrs()) && this.declarationIrs) {
                declarationIrConverter.init(true);
                vo.setDeclarationIrVos(declarationIrConverter.toVo(item.getDeclarationIrs()));
            }


            if (ListUtil.isNotEmpty(item.getCommentaires()) && this.commentaires) {
                commentaireConverter.init(true);
                commentaireConverter.setDemande(false);
                vo.setCommentairesVo(commentaireConverter.toVo(item.getCommentaires()));
                commentaireConverter.setDemande(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        societe = value;
        comptable = value;
        etatDemande = value;
        factures = value;
        demandePieceJointes = value;
        commentaires = value;
        declarationIrs = value;
    }


    public SocieteConverter getSocieteConverter() {
        return this.societeConverter;
    }

    public void setSocieteConverter(SocieteConverter societeConverter) {
        this.societeConverter = societeConverter;
    }

    public EtatDemandeConverter getEtatDemandeConverter() {
        return this.etatDemandeConverter;
    }

    public void setEtatDemandeConverter(EtatDemandeConverter etatDemandeConverter) {
        this.etatDemandeConverter = etatDemandeConverter;
    }

    public DemandePieceJointeConverter getDemandePieceJointeConverter() {
        return this.demandePieceJointeConverter;
    }

    public void setDemandePieceJointeConverter(DemandePieceJointeConverter demandePieceJointeConverter) {
        this.demandePieceJointeConverter = demandePieceJointeConverter;
    }

    public FactureConverter getFactureConverter() {
        return this.factureConverter;
    }

    public void setFactureConverter(FactureConverter factureConverter) {
        this.factureConverter = factureConverter;
    }

    public CommentaireConverter getCommentaireConverter() {
        return this.commentaireConverter;
    }

    public void setCommentaireConverter(CommentaireConverter commentaireConverter) {
        this.commentaireConverter = commentaireConverter;
    }

    public ComptableConverter getComptableConverter() {
        return this.comptableConverter;
    }

    public void setComptableConverter(ComptableConverter comptableConverter) {
        this.comptableConverter = comptableConverter;
    }

    public boolean isSociete() {
        return this.societe;
    }

    public void setSociete(boolean societe) {
        this.societe = societe;
    }

    public boolean isComptable() {
        return this.comptable;
    }

    public void setComptable(boolean comptable) {
        this.comptable = comptable;
    }

    public boolean isEtatDemande() {
        return this.etatDemande;
    }

    public void setEtatDemande(boolean etatDemande) {
        this.etatDemande = etatDemande;
    }


    public Boolean isFactures() {
        return this.factures;
    }

    public void setFactures(Boolean factures) {
        this.factures = factures;
    }


    public Boolean isDemandePieceJointes() {
        return this.demandePieceJointes;
    }

    public void setDemandePieceJointes(Boolean demandePieceJointes) {
        this.demandePieceJointes = demandePieceJointes;
    }


    public Boolean isCommentaires() {
        return this.commentaires;
    }

    public void setCommentaires(Boolean commentaires) {
        this.commentaires = commentaires;
    }


}
