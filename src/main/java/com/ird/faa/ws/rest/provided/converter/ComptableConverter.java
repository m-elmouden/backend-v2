package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.Comptable;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.ComptableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComptableConverter extends AbstractConverter<Comptable, ComptableVo> {

    @Autowired
    private SocieteConverter societeConverter;
    @Autowired
    private DemandeConverter demandeConverter;
    @Autowired
    private TypeComptableConverter typeComptableConverter;
    private Boolean typeComptable;
    private Boolean societes;
    private Boolean demandes;

    public ComptableConverter() {
        init(true);
    }

    @Override
    public Comptable toItem(ComptableVo vo) {
        if (vo == null) {
            return null;
        } else {
            Comptable item = new Comptable();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getCode()))
                item.setCode(vo.getCode());
            if (StringUtil.isNotEmpty(vo.getNom()))
                item.setNom(vo.getNom());
            if (StringUtil.isNotEmpty(vo.getTelephone()))
                item.setTelephone(vo.getTelephone());
            if (StringUtil.isNotEmpty(vo.getPrenom()))
                item.setPrenom(vo.getPrenom());
            item.setCredentialsNonExpired(vo.getCredentialsNonExpired());
            item.setEnabled(vo.getEnabled());
            item.setAccountNonExpired(vo.getAccountNonExpired());
            item.setAccountNonLocked(vo.getAccountNonLocked());
            item.setPasswordChanged(vo.getPasswordChanged());
            if (StringUtil.isNotEmpty(vo.getCreatedAt()))
                item.setCreatedAt(DateUtil.parse(vo.getCreatedAt()));
            if (StringUtil.isNotEmpty(vo.getUpdatedAt()))
                item.setUpdatedAt(DateUtil.parse(vo.getUpdatedAt()));
            if (StringUtil.isNotEmpty(vo.getUsername()))
                item.setUsername(vo.getUsername());
            if (StringUtil.isNotEmpty(vo.getPassword()))
                item.setPassword(vo.getPassword());
            if (StringUtil.isNotEmpty(vo.getEquivalenceAvecPanelErc()))
                item.setEquivalenceAvecPanelErc(vo.getEquivalenceAvecPanelErc());
            if (StringUtil.isNotEmpty(vo.getBaseHorizon()))
                item.setBaseHorizon(vo.getBaseHorizon());
            if (StringUtil.isNotEmpty(vo.getRole()))
                item.setRole(vo.getRole());
            if (vo.getTypeComptableVo() != null && this.typeComptable)
                item.setTypeComptable(typeComptableConverter.toItem(vo.getTypeComptableVo()));

            if (ListUtil.isNotEmpty(vo.getSocietesVo()) && this.societes)
                item.setSocietes(societeConverter.toItem(vo.getSocietesVo()));
            if (ListUtil.isNotEmpty(vo.getDemandesVo()) && this.demandes)
                item.setDemandes(demandeConverter.toItem(vo.getDemandesVo()));

            return item;
        }
    }

    @Override
    public ComptableVo toVo(Comptable item) {
        if (item == null) {
            return null;
        } else {
            ComptableVo vo = new ComptableVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getCode()))
                vo.setCode(item.getCode());

            if (StringUtil.isNotEmpty(item.getNom()))
                vo.setNom(item.getNom());

            if (StringUtil.isNotEmpty(item.getTelephone()))
                vo.setTelephone(item.getTelephone());

            if (StringUtil.isNotEmpty(item.getPrenom()))
                vo.setPrenom(item.getPrenom());

            vo.setCredentialsNonExpired(item.getCredentialsNonExpired());
            vo.setEnabled(item.getEnabled());
            vo.setAccountNonExpired(item.getAccountNonExpired());
            vo.setAccountNonLocked(item.getAccountNonLocked());
            vo.setPasswordChanged(item.getPasswordChanged());
            if (item.getCreatedAt() != null)
                vo.setCreatedAt(DateUtil.formateDate(item.getCreatedAt()));
            if (item.getUpdatedAt() != null)
                vo.setUpdatedAt(DateUtil.formateDate(item.getUpdatedAt()));
            if (StringUtil.isNotEmpty(item.getUsername()))
                vo.setUsername(item.getUsername());

            if (StringUtil.isNotEmpty(item.getPassword()))
                vo.setPassword(item.getPassword());

            if (StringUtil.isNotEmpty(item.getEquivalenceAvecPanelErc()))
                vo.setEquivalenceAvecPanelErc(item.getEquivalenceAvecPanelErc());

            if (StringUtil.isNotEmpty(item.getBaseHorizon()))
                vo.setBaseHorizon(item.getBaseHorizon());

            if (StringUtil.isNotEmpty(item.getRole()))
                vo.setRole(item.getRole());

            if (item.getTypeComptable() != null && this.typeComptable) {
                vo.setTypeComptableVo(typeComptableConverter.toVo(item.getTypeComptable()));
            }
            if (ListUtil.isNotEmpty(item.getSocietes()) && this.societes) {
                societeConverter.init(true);
                societeConverter.setComptable(false);
                vo.setSocietesVo(societeConverter.toVo(item.getSocietes()));
                societeConverter.setComptable(true);
            }
            if (ListUtil.isNotEmpty(item.getDemandes()) && this.demandes) {
                demandeConverter.init(true);
                demandeConverter.setComptable(false);
                vo.setDemandesVo(demandeConverter.toVo(item.getDemandes()));
                demandeConverter.setComptable(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        typeComptable = value;
        societes = value;
        demandes = value;
    }


    public SocieteConverter getSocieteConverter() {
        return this.societeConverter;
    }

    public void setSocieteConverter(SocieteConverter societeConverter) {
        this.societeConverter = societeConverter;
    }

    public DemandeConverter getDemandeConverter() {
        return this.demandeConverter;
    }

    public void setDemandeConverter(DemandeConverter demandeConverter) {
        this.demandeConverter = demandeConverter;
    }

    public TypeComptableConverter getTypeComptableConverter() {
        return this.typeComptableConverter;
    }

    public void setTypeComptableConverter(TypeComptableConverter typeComptableConverter) {
        this.typeComptableConverter = typeComptableConverter;
    }

    public boolean isTypeComptable() {
        return this.typeComptable;
    }

    public void setTypeComptable(boolean typeComptable) {
        this.typeComptable = typeComptable;
    }


    public Boolean isSocietes() {
        return this.societes;
    }

    public void setSocietes(Boolean societes) {
        this.societes = societes;
    }


    public Boolean isDemandes() {
        return this.demandes;
    }

    public void setDemandes(Boolean demandes) {
        this.demandes = demandes;
    }


}
