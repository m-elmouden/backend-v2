package com.ird.faa.service.comptable.facade;

import java.util.List;
import com.ird.faa.bean.DeclarationCnss;
import com.ird.faa.ws.rest.provided.vo.DeclarationCnssVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DeclarationCnssComptableService extends AbstractService<DeclarationCnss,Long,DeclarationCnssVo>{


    /**
    * find DeclarationCnss from database by ref (reference)
    * @param ref - reference of DeclarationCnss
    * @return the founded DeclarationCnss , If no DeclarationCnss were
    *         found in database return  null.
    */
    DeclarationCnss findByRef(String ref);

    /**
    * find DeclarationCnss from database by id (PK) or ref (reference)
    * @param id - id of DeclarationCnss
    * @param ref - reference of DeclarationCnss
    * @return the founded DeclarationCnss , If no DeclarationCnss were
    *         found in database return  null.
    */
    DeclarationCnss findByIdOrRef(DeclarationCnss declarationCnss);


/**
    * delete DeclarationCnss from database
    * @param id - id of DeclarationCnss to be deleted
    *
    */
    int deleteById(Long id);


    List<DeclarationCnss> findByEmployeCin(String cin);

    int deleteByEmployeCin(String cin);

    List<DeclarationCnss> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);

    List<DeclarationCnss> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);


    /**
    * delete DeclarationCnss from database by ref (reference)
    *
    * @param ref - reference of DeclarationCnss to be deleted
    * @return 1 if DeclarationCnss deleted successfully
    */
    int deleteByRef(String ref);




    DeclarationCnss archiver(DeclarationCnss declarationCnss) ;
    DeclarationCnss desarchiver(DeclarationCnss declarationCnss);

}
