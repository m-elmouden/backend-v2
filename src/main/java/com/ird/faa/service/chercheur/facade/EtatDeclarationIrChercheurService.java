package com.ird.faa.service.chercheur.facade;

import com.ird.faa.bean.EtatDeclarationIr;
import com.ird.faa.ws.rest.provided.vo.EtatDeclarationIrVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatDeclarationIrChercheurService extends AbstractService<EtatDeclarationIr,Long,EtatDeclarationIrVo>{


    /**
    * find EtatDeclarationIr from database by reference (reference)
    * @param reference - reference of EtatDeclarationIr
    * @return the founded EtatDeclarationIr , If no EtatDeclarationIr were
    *         found in database return  null.
    */
    EtatDeclarationIr findByReference(String reference);

    /**
    * find EtatDeclarationIr from database by id (PK) or reference (reference)
    * @param id - id of EtatDeclarationIr
    * @param reference - reference of EtatDeclarationIr
    * @return the founded EtatDeclarationIr , If no EtatDeclarationIr were
    *         found in database return  null.
    */
    EtatDeclarationIr findByIdOrReference(EtatDeclarationIr etatDeclarationIr);


/**
    * delete EtatDeclarationIr from database
    * @param id - id of EtatDeclarationIr to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatDeclarationIr from database by reference (reference)
    *
    * @param reference - reference of EtatDeclarationIr to be deleted
    * @return 1 if EtatDeclarationIr deleted successfully
    */
    int deleteByReference(String reference);





}
