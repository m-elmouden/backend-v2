package com.ird.faa.service.comptable.facade;

import java.util.List;
import com.ird.faa.bean.TypeDeclarationTva;
import com.ird.faa.ws.rest.provided.vo.TypeDeclarationTvaVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeDeclarationTvaComptableService extends AbstractService<TypeDeclarationTva,Long,TypeDeclarationTvaVo>{


    /**
    * find TypeDeclarationTva from database by reference (reference)
    * @param reference - reference of TypeDeclarationTva
    * @return the founded TypeDeclarationTva , If no TypeDeclarationTva were
    *         found in database return  null.
    */
    TypeDeclarationTva findByReference(String reference);

    /**
    * find TypeDeclarationTva from database by id (PK) or reference (reference)
    * @param id - id of TypeDeclarationTva
    * @param reference - reference of TypeDeclarationTva
    * @return the founded TypeDeclarationTva , If no TypeDeclarationTva were
    *         found in database return  null.
    */
    TypeDeclarationTva findByIdOrReference(TypeDeclarationTva typeDeclarationTva);


/**
    * delete TypeDeclarationTva from database
    * @param id - id of TypeDeclarationTva to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TypeDeclarationTva from database by reference (reference)
    *
    * @param reference - reference of TypeDeclarationTva to be deleted
    * @return 1 if TypeDeclarationTva deleted successfully
    */
    int deleteByReference(String reference);





}
