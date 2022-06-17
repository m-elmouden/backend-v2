package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.TypeOperationFacture;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.TypeOperationFactureVo;

public interface TypeOperationFactureAdminService extends AbstractService<TypeOperationFacture, Long, TypeOperationFactureVo> {


    /**
     * delete TypeOperationFacture from database
     *
     * @param id - id of TypeOperationFacture to be deleted
     */
    int deleteById(Long id);


}
