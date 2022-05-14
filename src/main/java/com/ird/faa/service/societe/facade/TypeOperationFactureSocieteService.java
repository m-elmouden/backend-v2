package com.ird.faa.service.societe.facade;

import java.util.List;
import com.ird.faa.bean.TypeOperationFacture;
import com.ird.faa.ws.rest.provided.vo.TypeOperationFactureVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeOperationFactureSocieteService extends AbstractService<TypeOperationFacture,Long,TypeOperationFactureVo>{




/**
    * delete TypeOperationFacture from database
    * @param id - id of TypeOperationFacture to be deleted
    *
    */
    int deleteById(Long id);









}
