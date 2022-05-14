package com.ird.faa.service.societe.facade;

import java.util.List;
import com.ird.faa.bean.Comptable;
import com.ird.faa.ws.rest.provided.vo.ComptableVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ComptableSocieteService extends AbstractService<Comptable,Long,ComptableVo>{

    Comptable findByUsername(String username);

    /**
    * find Comptable from database by code (reference)
    * @param code - reference of Comptable
    * @return the founded Comptable , If no Comptable were
    *         found in database return  null.
    */
    Comptable findByCode(String code);

    /**
    * find Comptable from database by id (PK) or code (reference)
    * @param id - id of Comptable
    * @param code - reference of Comptable
    * @return the founded Comptable , If no Comptable were
    *         found in database return  null.
    */
    Comptable findByIdOrCode(Comptable comptable);


/**
    * delete Comptable from database
    * @param id - id of Comptable to be deleted
    *
    */
    int deleteById(Long id);


    List<Comptable> findByTypeComptableReference(String reference);

    int deleteByTypeComptableReference(String reference);

    List<Comptable> findByTypeComptableId(Long id);

    int deleteByTypeComptableId(Long id);


    /**
    * delete Comptable from database by code (reference)
    *
    * @param code - reference of Comptable to be deleted
    * @return 1 if Comptable deleted successfully
    */
    int deleteByCode(String code);





}
