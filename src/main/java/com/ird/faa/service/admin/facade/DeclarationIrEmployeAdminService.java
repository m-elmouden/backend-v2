package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.DeclarationIrEmploye;
import com.ird.faa.ws.rest.provided.vo.DeclarationIrEmployeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DeclarationIrEmployeAdminService extends AbstractService<DeclarationIrEmploye,Long,DeclarationIrEmployeVo>{




/**
    * delete DeclarationIrEmploye from database
    * @param id - id of DeclarationIrEmploye to be deleted
    *
    */
    int deleteById(Long id);


    List<DeclarationIrEmploye> findByDeclarationIrRefrerence(String refrerence);

    int deleteByDeclarationIrRefrerence(String refrerence);

    List<DeclarationIrEmploye> findByDeclarationIrId(Long id);

    int deleteByDeclarationIrId(Long id);
    List<DeclarationIrEmploye> findByEmployeCin(String cin);

    int deleteByEmployeCin(String cin);

    List<DeclarationIrEmploye> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);

    List<DeclarationIrEmploye> findByTauxIrId(Long id);

    int deleteByTauxIrId(Long id);

    void CalculIr(DeclarationIrEmploye declarationIrEmploye);







}
