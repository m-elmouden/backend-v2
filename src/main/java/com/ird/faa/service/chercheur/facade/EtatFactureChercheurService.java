package com.ird.faa.service.chercheur.facade;

import com.ird.faa.bean.EtatFacture;
import com.ird.faa.ws.rest.provided.vo.EtatFactureVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatFactureChercheurService extends AbstractService<EtatFacture,Long,EtatFactureVo>{




/**
    * delete EtatFacture from database
    * @param id - id of EtatFacture to be deleted
    *
    */
    int deleteById(Long id);









}
