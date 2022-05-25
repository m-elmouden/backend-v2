package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.TauxIsConfig;
import com.ird.faa.ws.rest.provided.vo.TauxIsConfigVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TauxIsConfigSocieteService extends AbstractService<TauxIsConfig,Long,TauxIsConfigVo>{


    /**
    * find TauxIsConfig from database by reference (reference)
    * @param reference - reference of TauxIsConfig
    * @return the founded TauxIsConfig , If no TauxIsConfig were
    *         found in database return  null.
    */
    TauxIsConfig findByReference(String reference);

    /**
    * find TauxIsConfig from database by id (PK) or reference (reference)
    * @param id - id of TauxIsConfig
    * @param reference - reference of TauxIsConfig
    * @return the founded TauxIsConfig , If no TauxIsConfig were
    *         found in database return  null.
    */
    TauxIsConfig findByIdOrReference(TauxIsConfig tauxIsConfig);


/**
    * delete TauxIsConfig from database
    * @param id - id of TauxIsConfig to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TauxIsConfig from database by reference (reference)
    *
    * @param reference - reference of TauxIsConfig to be deleted
    * @return 1 if TauxIsConfig deleted successfully
    */
    int deleteByReference(String reference);





}
