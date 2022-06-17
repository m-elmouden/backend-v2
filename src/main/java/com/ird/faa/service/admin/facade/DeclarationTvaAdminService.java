package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.DeclarationTva;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.DeclarationTvaVo;

import java.util.List;

public interface DeclarationTvaAdminService extends AbstractService<DeclarationTva, Long, DeclarationTvaVo> {


    /**
     * find DeclarationTva from database by reference (reference)
     *
     * @param reference - reference of DeclarationTva
     * @return the founded DeclarationTva , If no DeclarationTva were
     * found in database return  null.
     */
    DeclarationTva findByReference(String reference);

    /**
     * find DeclarationTva from database by id (PK) or reference (reference)
     *
     * @param id        - id of DeclarationTva
     * @param reference - reference of DeclarationTva
     * @return the founded DeclarationTva , If no DeclarationTva were
     * found in database return  null.
     */
    DeclarationTva findByIdOrReference(DeclarationTva declarationTva);


    /**
     * delete DeclarationTva from database
     *
     * @param id - id of DeclarationTva to be deleted
     */
    int deleteById(Long id);


    List<DeclarationTva> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);

    List<DeclarationTva> findByTypeDeclarationTvaReference(String reference);

    int deleteByTypeDeclarationTvaReference(String reference);

    List<DeclarationTva> findByTypeDeclarationTvaId(Long id);

    int deleteByTypeDeclarationTvaId(Long id);

    List<DeclarationTva> findByEtatDeclarationTvaReference(String reference);

    int deleteByEtatDeclarationTvaReference(String reference);

    List<DeclarationTva> findByEtatDeclarationTvaId(Long id);

    int deleteByEtatDeclarationTvaId(Long id);

    List<DeclarationTva> findByPaiementDeclarationTvaReference(String reference);

    int deleteByPaiementDeclarationTvaReference(String reference);

    List<DeclarationTva> findByPaiementDeclarationTvaId(Long id);

    int deleteByPaiementDeclarationTvaId(Long id);


    /**
     * delete DeclarationTva from database by reference (reference)
     *
     * @param reference - reference of DeclarationTva to be deleted
     * @return 1 if DeclarationTva deleted successfully
     */
    int deleteByReference(String reference);


    DeclarationTva archiver(DeclarationTva declarationTva);

    DeclarationTva desarchiver(DeclarationTva declarationTva);

}
