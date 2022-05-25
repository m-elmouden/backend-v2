package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.TypeSociete;
import com.ird.faa.ws.rest.provided.vo.TypeSocieteVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeSocieteAdminService extends AbstractService<TypeSociete,Long,TypeSocieteVo>{


    /**
    * find TypeSociete from database by code (reference)
    * @param code - reference of TypeSociete
    * @return the founded TypeSociete , If no TypeSociete were
    *         found in database return  null.
    */
    TypeSociete findByCode(String code);

    /**
    * find TypeSociete from database by id (PK) or code (reference)
    * @param id - id of TypeSociete
    * @param code - reference of TypeSociete
    * @return the founded TypeSociete , If no TypeSociete were
    *         found in database return  null.
    */
    TypeSociete findByIdOrCode(TypeSociete typeSociete);


/**
    * delete TypeSociete from database
    * @param id - id of TypeSociete to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TypeSociete from database by code (reference)
    *
    * @param code - reference of TypeSociete to be deleted
    * @return 1 if TypeSociete deleted successfully
    */
    int deleteByCode(String code);





}
