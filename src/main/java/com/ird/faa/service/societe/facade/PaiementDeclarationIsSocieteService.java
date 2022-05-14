package com.ird.faa.service.societe.facade;

import java.util.List;
import com.ird.faa.bean.PaiementDeclarationIs;
import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationIsVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PaiementDeclarationIsSocieteService extends AbstractService<PaiementDeclarationIs,Long,PaiementDeclarationIsVo>{


    /**
    * find PaiementDeclarationIs from database by reference (reference)
    * @param reference - reference of PaiementDeclarationIs
    * @return the founded PaiementDeclarationIs , If no PaiementDeclarationIs were
    *         found in database return  null.
    */
    PaiementDeclarationIs findByReference(String reference);

    /**
    * find PaiementDeclarationIs from database by id (PK) or reference (reference)
    * @param id - id of PaiementDeclarationIs
    * @param reference - reference of PaiementDeclarationIs
    * @return the founded PaiementDeclarationIs , If no PaiementDeclarationIs were
    *         found in database return  null.
    */
    PaiementDeclarationIs findByIdOrReference(PaiementDeclarationIs paiementDeclarationIs);


/**
    * delete PaiementDeclarationIs from database
    * @param id - id of PaiementDeclarationIs to be deleted
    *
    */
    int deleteById(Long id);


    List<PaiementDeclarationIs> findByDeclarationIsReference(String reference);

    int deleteByDeclarationIsReference(String reference);

    List<PaiementDeclarationIs> findByDeclarationIsId(Long id);

    int deleteByDeclarationIsId(Long id);


    /**
    * delete PaiementDeclarationIs from database by reference (reference)
    *
    * @param reference - reference of PaiementDeclarationIs to be deleted
    * @return 1 if PaiementDeclarationIs deleted successfully
    */
    int deleteByReference(String reference);





}
