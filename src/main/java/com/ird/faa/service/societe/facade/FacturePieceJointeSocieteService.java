package com.ird.faa.service.societe.facade;

import java.util.List;
import com.ird.faa.bean.FacturePieceJointe;
import com.ird.faa.ws.rest.provided.vo.FacturePieceJointeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface FacturePieceJointeSocieteService extends AbstractService<FacturePieceJointe,Long,FacturePieceJointeVo>{




/**
    * delete FacturePieceJointe from database
    * @param id - id of FacturePieceJointe to be deleted
    *
    */
    int deleteById(Long id);


    List<FacturePieceJointe> findByFactureReference(String reference);

    int deleteByFactureReference(String reference);

    List<FacturePieceJointe> findByFactureId(Long id);

    int deleteByFactureId(Long id);







}
