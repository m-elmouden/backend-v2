package com.ird.faa.service.comptable.facade;

import com.ird.faa.bean.PaiementDeclarationTva;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationTvaVo;

import java.util.List;

public interface PaiementDeclarationTvaComptableService extends AbstractService<PaiementDeclarationTva, Long, PaiementDeclarationTvaVo> {


    /**
     * find PaiementDeclarationTva from database by reference (reference)
     *
     * @param reference - reference of PaiementDeclarationTva
     * @return the founded PaiementDeclarationTva , If no PaiementDeclarationTva were
     * found in database return  null.
     */
    PaiementDeclarationTva findByReference(String reference);

    /**
     * find PaiementDeclarationTva from database by id (PK) or reference (reference)
     *
     * @param id        - id of PaiementDeclarationTva
     * @param reference - reference of PaiementDeclarationTva
     * @return the founded PaiementDeclarationTva , If no PaiementDeclarationTva were
     * found in database return  null.
     */
    PaiementDeclarationTva findByIdOrReference(PaiementDeclarationTva paiementDeclarationTva);


    /**
     * delete PaiementDeclarationTva from database
     *
     * @param id - id of PaiementDeclarationTva to be deleted
     */
    int deleteById(Long id);


    List<PaiementDeclarationTva> findByDeclarationTvaReference(String reference);

    int deleteByDeclarationTvaReference(String reference);

    List<PaiementDeclarationTva> findByDeclarationTvaId(Long id);

    int deleteByDeclarationTvaId(Long id);


    /**
     * delete PaiementDeclarationTva from database by reference (reference)
     *
     * @param reference - reference of PaiementDeclarationTva to be deleted
     * @return 1 if PaiementDeclarationTva deleted successfully
     */
    int deleteByReference(String reference);


}
