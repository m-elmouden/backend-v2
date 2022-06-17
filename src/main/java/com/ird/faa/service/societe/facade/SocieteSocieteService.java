package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.Societe;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.SocieteVo;

import java.util.List;

public interface SocieteSocieteService extends AbstractService<Societe, Long, SocieteVo> {

    Societe findByUsername(String username);


    /**
     * delete Societe from database
     *
     * @param id - id of Societe to be deleted
     */
    int deleteById(Long id);


    List<Societe> findByComptableCode(String code);

    int deleteByComptableCode(String code);

    List<Societe> findByComptableId(Long id);

    int deleteByComptableId(Long id);

    List<Societe> findByPresidentSocieteId(Long id);

    int deleteByPresidentSocieteId(Long id);

    List<Societe> findByTypeSocieteCode(String code);

    int deleteByTypeSocieteCode(String code);

    List<Societe> findByTypeSocieteId(Long id);

    int deleteByTypeSocieteId(Long id);


}
