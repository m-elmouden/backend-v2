package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.SousClasseComptable;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.SousClasseComptableVo;

import java.util.List;

public interface SousClasseComptableAdminService extends AbstractService<SousClasseComptable, Long, SousClasseComptableVo> {


    /**
     * delete SousClasseComptable from database
     *
     * @param id - id of SousClasseComptable to be deleted
     */
    int deleteById(Long id);


    List<SousClasseComptable> findByClasseComptableId(Long id);

    int deleteByClasseComptableId(Long id);


}
