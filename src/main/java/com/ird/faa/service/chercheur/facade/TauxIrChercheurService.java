package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.TauxIr;
import com.ird.faa.ws.rest.provided.vo.TauxIrVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TauxIrChercheurService extends AbstractService<TauxIr,Long,TauxIrVo>{




/**
    * delete TauxIr from database
    * @param id - id of TauxIr to be deleted
    *
    */
    int deleteById(Long id);









}
