package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.PresidentSociete;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.PresidentSocieteVo;

import java.util.List;

public interface PresidentSocieteSocieteService extends AbstractService<PresidentSociete, Long, PresidentSocieteVo> {


    /**
     * delete PresidentSociete from database
     *
     * @param id - id of PresidentSociete to be deleted
     */
    int deleteById(Long id);


    List<PresidentSociete> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);


}
