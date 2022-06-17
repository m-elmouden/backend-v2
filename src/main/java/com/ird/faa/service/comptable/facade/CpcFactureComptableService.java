package com.ird.faa.service.comptable.facade;

import com.ird.faa.bean.CpcFacture;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.CpcFactureVo;

import java.util.List;

public interface CpcFactureComptableService extends AbstractService<CpcFacture, Long, CpcFactureVo> {


    /**
     * delete CpcFacture from database
     *
     * @param id - id of CpcFacture to be deleted
     */
    int deleteById(Long id);


    List<CpcFacture> findByCpcReference(String reference);

    int deleteByCpcReference(String reference);

    List<CpcFacture> findByCpcId(Long id);

    int deleteByCpcId(Long id);

    List<CpcFacture> findByFactureReference(String reference);

    int deleteByFactureReference(String reference);

    List<CpcFacture> findByFactureId(Long id);

    int deleteByFactureId(Long id);


}
