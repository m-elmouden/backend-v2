package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.FacturePieceJointe;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.FacturePieceJointeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacturePieceJointeConverter extends AbstractConverter<FacturePieceJointe, FacturePieceJointeVo> {

    @Autowired
    private FactureConverter factureConverter;
    private Boolean facture;

    public FacturePieceJointeConverter() {
        init(true);
    }

    @Override
    public FacturePieceJointe toItem(FacturePieceJointeVo vo) {
        if (vo == null) {
            return null;
        } else {
            FacturePieceJointe item = new FacturePieceJointe();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getName()))
                item.setName(vo.getName());
            if (StringUtil.isNotEmpty(vo.getPath()))
                item.setPath(vo.getPath());
            if (vo.getFactureVo() != null && this.facture)
                item.setFacture(factureConverter.toItem(vo.getFactureVo()));


            return item;
        }
    }

    @Override
    public FacturePieceJointeVo toVo(FacturePieceJointe item) {
        if (item == null) {
            return null;
        } else {
            FacturePieceJointeVo vo = new FacturePieceJointeVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getName()))
                vo.setName(item.getName());

            if (StringUtil.isNotEmpty(item.getPath()))
                vo.setPath(item.getPath());

            if (item.getFacture() != null && this.facture) {
                vo.setFactureVo(factureConverter.toVo(item.getFacture()));
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        facture = value;
    }


    public FactureConverter getFactureConverter() {
        return this.factureConverter;
    }

    public void setFactureConverter(FactureConverter factureConverter) {
        this.factureConverter = factureConverter;
    }

    public boolean isFacture() {
        return this.facture;
    }

    public void setFacture(boolean facture) {
        this.facture = facture;
    }


}
