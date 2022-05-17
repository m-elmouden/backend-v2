package com.ird.faa.service.societe.facade;

import java.util.List;
import com.ird.faa.bean.TypeTauxCnss;
import com.ird.faa.ws.rest.provided.vo.TypeTauxCnssVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeTauxCnssSocieteService extends AbstractService<TypeTauxCnss,Long,TypeTauxCnssVo>{




/**
    * delete TypeTauxCnss from database
    * @param id - id of TypeTauxCnss to be deleted
    *
    */
    int deleteById(Long id);








    TypeTauxCnss archiver(TypeTauxCnss typeTauxCnss) ;
    TypeTauxCnss desarchiver(TypeTauxCnss typeTauxCnss);

}