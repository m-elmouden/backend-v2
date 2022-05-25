package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.PrelevementSocial;
import com.ird.faa.ws.rest.provided.vo.PrelevementSocialVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PrelevementSocialAdminService extends AbstractService<PrelevementSocial,Long,PrelevementSocialVo>{




/**
    * delete PrelevementSocial from database
    * @param id - id of PrelevementSocial to be deleted
    *
    */
    int deleteById(Long id);
    PrelevementSocial findByLibelle(String libelle);
PrelevementSocial findByReference(String reference);









}
