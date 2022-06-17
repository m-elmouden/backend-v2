package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.TauxIs;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.TauxIsVo;

import java.util.List;

public interface TauxIsSocieteService extends AbstractService<TauxIs, Long, TauxIsVo> {


    /**
     * find TauxIs from database by reference (reference)
     *
     * @param reference - reference of TauxIs
     * @return the founded TauxIs , If no TauxIs were
     * found in database return  null.
     */
    TauxIs findByReference(String reference);

    /**
     * find TauxIs from database by id (PK) or reference (reference)
     *
     * @param id        - id of TauxIs
     * @param reference - reference of TauxIs
     * @return the founded TauxIs , If no TauxIs were
     * found in database return  null.
     */
    TauxIs findByIdOrReference(TauxIs tauxIs);


    /**
     * delete TauxIs from database
     *
     * @param id - id of TauxIs to be deleted
     */
    int deleteById(Long id);


    List<TauxIs> findByTauxIsConfigReference(String reference);

    int deleteByTauxIsConfigReference(String reference);

    List<TauxIs> findByTauxIsConfigId(Long id);

    int deleteByTauxIsConfigId(Long id);


    /**
     * delete TauxIs from database by reference (reference)
     *
     * @param reference - reference of TauxIs to be deleted
     * @return 1 if TauxIs deleted successfully
     */
    int deleteByReference(String reference);


}
