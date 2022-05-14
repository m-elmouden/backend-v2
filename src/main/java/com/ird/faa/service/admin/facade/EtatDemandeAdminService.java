package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.EtatDemande;
import com.ird.faa.ws.rest.provided.vo.EtatDemandeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatDemandeAdminService extends AbstractService<EtatDemande,Long,EtatDemandeVo>{


    /**
    * find EtatDemande from database by reference (reference)
    * @param reference - reference of EtatDemande
    * @return the founded EtatDemande , If no EtatDemande were
    *         found in database return  null.
    */
    EtatDemande findByReference(String reference);

    /**
    * find EtatDemande from database by id (PK) or reference (reference)
    * @param id - id of EtatDemande
    * @param reference - reference of EtatDemande
    * @return the founded EtatDemande , If no EtatDemande were
    *         found in database return  null.
    */
    EtatDemande findByIdOrReference(EtatDemande etatDemande);


/**
    * delete EtatDemande from database
    * @param id - id of EtatDemande to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatDemande from database by reference (reference)
    *
    * @param reference - reference of EtatDemande to be deleted
    * @return 1 if EtatDemande deleted successfully
    */
    int deleteByReference(String reference);





}
