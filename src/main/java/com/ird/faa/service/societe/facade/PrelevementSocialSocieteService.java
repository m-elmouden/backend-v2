package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.PrelevementSocial;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.PrelevementSocialVo;

public interface PrelevementSocialSocieteService extends AbstractService<PrelevementSocial, Long, PrelevementSocialVo> {


    /**
     * delete PrelevementSocial from database
     *
     * @param id - id of PrelevementSocial to be deleted
     */
    int deleteById(Long id);

    PrelevementSocial findByReference(String reference);


}
