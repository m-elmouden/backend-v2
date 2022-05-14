package com.ird.faa.service.comptable.facade;

import java.util.List;
import com.ird.faa.bean.TypeComptable;
import com.ird.faa.ws.rest.provided.vo.TypeComptableVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeComptableComptableService extends AbstractService<TypeComptable,Long,TypeComptableVo>{


    /**
    * find TypeComptable from database by reference (reference)
    * @param reference - reference of TypeComptable
    * @return the founded TypeComptable , If no TypeComptable were
    *         found in database return  null.
    */
    TypeComptable findByReference(String reference);

    /**
    * find TypeComptable from database by id (PK) or reference (reference)
    * @param id - id of TypeComptable
    * @param reference - reference of TypeComptable
    * @return the founded TypeComptable , If no TypeComptable were
    *         found in database return  null.
    */
    TypeComptable findByIdOrReference(TypeComptable typeComptable);


/**
    * delete TypeComptable from database
    * @param id - id of TypeComptable to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TypeComptable from database by reference (reference)
    *
    * @param reference - reference of TypeComptable to be deleted
    * @return 1 if TypeComptable deleted successfully
    */
    int deleteByReference(String reference);





}
