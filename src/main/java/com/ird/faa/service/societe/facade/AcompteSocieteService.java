package com.ird.faa.service.societe.facade;

import java.util.List;
import com.ird.faa.bean.Acompte;
import com.ird.faa.ws.rest.provided.vo.AcompteVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface AcompteSocieteService extends AbstractService<Acompte,Long,AcompteVo>{




/**
    * delete Acompte from database
    * @param id - id of Acompte to be deleted
    *
    */
    int deleteById(Long id);



    List<Acompte> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);






    Acompte archiver(Acompte acompte) ;
    Acompte desarchiver(Acompte acompte);

}
