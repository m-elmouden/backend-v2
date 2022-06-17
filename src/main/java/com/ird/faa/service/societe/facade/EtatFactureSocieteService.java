package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.EtatFacture;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.EtatFactureVo;

public interface EtatFactureSocieteService extends AbstractService<EtatFacture, Long, EtatFactureVo> {


    /**
     * delete EtatFacture from database
     *
     * @param id - id of EtatFacture to be deleted
     */
    int deleteById(Long id);


}
