package com.ird.faa.service.comptable.facade;

import com.ird.faa.bean.TypeOperationFacture;
import com.ird.faa.ws.rest.provided.vo.TypeOperationFactureVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeOperationFactureComptableService extends AbstractService<TypeOperationFacture,Long,TypeOperationFactureVo>{




/**
    * delete TypeOperationFacture from database
    * @param id - id of TypeOperationFacture to be deleted
    *
    */
    int deleteById(Long id);









}
