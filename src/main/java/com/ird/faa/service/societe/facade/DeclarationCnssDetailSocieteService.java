package com.ird.faa.service.societe.facade;

import java.util.List;
import com.ird.faa.bean.DeclarationCnssDetail;
import com.ird.faa.ws.rest.provided.vo.DeclarationCnssDetailVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DeclarationCnssDetailSocieteService extends AbstractService<DeclarationCnssDetail,Long,DeclarationCnssDetailVo>{


    /**
    * find DeclarationCnssDetail from database by ref (reference)
    * @param ref - reference of DeclarationCnssDetail
    * @return the founded DeclarationCnssDetail , If no DeclarationCnssDetail were
    *         found in database return  null.
    */
    DeclarationCnssDetail findByRef(String ref);

    /**
    * find DeclarationCnssDetail from database by id (PK) or ref (reference)
    * @param id - id of DeclarationCnssDetail
    * @param ref - reference of DeclarationCnssDetail
    * @return the founded DeclarationCnssDetail , If no DeclarationCnssDetail were
    *         found in database return  null.
    */
    DeclarationCnssDetail findByIdOrRef(DeclarationCnssDetail declarationCnssDetail);


/**
    * delete DeclarationCnssDetail from database
    * @param id - id of DeclarationCnssDetail to be deleted
    *
    */
    int deleteById(Long id);



    List<DeclarationCnssDetail> findByTypeTauxCnssId(Long id);

    int deleteByTypeTauxCnssId(Long id);
    List<DeclarationCnssDetail> findByDeclarationCnssRef(String ref);

    int deleteByDeclarationCnssRef(String ref);

    List<DeclarationCnssDetail> findByDeclarationCnssId(Long id);

    int deleteByDeclarationCnssId(Long id);


    /**
    * delete DeclarationCnssDetail from database by ref (reference)
    *
    * @param ref - reference of DeclarationCnssDetail to be deleted
    * @return 1 if DeclarationCnssDetail deleted successfully
    */
    int deleteByRef(String ref);




    DeclarationCnssDetail archiver(DeclarationCnssDetail declarationCnssDetail) ;
    DeclarationCnssDetail desarchiver(DeclarationCnssDetail declarationCnssDetail);

}
