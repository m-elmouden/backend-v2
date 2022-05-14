package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.TypeOperationFacture;
import com.ird.faa.ws.rest.provided.vo.TypeOperationFactureVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeOperationFactureChercheurService extends AbstractService<TypeOperationFacture,Long,TypeOperationFactureVo>{




/**
    * delete TypeOperationFacture from database
    * @param id - id of TypeOperationFacture to be deleted
    *
    */
    int deleteById(Long id);









}
