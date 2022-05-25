package com.ird.faa.service.chercheur.facade;

import com.ird.faa.bean.TypeTauxCnss;
import com.ird.faa.ws.rest.provided.vo.TypeTauxCnssVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeTauxCnssChercheurService extends AbstractService<TypeTauxCnss,Long,TypeTauxCnssVo>{




/**
    * delete TypeTauxCnss from database
    * @param id - id of TypeTauxCnss to be deleted
    *
    */
    int deleteById(Long id);









}
