package com.ird.faa.service.comptable.facade;

import com.ird.faa.bean.Acompte;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.AcompteVo;

import java.util.List;

public interface AcompteComptableService extends AbstractService<Acompte, Long, AcompteVo> {


    /**
     * delete Acompte from database
     *
     * @param id - id of Acompte to be deleted
     */
    int deleteById(Long id);


    List<Acompte> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);


    Acompte archiver(Acompte acompte);

    Acompte desarchiver(Acompte acompte);

}
