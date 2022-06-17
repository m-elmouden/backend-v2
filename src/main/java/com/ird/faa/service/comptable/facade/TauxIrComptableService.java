package com.ird.faa.service.comptable.facade;

import com.ird.faa.bean.TauxIr;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.TauxIrVo;

public interface TauxIrComptableService extends AbstractService<TauxIr, Long, TauxIrVo> {


    /**
     * delete TauxIr from database
     *
     * @param id - id of TauxIr to be deleted
     */
    int deleteById(Long id);


}
