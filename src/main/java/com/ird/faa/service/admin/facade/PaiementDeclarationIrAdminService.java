package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.PaiementDeclarationIr;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationIrVo;

import java.util.List;

public interface PaiementDeclarationIrAdminService extends AbstractService<PaiementDeclarationIr, Long, PaiementDeclarationIrVo> {


    /**
     * find PaiementDeclarationIr from database by reference (reference)
     *
     * @param reference - reference of PaiementDeclarationIr
     * @return the founded PaiementDeclarationIr , If no PaiementDeclarationIr were
     * found in database return  null.
     */
    PaiementDeclarationIr findByReference(String reference);

    /**
     * find PaiementDeclarationIr from database by id (PK) or reference (reference)
     *
     * @param id        - id of PaiementDeclarationIr
     * @param reference - reference of PaiementDeclarationIr
     * @return the founded PaiementDeclarationIr , If no PaiementDeclarationIr were
     * found in database return  null.
     */
    PaiementDeclarationIr findByIdOrReference(PaiementDeclarationIr paiementDeclarationIr);


    /**
     * delete PaiementDeclarationIr from database
     *
     * @param id - id of PaiementDeclarationIr to be deleted
     */
    int deleteById(Long id);


    List<PaiementDeclarationIr> findByDeclarationIrRefrerence(String refrerence);

    int deleteByDeclarationIrRefrerence(String refrerence);

    List<PaiementDeclarationIr> findByDeclarationIrId(Long id);

    int deleteByDeclarationIrId(Long id);


    /**
     * delete PaiementDeclarationIr from database by reference (reference)
     *
     * @param reference - reference of PaiementDeclarationIr to be deleted
     * @return 1 if PaiementDeclarationIr deleted successfully
     */
    int deleteByReference(String reference);


}
