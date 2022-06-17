package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.ClasseComptable;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.ClasseComptableVo;

public interface ClasseComptableAdminService extends AbstractService<ClasseComptable, Long, ClasseComptableVo> {


    /**
     * delete ClasseComptable from database
     *
     * @param id - id of ClasseComptable to be deleted
     */
    int deleteById(Long id);


    ClasseComptable archiver(ClasseComptable classeComptable);

    ClasseComptable desarchiver(ClasseComptable classeComptable);

}
