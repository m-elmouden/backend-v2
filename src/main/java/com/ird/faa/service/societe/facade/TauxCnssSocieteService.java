package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.TauxCnss;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.TauxCnssVo;

import java.util.List;

public interface TauxCnssSocieteService extends AbstractService<TauxCnss, Long, TauxCnssVo> {


    /**
     * find TauxCnss from database by ref (reference)
     *
     * @param ref - reference of TauxCnss
     * @return the founded TauxCnss , If no TauxCnss were
     * found in database return  null.
     */
    TauxCnss findByRef(String ref);

    /**
     * find TauxCnss from database by id (PK) or ref (reference)
     *
     * @param id  - id of TauxCnss
     * @param ref - reference of TauxCnss
     * @return the founded TauxCnss , If no TauxCnss were
     * found in database return  null.
     */
    TauxCnss findByIdOrRef(TauxCnss tauxCnss);


    /**
     * delete TauxCnss from database
     *
     * @param id - id of TauxCnss to be deleted
     */
    int deleteById(Long id);


    List<TauxCnss> findByTypeTauxCnssId(Long id);

    int deleteByTypeTauxCnssId(Long id);


    /**
     * delete TauxCnss from database by ref (reference)
     *
     * @param ref - reference of TauxCnss to be deleted
     * @return 1 if TauxCnss deleted successfully
     */
    int deleteByRef(String ref);


    TauxCnss archiver(TauxCnss tauxCnss);

    TauxCnss desarchiver(TauxCnss tauxCnss);

}
