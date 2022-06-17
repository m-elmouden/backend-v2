package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.TauxIr;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.TauxIrVo;

import java.math.BigDecimal;

public interface TauxIrSocieteService extends AbstractService<TauxIr, Long, TauxIrVo> {


    /**
     * delete TauxIr from database
     *
     * @param id - id of TauxIr to be deleted
     */
    int deleteById(Long id);

    TauxIr findTauxIrConvenable(BigDecimal salaire);


}
