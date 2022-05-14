package com.ird.faa.service.comptable.facade;

import java.util.List;
import com.ird.faa.bean.EtatDeclarationTva;
import com.ird.faa.ws.rest.provided.vo.EtatDeclarationTvaVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatDeclarationTvaComptableService extends AbstractService<EtatDeclarationTva,Long,EtatDeclarationTvaVo>{


    /**
    * find EtatDeclarationTva from database by reference (reference)
    * @param reference - reference of EtatDeclarationTva
    * @return the founded EtatDeclarationTva , If no EtatDeclarationTva were
    *         found in database return  null.
    */
    EtatDeclarationTva findByReference(String reference);

    /**
    * find EtatDeclarationTva from database by id (PK) or reference (reference)
    * @param id - id of EtatDeclarationTva
    * @param reference - reference of EtatDeclarationTva
    * @return the founded EtatDeclarationTva , If no EtatDeclarationTva were
    *         found in database return  null.
    */
    EtatDeclarationTva findByIdOrReference(EtatDeclarationTva etatDeclarationTva);


/**
    * delete EtatDeclarationTva from database
    * @param id - id of EtatDeclarationTva to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatDeclarationTva from database by reference (reference)
    *
    * @param reference - reference of EtatDeclarationTva to be deleted
    * @return 1 if EtatDeclarationTva deleted successfully
    */
    int deleteByReference(String reference);




    EtatDeclarationTva archiver(EtatDeclarationTva etatDeclarationTva) ;
    EtatDeclarationTva desarchiver(EtatDeclarationTva etatDeclarationTva);

}
