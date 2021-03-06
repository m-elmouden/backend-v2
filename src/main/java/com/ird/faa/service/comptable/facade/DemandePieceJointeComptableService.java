package com.ird.faa.service.comptable.facade;

import com.ird.faa.bean.DemandePieceJointe;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.DemandePieceJointeVo;

import java.util.List;

public interface DemandePieceJointeComptableService extends AbstractService<DemandePieceJointe, Long, DemandePieceJointeVo> {


    /**
     * delete DemandePieceJointe from database
     *
     * @param id - id of DemandePieceJointe to be deleted
     */
    int deleteById(Long id);


    List<DemandePieceJointe> findByDemandeReference(String reference);

    int deleteByDemandeReference(String reference);

    List<DemandePieceJointe> findByDemandeId(Long id);

    int deleteByDemandeId(Long id);


}
