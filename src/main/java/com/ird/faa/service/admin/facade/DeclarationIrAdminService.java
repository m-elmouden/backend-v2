package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.DeclarationIr;
import com.ird.faa.ws.rest.provided.vo.DeclarationIrVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DeclarationIrAdminService extends AbstractService<DeclarationIr,Long,DeclarationIrVo>{


    /**
    * find DeclarationIr from database by refrerence (reference)
    * @param refrerence - reference of DeclarationIr
    * @return the founded DeclarationIr , If no DeclarationIr were
    *         found in database return  null.
    */
    DeclarationIr findByRefrerence(String refrerence);

    /**
    * find DeclarationIr from database by id (PK) or refrerence (reference)
    * @param id - id of DeclarationIr
    * @param refrerence - reference of DeclarationIr
    * @return the founded DeclarationIr , If no DeclarationIr were
    *         found in database return  null.
    */
    DeclarationIr findByIdOrRefrerence(DeclarationIr declarationIr);


/**
    * delete DeclarationIr from database
    * @param id - id of DeclarationIr to be deleted
    *
    */
    int deleteById(Long id);



    List<DeclarationIr> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);
    List<DeclarationIr> findByEtatDeclarationIrReference(String reference);

    int deleteByEtatDeclarationIrReference(String reference);

    List<DeclarationIr> findByEtatDeclarationIrId(Long id);

    int deleteByEtatDeclarationIrId(Long id);
    List<DeclarationIr> findByPaiementDeclarationIrReference(String reference);

    int deleteByPaiementDeclarationIrReference(String reference);

    List<DeclarationIr> findByPaiementDeclarationIrId(Long id);

    int deleteByPaiementDeclarationIrId(Long id);


    /**
    * delete DeclarationIr from database by refrerence (reference)
    *
    * @param refrerence - reference of DeclarationIr to be deleted
    * @return 1 if DeclarationIr deleted successfully
    */
    int deleteByRefrerence(String refrerence);




    DeclarationIr archiver(DeclarationIr declarationIr) ;
    DeclarationIr desarchiver(DeclarationIr declarationIr);

}
