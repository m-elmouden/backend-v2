package com.ird.faa.service.comptable.facade;

import java.util.List;
import com.ird.faa.bean.PrelevementSocial;
import com.ird.faa.ws.rest.provided.vo.PrelevementSocialVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PrelevementSocialComptableService extends AbstractService<PrelevementSocial,Long,PrelevementSocialVo>{




/**
    * delete PrelevementSocial from database
    * @param id - id of PrelevementSocial to be deleted
    *
    */
    int deleteById(Long id);









}
