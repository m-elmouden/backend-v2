package com.ird.faa.service.comptable.facade;

import java.util.List;
import com.ird.faa.bean.SousClasseComptable;
import com.ird.faa.ws.rest.provided.vo.SousClasseComptableVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface SousClasseComptableComptableService extends AbstractService<SousClasseComptable,Long,SousClasseComptableVo>{




/**
    * delete SousClasseComptable from database
    * @param id - id of SousClasseComptable to be deleted
    *
    */
    int deleteById(Long id);



    List<SousClasseComptable> findByClasseComptableId(Long id);

    int deleteByClasseComptableId(Long id);







}
