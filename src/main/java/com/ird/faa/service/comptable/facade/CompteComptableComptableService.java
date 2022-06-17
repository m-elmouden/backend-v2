package com.ird.faa.service.comptable.facade;

import com.ird.faa.bean.CompteComptable;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.CompteComptableVo;

import java.math.BigDecimal;
import java.util.List;

public interface CompteComptableComptableService extends AbstractService<CompteComptable, Long, CompteComptableVo> {


    /**
     * find CompteComptable from database by numero (reference)
     *
     * @param numero - reference of CompteComptable
     * @return the founded CompteComptable , If no CompteComptable were
     * found in database return  null.
     */
    CompteComptable findByNumero(BigDecimal numero);

    /**
     * find CompteComptable from database by id (PK) or numero (reference)
     *
     * @param id     - id of CompteComptable
     * @param numero - reference of CompteComptable
     * @return the founded CompteComptable , If no CompteComptable were
     * found in database return  null.
     */
    CompteComptable findByIdOrNumero(CompteComptable compteComptable);


    /**
     * delete CompteComptable from database
     *
     * @param id - id of CompteComptable to be deleted
     */
    int deleteById(Long id);


    List<CompteComptable> findBySousClasseComptableId(Long id);

    int deleteBySousClasseComptableId(Long id);


    /**
     * delete CompteComptable from database by numero (reference)
     *
     * @param numero - reference of CompteComptable to be deleted
     * @return 1 if CompteComptable deleted successfully
     */
    int deleteByNumero(BigDecimal numero);


}
