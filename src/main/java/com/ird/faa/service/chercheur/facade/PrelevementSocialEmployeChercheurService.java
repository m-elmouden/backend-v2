package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.PrelevementSocialEmploye;
import com.ird.faa.ws.rest.provided.vo.PrelevementSocialEmployeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PrelevementSocialEmployeChercheurService extends AbstractService<PrelevementSocialEmploye,Long,PrelevementSocialEmployeVo>{




/**
    * delete PrelevementSocialEmploye from database
    * @param id - id of PrelevementSocialEmploye to be deleted
    *
    */
    int deleteById(Long id);



    List<PrelevementSocialEmploye> findByPrelevementSocialId(Long id);

    int deleteByPrelevementSocialId(Long id);
    List<PrelevementSocialEmploye> findByEmployeCin(String cin);

    int deleteByEmployeCin(String cin);

    List<PrelevementSocialEmploye> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);
    List<PrelevementSocialEmploye> findByDeclarationIrRefrerence(String refrerence);

    int deleteByDeclarationIrRefrerence(String refrerence);

    List<PrelevementSocialEmploye> findByDeclarationIrId(Long id);

    int deleteByDeclarationIrId(Long id);







}
