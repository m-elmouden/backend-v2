package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.DeclarationIs;
import com.ird.faa.ws.rest.provided.vo.DeclarationIsVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DeclarationIsAdminService extends AbstractService<DeclarationIs,Long,DeclarationIsVo>{


    /**
    * find DeclarationIs from database by reference (reference)
    * @param reference - reference of DeclarationIs
    * @return the founded DeclarationIs , If no DeclarationIs were
    *         found in database return  null.
    */
    DeclarationIs findByReference(String reference);

    /**
    * find DeclarationIs from database by id (PK) or reference (reference)
    * @param id - id of DeclarationIs
    * @param reference - reference of DeclarationIs
    * @return the founded DeclarationIs , If no DeclarationIs were
    *         found in database return  null.
    */
    DeclarationIs findByIdOrReference(DeclarationIs declarationIs);


/**
    * delete DeclarationIs from database
    * @param id - id of DeclarationIs to be deleted
    *
    */
    int deleteById(Long id);



    List<DeclarationIs> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);
    List<DeclarationIs> findByTauxIsReference(String reference);

    int deleteByTauxIsReference(String reference);

    List<DeclarationIs> findByTauxIsId(Long id);

    int deleteByTauxIsId(Long id);
    List<DeclarationIs> findByTauxIsConfigReference(String reference);

    int deleteByTauxIsConfigReference(String reference);

    List<DeclarationIs> findByTauxIsConfigId(Long id);

    int deleteByTauxIsConfigId(Long id);
    List<DeclarationIs> findByEtatDeclarationIsReference(String reference);

    int deleteByEtatDeclarationIsReference(String reference);

    List<DeclarationIs> findByEtatDeclarationIsId(Long id);

    int deleteByEtatDeclarationIsId(Long id);
    List<DeclarationIs> findByPaiementDeclarationIsReference(String reference);

    int deleteByPaiementDeclarationIsReference(String reference);

    List<DeclarationIs> findByPaiementDeclarationIsId(Long id);

    int deleteByPaiementDeclarationIsId(Long id);


    /**
    * delete DeclarationIs from database by reference (reference)
    *
    * @param reference - reference of DeclarationIs to be deleted
    * @return 1 if DeclarationIs deleted successfully
    */
    int deleteByReference(String reference);




    DeclarationIs archiver(DeclarationIs declarationIs) ;
    DeclarationIs desarchiver(DeclarationIs declarationIs);

}
