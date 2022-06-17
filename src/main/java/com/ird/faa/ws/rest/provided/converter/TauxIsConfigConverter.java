package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.TauxIsConfig;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.TauxIsConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TauxIsConfigConverter extends AbstractConverter<TauxIsConfig, TauxIsConfigVo> {

    @Autowired
    private TauxIsConverter tauxIsConverter;
    private Boolean tauxIss;

    public TauxIsConfigConverter() {
        init(true);
    }

    @Override
    public TauxIsConfig toItem(TauxIsConfigVo vo) {
        if (vo == null) {
            return null;
        } else {
            TauxIsConfig item = new TauxIsConfig();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getCotisationMinimale()))
                item.setCotisationMinimale(NumberUtil.toBigDecimal(vo.getCotisationMinimale()));
            if (StringUtil.isNotEmpty(vo.getDateMin()))
                item.setDateMin(DateUtil.parse(vo.getDateMin()));
            if (StringUtil.isNotEmpty(vo.getDateMax()))
                item.setDateMax(DateUtil.parse(vo.getDateMax()));

            if (ListUtil.isNotEmpty(vo.getTauxIssVo()) && this.tauxIss)
                item.setTauxIss(tauxIsConverter.toItem(vo.getTauxIssVo()));

            return item;
        }
    }

    @Override
    public TauxIsConfigVo toVo(TauxIsConfig item) {
        if (item == null) {
            return null;
        } else {
            TauxIsConfigVo vo = new TauxIsConfigVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (item.getCotisationMinimale() != null)
                vo.setCotisationMinimale(NumberUtil.toString(item.getCotisationMinimale()));

            if (item.getDateMin() != null)
                vo.setDateMin(DateUtil.formateDate(item.getDateMin()));
            if (item.getDateMax() != null)
                vo.setDateMax(DateUtil.formateDate(item.getDateMax()));
            if (ListUtil.isNotEmpty(item.getTauxIss()) && this.tauxIss) {
                tauxIsConverter.init(true);
                tauxIsConverter.setTauxIsConfig(false);
                vo.setTauxIssVo(tauxIsConverter.toVo(item.getTauxIss()));
                tauxIsConverter.setTauxIsConfig(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        tauxIss = value;
    }


    public TauxIsConverter getTauxIsConverter() {
        return this.tauxIsConverter;
    }

    public void setTauxIsConverter(TauxIsConverter tauxIsConverter) {
        this.tauxIsConverter = tauxIsConverter;
    }


    public Boolean isTauxIss() {
        return this.tauxIss;
    }

    public void setTauxIss(Boolean tauxIss) {
        this.tauxIss = tauxIss;
    }


}
