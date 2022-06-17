package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.TypeEmploye;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.TypeEmployeVo;

public interface TypeEmployeAdminService extends AbstractService<TypeEmploye, Long, TypeEmployeVo> {


    /**
     * find TypeEmploye from database by code (reference)
     *
     * @param code - reference of TypeEmploye
     * @return the founded TypeEmploye , If no TypeEmploye were
     * found in database return  null.
     */
    TypeEmploye findByCode(String code);

    /**
     * find TypeEmploye from database by id (PK) or code (reference)
     *
     * @param id   - id of TypeEmploye
     * @param code - reference of TypeEmploye
     * @return the founded TypeEmploye , If no TypeEmploye were
     * found in database return  null.
     */
    TypeEmploye findByIdOrCode(TypeEmploye typeEmploye);


    /**
     * delete TypeEmploye from database
     *
     * @param id - id of TypeEmploye to be deleted
     */
    int deleteById(Long id);


    /**
     * delete TypeEmploye from database by code (reference)
     *
     * @param code - reference of TypeEmploye to be deleted
     * @return 1 if TypeEmploye deleted successfully
     */
    int deleteByCode(String code);


}
