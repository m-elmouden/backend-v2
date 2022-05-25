package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.EtatDeclarationIs;
import com.ird.faa.ws.rest.provided.vo.EtatDeclarationIsVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatDeclarationIsAdminService extends AbstractService<EtatDeclarationIs,Long,EtatDeclarationIsVo>{


    /**
    * find EtatDeclarationIs from database by reference (reference)
    * @param reference - reference of EtatDeclarationIs
    * @return the founded EtatDeclarationIs , If no EtatDeclarationIs were
    *         found in database return  null.
    */
    EtatDeclarationIs findByReference(String reference);

    /**
    * find EtatDeclarationIs from database by id (PK) or reference (reference)
    * @param id - id of EtatDeclarationIs
    * @param reference - reference of EtatDeclarationIs
    * @return the founded EtatDeclarationIs , If no EtatDeclarationIs were
    *         found in database return  null.
    */
    EtatDeclarationIs findByIdOrReference(EtatDeclarationIs etatDeclarationIs);


/**
    * delete EtatDeclarationIs from database
    * @param id - id of EtatDeclarationIs to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatDeclarationIs from database by reference (reference)
    *
    * @param reference - reference of EtatDeclarationIs to be deleted
    * @return 1 if EtatDeclarationIs deleted successfully
    */
    int deleteByReference(String reference);




    EtatDeclarationIs archiver(EtatDeclarationIs etatDeclarationIs) ;
    EtatDeclarationIs desarchiver(EtatDeclarationIs etatDeclarationIs);

}
