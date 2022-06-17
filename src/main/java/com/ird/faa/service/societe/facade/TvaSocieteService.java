package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.Tva;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.TvaVo;

public interface TvaSocieteService extends AbstractService<Tva, Long, TvaVo> {


    /**
     * find Tva from database by reference (reference)
     *
     * @param reference - reference of Tva
     * @return the founded Tva , If no Tva were
     * found in database return  null.
     */
    Tva findByReference(String reference);

    /**
     * find Tva from database by id (PK) or reference (reference)
     *
     * @param id        - id of Tva
     * @param reference - reference of Tva
     * @return the founded Tva , If no Tva were
     * found in database return  null.
     */
    Tva findByIdOrReference(Tva tva);


    /**
     * delete Tva from database
     *
     * @param id - id of Tva to be deleted
     */
    int deleteById(Long id);


    /**
     * delete Tva from database by reference (reference)
     *
     * @param reference - reference of Tva to be deleted
     * @return 1 if Tva deleted successfully
     */
    int deleteByReference(String reference);


}
