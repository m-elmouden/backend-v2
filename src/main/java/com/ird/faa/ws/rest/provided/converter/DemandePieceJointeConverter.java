package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.DemandePieceJointe;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.DemandePieceJointeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemandePieceJointeConverter extends AbstractConverter<DemandePieceJointe, DemandePieceJointeVo> {

    @Autowired
    private DemandeConverter demandeConverter;
    private Boolean demande;

    public DemandePieceJointeConverter() {
        init(true);
    }

    @Override
    public DemandePieceJointe toItem(DemandePieceJointeVo vo) {
        if (vo == null) {
            return null;
        } else {
            DemandePieceJointe item = new DemandePieceJointe();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getName()))
                item.setName(vo.getName());
            if (StringUtil.isNotEmpty(vo.getPath()))
                item.setPath(vo.getPath());
            if (vo.getDemandeVo() != null && this.demande)
                item.setDemande(demandeConverter.toItem(vo.getDemandeVo()));


            return item;
        }
    }

    @Override
    public DemandePieceJointeVo toVo(DemandePieceJointe item) {
        if (item == null) {
            return null;
        } else {
            DemandePieceJointeVo vo = new DemandePieceJointeVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getName()))
                vo.setName(item.getName());

            if (StringUtil.isNotEmpty(item.getPath()))
                vo.setPath(item.getPath());

            if (item.getDemande() != null && this.demande) {
                vo.setDemandeVo(demandeConverter.toVo(item.getDemande()));
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        demande = value;
    }


    public DemandeConverter getDemandeConverter() {
        return this.demandeConverter;
    }

    public void setDemandeConverter(DemandeConverter demandeConverter) {
        this.demandeConverter = demandeConverter;
    }

    public boolean isDemande() {
        return this.demande;
    }

    public void setDemande(boolean demande) {
        this.demande = demande;
    }


}
