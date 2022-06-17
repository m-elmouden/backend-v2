package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.Cpc;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.CpcVo;

public interface CpcSocieteService extends AbstractService<Cpc, Long, CpcVo> {


    /**
     * find Cpc from database by reference (reference)
     *
     * @param reference - reference of Cpc
     * @return the founded Cpc , If no Cpc were
     * found in database return  null.
     */
    Cpc findByReference(String reference);

    /**
     * find Cpc from database by id (PK) or reference (reference)
     *
     * @param id        - id of Cpc
     * @param reference - reference of Cpc
     * @return the founded Cpc , If no Cpc were
     * found in database return  null.
     */
    Cpc findByIdOrReference(Cpc cpc);


    /**
     * delete Cpc from database
     *
     * @param id - id of Cpc to be deleted
     */
    int deleteById(Long id);


    /**
     * delete Cpc from database by reference (reference)
     *
     * @param reference - reference of Cpc to be deleted
     * @return 1 if Cpc deleted successfully
     */
    int deleteByReference(String reference);


    Cpc archiver(Cpc cpc);

    Cpc desarchiver(Cpc cpc);

}
